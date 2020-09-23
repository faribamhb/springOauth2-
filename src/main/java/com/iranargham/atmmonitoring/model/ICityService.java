package com.iranargham.atmmonitoring.model;

import org.springframework.stereotype.Component;

import java.util.List;
public interface ICityService {
    List<City> findAll();
}
