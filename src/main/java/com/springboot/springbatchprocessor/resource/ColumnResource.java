package com.springboot.springbatchprocessor.resource;

import com.springboot.springbatchprocessor.service.ColumnValueService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/distinct/")
@Tag(name = "Unique value for column" , description = "Provide the unique value of column present")
public class ColumnResource {

    private static final String DATA_SEARCH_LOGGER = "DATA_SEARCH_LOGGER";
    @Autowired
    private ColumnValueService columnValueService;

    @GetMapping("/hotelType")
    @Operation(summary = "Get the unique value for column HotelType")
    ResponseEntity<List<String>> findByHotelType() {
        List<String> byHotelType = columnValueService.findByHotelType();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from getByCompanyName: "+ byHotelType.size());
        return ResponseEntity.ok(byHotelType);
    }

    @Operation(summary = "Get the unique value for column companyName")
    @GetMapping("/companyName")
    ResponseEntity<List<String>> findByCompanyName() {
        List<String> byCompanyName = columnValueService.findByCompanyName();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from getByCompanyName: "+ byCompanyName.size());
        return ResponseEntity.ok(byCompanyName);
    }

    @Operation(summary = "Get the unique value for column Country")
    @GetMapping("/country")
    ResponseEntity<List<String>> findByCountry() {
        List<String> list = columnValueService.findByCountry();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByCountry: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get the unique value for column State")
    @GetMapping("/state")
    ResponseEntity<List<String>> findByState() {
        List<String> list = columnValueService.findByState();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByState: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get the unique value for column City")
    @GetMapping("/city")
    ResponseEntity<List<String>> findByCity() {
        List<String> list = columnValueService.findByCity();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByCity: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get the unique value for column PersonCountry")
    @GetMapping("/personCountry")
    ResponseEntity<List<String>> findByPersonCountry() {
        List<String> list = columnValueService.findByPersonCountry();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByPersonCountry: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get the unique value for column PersonCity")
    @GetMapping("/personCity")
    ResponseEntity<List<String>> findByPersonCity() {
        List<String> list = columnValueService.findByPersonCity();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByPersonCity: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get the unique value for column PersonState")
    @GetMapping("/personState")
    ResponseEntity<List<String>> findByPersonState() {
        List<String> list = columnValueService.findByPersonState();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByPersonState: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get the unique value for column FoundedYear")
    @GetMapping("/foundedYear")
    ResponseEntity<List<String>> findByFoundedYear() {
        List<String> list = columnValueService.findByFoundedYear();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByFoundedYear: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get the unique value for column Technology")
    @GetMapping("/technology")
    ResponseEntity<List<String>> findByTechnology() {
        List<String> list = columnValueService.findByTechnology();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByTechnology: "+ list.size());
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get the unique value for column CountryCode")
    @GetMapping("/countryCode")
    ResponseEntity<List<String>> findByCountryCode() {
        List<String> list = columnValueService.findByCountryCode();
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from findByCountryCode: "+ list.size());
        return ResponseEntity.ok(list);
    }

}
