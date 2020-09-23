package com.iranargham.atmmonitoring;

import com.iranargham.atmmonitoring.rest.ExampleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class AtmMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtmMonitoringApplication.class, args);
    }

}
