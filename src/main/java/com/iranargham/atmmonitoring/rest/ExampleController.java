package com.iranargham.atmmonitoring.rest;

import com.iranargham.atmmonitoring.model.City;
import com.iranargham.atmmonitoring.service.CityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {



 private final CityService cityService;

    public ExampleController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/cities")
    @PreAuthorize("isAuthenticated()")
    public List<City> getCities(@RequestHeader String Authorization) {

        List<City> cities = cityService.findAll();

        return cities;
    }
}
