package com.sparta.notice.domain;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class NoticeContainer<T> {

    private boolean success;

    private T data;

    private String error;
    public NoticeContainer(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }
}
