package com.springboot.springbatchprocessor.resource;

import com.springboot.springbatchprocessor.entity.BizData;
import com.springboot.springbatchprocessor.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "Single column search" , description = "Provide facility for single column search by value")
public class SearchResource {

    private static final String DATA_SEARCH_LOGGER = "DATA_SEARCH_LOGGER";

    @Autowired
    private SearchService searchService;

    @GetMapping("/companyName")
    @Operation(summary = "Get BizData for provided value of column CompanyName")
    public ResponseEntity<List<BizData>> getByCompanyName(@RequestParam("companyName") String companyName) {
        List<BizData> byCompanyName = searchService.findByCompanyName(companyName);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from getByCompanyName: "+ byCompanyName.size());
        return ResponseEntity.ok(byCompanyName);
    }

    @GetMapping("/hotelType")
    @Operation(summary = "Get BizData for provided value of column HotelType")
    public ResponseEntity<List<BizData>> findByHotelType(@RequestParam("hotelType") String hotelType) {
        List<BizData> byHotelType = searchService.findByHotelType(hotelType);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByHotelType: "+ byHotelType.size());
        return ResponseEntity.ok(byHotelType);
    }

    @GetMapping("/country")
    @Operation(summary = "Get BizData for provided value of column Country")
    public ResponseEntity<List<BizData>> findByCountry(String country) {
        List<BizData> byCountry = searchService.findByCountry(country);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByCountry: "+ byCountry.size());
        return ResponseEntity.ok(byCountry);
    }

    @GetMapping("/state")
    @Operation(summary = "Get BizData for provided value of column State")
    public ResponseEntity<List<BizData>> findByState(String state) {
        List<BizData> list = searchService.findByState(state);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByState: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/city")
    @Operation(summary = "Get BizData for provided value of column City")
    public ResponseEntity<List<BizData>> findByCity(String city) {
        List<BizData> list = searchService.findByCity(city);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByCity: "+ list.size());
        return ResponseEntity.ok(list);
    }
    @GetMapping("/personCountry")
    @Operation(summary = "Get BizData for provided value of column PersonCountry")
    public ResponseEntity<List<BizData>> findByPersonCountry(@RequestParam("personCountry") String personCountry) {
        List<BizData> list = searchService.findByPersonCountry(personCountry);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByPersonCountry: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/personState")
    @Operation(summary = "Get BizData for provided value of column PersonState")
    public ResponseEntity<List<BizData>> findByPersonState(@RequestParam("personState") String personState) {
        List<BizData> list = searchService.findByPersonState(personState);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByPersonState: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/foundedYear")
    @Operation(summary = "Get BizData for provided value of column FoundedYear")
    public ResponseEntity<List<BizData>> findByFoundedYear(@RequestParam("foundedYear") String foundedYear) {
        List<BizData> list = searchService.findByFoundedYear(foundedYear);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByFoundedYear: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/technology")
    @Operation(summary = "Get BizData for provided value of column Technology")
    public ResponseEntity<List<BizData>> findByTechnology(@RequestParam("technology") String technology) {
        List<BizData> list = searchService.findByTechnology(technology);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByTechnology: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/countryCode")
    @Operation(summary = "Get BizData for provided value of column CountryCode")
    public ResponseEntity<List<BizData>> findByCountryCode(@RequestParam("countryCode") String countryCode) {
        List<BizData> list = searchService.findByCountryCode(countryCode);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByCountryCode: "+ list.size());
        return ResponseEntity.ok(list);
    }

}
