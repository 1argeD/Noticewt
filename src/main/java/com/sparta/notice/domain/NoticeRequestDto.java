package com.sparta.notice.domain;


import lombok.Getter;

@Getter
public class NoticeRequestDto {
    private String title;
    private String content;
    private String password;
    private String author;
}
