package com.springboot.springbatchprocessor.processor;

import com.springboot.springbatchprocessor.entity.BizData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class DataProcessor implements ItemProcessor<BizData, BizData> {
    @Override
    public BizData process(BizData sales) throws Exception {
        //sales.setLinkedIn_URL("");
        return sales;
    }
}
