package com.example.deliveryapi.dto;

import com.example.deliveryapi.model.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
public class SignupRequestDto {


    private String username;
    private String password;
    private String nickname;
    private String ownerName;
    private boolean admin = false;
    private String adminToken = "";
}