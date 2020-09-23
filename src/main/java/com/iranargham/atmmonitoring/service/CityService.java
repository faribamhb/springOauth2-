package com.iranargham.atmmonitoring.service;

import com.iranargham.atmmonitoring.model.City;
import com.iranargham.atmmonitoring.model.ICityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CityService implements ICityService {
    private static final Logger logger = LoggerFactory.getLogger(CityService.class);

    @Override
    public List<City> findAll() {

        logger.info("i love you");
        List<City> cities = new ArrayList<>();

        cities.add(new City(1L, "Bratislava", 432000));
        cities.add(new City(2L, "Budapest", 1759000));
        cities.add(new City(3L, "Prague", 1280000));
        cities.add(new City(4L, "Warsaw", 1748000));
        cities.add(new City(5L, "Los Angeles", 3971000));
        cities.add(new City(6L, "New York", 8550000));
        cities.add(new City(7L, "Edinburgh", 464000));
        cities.add(new City(8L, "Berlin", 3671000));

        return cities;
    }
}
