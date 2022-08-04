package com.sparta.notice.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
@Service
@Setter
@Getter
public class SignupRequestDto {


    public boolean PW(String password){
        return Pattern.matches("[a-z0-9]{4,32},*$", password);
    }
    public boolean Id(String username){
        return Pattern.matches("[a-zA-Z0-9]{4,12},*$", username);
    }
    private String username;
    private String password;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}