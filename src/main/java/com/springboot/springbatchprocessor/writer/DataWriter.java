package com.springboot.springbatchprocessor.writer;

import com.springboot.springbatchprocessor.entity.BizData;
import com.springboot.springbatchprocessor.repo.SearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class DataWriter implements ItemWriter<BizData> {

    @Autowired
    SearchRepository searchRepository;

    AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void write(List<? extends BizData> list) throws Exception {
        searchRepository.saveAll(list);
        atomicInteger.getAndAdd(list.size());
        log.info("Data Counter value is " + atomicInteger.get());
    }
}
