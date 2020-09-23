package com.iranargham.atmmonitoring.service;


import com.iranargham.atmmonitoring.dto.TokenDto;
import com.iranargham.atmmonitoring.exceptions.ErrorCodes;
import com.iranargham.atmmonitoring.exceptions.ServiceException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {
    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

    public TokenDto getToke(@RequestParam String userName, @RequestParam String password) throws ServiceException {
        logger.info("Request to get token by userName: " + userName);
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("client_id", "web");
        params.put("username", userName);
        params.put("password", password);
        Response response = RestAssured.given().auth().preemptive()
                .basic("web", "secret").and().with().params(params)
                .when()
                .post("http://localhost:8185/oauth/token");

        logger.info("sss"+ response.getStatusCode());
        if (response.getStatusCode() != 200) {
            throw new ServiceException("Username or password is not valid", ErrorCodes.NO_USER.getCode());
        }
        String accessToken = response.jsonPath().getString("access_token");
        String refreshToken = response.jsonPath().getString("refresh_token");
        String expireTime = response.jsonPath().getString("expires_in");
        return TokenDto.builder()
                .accessToken(accessToken).refreshToken(refreshToken).expireTime(expireTime)
                .build();
    }
}
