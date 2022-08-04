package com.sparta.notice.Dto;


import lombok.Getter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Getter
@EnableJpaRepositories
public class NoticeRequestDto {
    private String title;
    private String content;
    private String password;
    private String author;
    private String username;
}
