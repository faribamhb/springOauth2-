package com.iranargham.atmmonitoring.rest;


import com.iranargham.atmmonitoring.dto.TokenDto;
import com.iranargham.atmmonitoring.exceptions.ErrorCodes;
import com.iranargham.atmmonitoring.exceptions.ServiceException;
import com.iranargham.atmmonitoring.service.TokenService;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path = "/api/v1")
public class TokenController {
    private static final Logger logger = LoggerFactory.getLogger(TokenController.class);
    private final TokenService tokenService ;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/getToken")
    public TokenDto obtainAccessToken(@RequestParam String userName,
                                      @RequestParam String password) throws ServiceException {
        return tokenService.getToke(userName, password);


    }



    @PostMapping("/getRefreshToken")
    public TokenDto obtainRefreshToken(@RequestParam @Validated String refreshToken) throws ServiceException {
        logger.info("Request to get refresh token  ");
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "refresh_token");
        params.put("client_id", "web");
        params.put("refresh_token", refreshToken);
        Response response = RestAssured.given().auth().preemptive()
                .basic("web", "secret").and().with().params(params)
                .when()
                .post("http://localhost:8185/oauth/token");

        if (response.getStatusCode() != 200) {
            throw new ServiceException("Invalid refresh token", ErrorCodes.INVALID_REFRESH_TOKEN.getCode());
        }
        String accessToken = response.jsonPath().getString("access_token");

        return TokenDto.builder().accessToken(accessToken).refreshToken(refreshToken).build();


    }


}




