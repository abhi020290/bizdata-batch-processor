package com.springboot.springbatchprocessor.resource;

import com.springboot.springbatchprocessor.entity.BizData;
import com.springboot.springbatchprocessor.repo.SearchNativeRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/criteria/")
@Tag(name = "Multiple column search" , description = "Provide facility for multiple column search by values")
public class CriteriaSearchResource {

    @Autowired
    private SearchNativeRepo searchNativeRepo;

    private static final String DATA_SEARCH_LOGGER = "DATA_SEARCH_LOGGER";

    @GetMapping("/personCountry")
    @Operation(summary = "Provide values in different text box for searching data ")
    public ResponseEntity<List<BizData>> getBySearchCriteria(@RequestParam("companyName") Optional<String> companyName,
                                                             @RequestParam("country") Optional<String> country,
                                                             @RequestParam("state") Optional<String> state,
                                                             @RequestParam("city") Optional<String> city,
                                                             @RequestParam("technology") Optional<String> technology,
                                                             @RequestParam("personCountry") Optional<String> personCountry
    ) {
        HashMap<String, String> map = new HashMap();
        map.put("companyName", companyName.orElse(null));
        map.put("country", country.orElse(null));
        map.put("state", state.orElse(null));
        map.put("city", city.orElse(null));
        map.put("technology", technology.orElse(null));
        map.put("personCountry", personCountry.orElse(null));
        List<BizData> list = searchNativeRepo.getBySearchCriteria(map);
        log.info(DATA_SEARCH_LOGGER + " | " + " Response from getBySearchCriteria: " + list.size());
        return ResponseEntity.ok(list);
    }
}
