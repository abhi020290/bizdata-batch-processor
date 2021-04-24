package com.springboot.springbatchprocessor.config;

import com.springboot.springbatchprocessor.entity.BizData;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

 /*   @Value("${csv.file.path}")
    public String filePath;
*/
    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, ItemReader<BizData> itemReader,
                   ItemProcessor<BizData, BizData> itemProcessor, ItemWriter<BizData> itemWriter) {
        return jobBuilderFactory.get("Job-batch-processing")
                .incrementer(new RunIdIncrementer())
                .start(step(stepBuilderFactory, itemReader, itemProcessor, itemWriter))
                .build();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory, ItemReader<BizData> itemReader,
                     ItemProcessor<BizData, BizData> itemProcessor, ItemWriter<BizData> itemWriter) {
        return stepBuilderFactory.get("Step-batch-processing")
                .<BizData, BizData>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<BizData> flatFileItemReader(@Value("#{jobParameters['filePath']}")String filePath) {
        FlatFileItemReader<BizData> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource(filePath));
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        flatFileItemReader.setName("CSV-Flat File Reader");
        flatFileItemReader.setStrict(false);
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<BizData> lineMapper() {
        DefaultLineMapper<BizData> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        BeanWrapperFieldSetMapper<BizData> beanWrapperFieldExtractor = new BeanWrapperFieldSetMapper<>();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setNames("Company Name", "Website", "Technology Type", "Technology Used", "Booking Engine", "Industry", "Business Solution", "Employee Size", "Employee Range", "Address_1", "Address_2", "Country", "State", "City", "Subscription","First Name",
                "Last Name","LinkedIn_URL","Email_Id","Job Title","Contact_Number","Direct_Number","Person Country",
                "Person State","Person City","Revenue","Job URL","Job Opening","Number Of Rooms","Star Ratings","Review Ratings",
                "PMS","Hotel Name","Hotel Type","POW","Assesment Tool","Founded Year","Comment","ModifiedOn",
                "Technology","Zip Code","Gender","Actual_Revenue","Revenue_Range","Public_Profile","Country Code","Update Location Status");

        lineTokenizer.setStrict(false);

        beanWrapperFieldExtractor.setTargetType(BizData.class);

        lineMapper.setFieldSetMapper(beanWrapperFieldExtractor);
        lineMapper.setLineTokenizer(lineTokenizer);
        return lineMapper;
    }

}
