package com.springboot.springbatchprocessor.resource;

import com.springboot.springbatchprocessor.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
@Tag(name = "Start Data ingestion" , description = "Data present in files will loaded in database")
public class JobResource {
    private static final String DATA_INSERTION = "DATA_INSERTION";

    @Autowired
    public JobLauncher jobLauncher;

    @Autowired
    private SearchService searchService;

    @Value("${inbound.path}")
    String inboundDir;

    @Value("${archive.path}")
    String archiveDir;

    @Autowired
    public Job job;

    List<JobExecution> jobExecutions = new ArrayList<>();
    List<String> filesCompletion = new ArrayList<>();
    List<String> failedFiles = new ArrayList<>();

    private void launchJobProcessing(File filePath) throws IOException {
        File processFile = new File(archiveDir + "/" + filePath.getName());
        //FileUtils.moveFile(filePath, processFile);
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .addString("filePath", filePath.getAbsolutePath())
                .addString("fileName", filePath.getName())
                .toJobParameters();

        try {
            synchronized (jobExecutions) {
                JobExecution jobExecution = jobLauncher.run(job, jobParameters);
                jobExecutions.add(jobExecution);
            }
        } catch (Exception e) {
            log.error(DATA_INSERTION + " | " + " Error occurred while launchJobProcessing for file : " + e.getMessage());
            failedFiles.add(filePath.getName());
        }
    }

    private void checkJobStatus() {
        List<JobExecution> completedJobs = new ArrayList<>();
        jobExecutions.forEach(jobExecution -> {
            if (!jobExecution.isRunning()) {
                completedJobs.add(jobExecution);
                filesCompletion.add(jobExecution.getJobParameters().getString("fileName"));
            }
        });
        log.info(DATA_INSERTION + " | " + "Removing completed Jobs from jobExecution list " + completedJobs.size());
        jobExecutions.removeAll(completedJobs);
    }

    @GetMapping("/startDataProcessing")
    @Operation(summary = "Start processing the data to DB")
    public ResponseEntity<Map<String, String>> startDataProcessing() {
        File dir = new File(inboundDir);
        Map<String, String> hashMap = new HashMap<>();
        AtomicInteger count = new AtomicInteger();
        log.info("Directory path : "+dir);
        File[] files = dir.listFiles();
        log.info(DATA_INSERTION + " | " + " Number of Files count from inbound dir : " + files.length);

        Arrays.stream(files).forEach(file -> {
            String fileName = file.getName();
            log.info(DATA_INSERTION + " | " + " Starting Data Inserting for file : " + fileName);
            try {
                if (jobExecutions.size() == 5) {
                    checkJobStatus();
                }
                launchJobProcessing(file);
            } catch (Exception e) {
                failedFiles.add(file.getName());
                log.error(DATA_INSERTION + " | " + " Error occurred while startDataProcessing for file : " + e.getMessage());
            }
        });
        hashMap.put("Total files received ", String.valueOf(files.length));
        hashMap.put("Successfully files count", String.valueOf(filesCompletion.size()));
        hashMap.put("Failed files count", String.valueOf(failedFiles.size()));

        return ResponseEntity.ok(hashMap);
    }

    @GetMapping("/count")
    @Operation(summary = "Get Total Count of data present in database")
    public ResponseEntity<String> getDataCount() {
        long count = searchService.count();
        return ResponseEntity.ok("Total count of data present is : " +count);
    }

}
