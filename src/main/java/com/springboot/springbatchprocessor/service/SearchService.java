package com.springboot.springbatchprocessor.service;

import com.springboot.springbatchprocessor.entity.BizData;
import com.springboot.springbatchprocessor.repo.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public List<BizData> findByCompanyName(String companyName) {
        return searchRepository.findByCompanyName(companyName);
    }

    public List<BizData> findByHotelType(String hotelType) {
        return searchRepository.findByHotelType(hotelType);
    }

    public List<BizData> findByCountry(String country) {
        return searchRepository.findByCountry(country);
    }

    public List<BizData> findByState(String state) {
        return searchRepository.findByState(state);
    }

    public List<BizData> findByCity(String city) {
        return searchRepository.findByCity(city);
    }

    public List<BizData> findByPersonCountry(String personCountry) {
        return searchRepository.findByPersonCountry(personCountry);
    }

    public List<BizData> findByPersonCity(String personCity) {
        return searchRepository.findByPersonCity(personCity);
    }

    public List<BizData> findByPersonState(String personState) {
        return searchRepository.findByPersonState(personState);
    }

    public List<BizData> findByFoundedYear(String foundedYear) {
        return searchRepository.findByFoundedYear(foundedYear);
    }

    public List<BizData> findByTechnology(String technology) {
        return searchRepository.findByTechnology(technology);
    }

    public List<BizData> findByCountryCode(String countryCode) {
        return searchRepository.findByCountryCode(countryCode);
    }

    public long count() {
        return searchRepository.count();
    }
}
