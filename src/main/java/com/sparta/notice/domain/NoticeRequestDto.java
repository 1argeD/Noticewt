package com.sparta.notice.domain;


import lombok.Getter;

@Getter
public class NoticeRequestDto {
    private final String Success = String.valueOf(true);
    private String title;
    private String content;
    private String password;
    private String author;
//    private final String error = null;
}
