package com.iranargham.atmmonitoring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto implements Serializable {
    private String accessToken;
    private String refreshToken;
    private String expireTime;
}
