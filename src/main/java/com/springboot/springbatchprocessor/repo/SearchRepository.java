package com.springboot.springbatchprocessor.repo;

import com.springboot.springbatchprocessor.entity.BizData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchRepository extends JpaRepository<BizData,Long> {

    @Query("select b from BizData b where upper(b.companyName) = upper(?1)")
    List<BizData> findByCompanyName(String companyName);

    @Query("select b from BizData b where upper(b.country) = upper(?1)")
    List<BizData> findByCountry(String country);

    @Query("select b from BizData b where upper(b.state) = upper(?1)")
    List<BizData> findByState(String state);

    @Query("select b from BizData b where upper(b.city) = upper(?1)")
    List<BizData> findByCity(String city);

    @Query("select b from BizData b where upper(b.personCountry) = upper(?1)")
    List<BizData> findByPersonCountry(String personCountry);

    @Query("select b from BizData b where upper(b.personCity) = upper(?1)")
    List<BizData> findByPersonCity(String personCity);

    @Query("select b from BizData b where upper(b.personState) = upper(?1)")
    List<BizData> findByPersonState(String personState);

    @Query("select b from BizData b where UPPER(b.hotelType) = UPPER(?1)")
    List<BizData> findByHotelType(String hotelType);

    @Query("select b from BizData b where upper(b.foundedYear) = upper(?1)")
    List<BizData> findByFoundedYear(String foundedYear);

    @Query("select b from BizData b where upper(b.technology) = upper(?1)")
    List<BizData> findByTechnology(String technology);

    @Query("select b from BizData b where upper(b.countryCode) = upper(?1)")
    List<BizData> findByCountryCode(String countryCode);

}
