package com.springboot.springbatchprocessor.service;

import com.springboot.springbatchprocessor.repo.ColumnValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnValueService {

    @Autowired
    private ColumnValueRepository columnCountRepository;

    public List<String> findByCompanyName() {
        return columnCountRepository.findByCompanyName();

    }

    public List<String> findByCountry() {
        return columnCountRepository.findByCountry();

    }

    public List<String> findByState() {
        return columnCountRepository.findByState();

    }

    public List<String> findByCity() {
        return columnCountRepository.findByCity();

    }

    public List<String> findByPersonCountry() {
        return columnCountRepository.findByPersonCountry();
    }

    public List<String> findByPersonCity() {
        return columnCountRepository.findByPersonCity();
    }

    public List<String> findByPersonState() {
        return columnCountRepository.findByPersonState();
    }

    public List<String> findByHotelType() {
        return columnCountRepository.findByHotelType();
    }

    public List<String> findByFoundedYear() {
        return columnCountRepository.findByFoundedYear();
    }

    public List<String> findByTechnology() {
        return columnCountRepository.findByTechnology();
    }

    public List<String> findByCountryCode() {
        return columnCountRepository.findByCountryCode();
    }
}
