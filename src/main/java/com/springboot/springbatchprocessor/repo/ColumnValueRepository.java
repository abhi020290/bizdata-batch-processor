package com.springboot.springbatchprocessor.repo;

import com.springboot.springbatchprocessor.entity.BizData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColumnValueRepository extends JpaRepository<BizData,Long> {

    @Query("select distinct(b.companyName) from BizData b")
    List<String> findByCompanyName();

    @Query("select distinct(b.country) from BizData b")
    List<String> findByCountry();

    @Query("select distinct(b.state) from BizData b")
    List<String> findByState();

    @Query("select distinct(b.city) from BizData b")
    List<String> findByCity();

    @Query("select distinct(b.personCountry) from BizData b")
    List<String> findByPersonCountry();

    @Query("select distinct(b.personCity) from BizData b")
    List<String> findByPersonCity();

    @Query("select distinct(b.personState) from BizData b")
    List<String> findByPersonState();

    @Query("select DISTINCT(b.hotelType) from BizData b")
    List<String> findByHotelType();

    @Query("select distinct(b.foundedYear) from BizData b")
    List<String> findByFoundedYear();

    @Query("select distinct(b.technology) from BizData b")
    List<String> findByTechnology();

    @Query("select distinct(b.countryCode) from BizData b")
    List<String> findByCountryCode();
    
}
