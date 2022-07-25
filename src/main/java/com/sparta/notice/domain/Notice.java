package com.sparta.notice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
public class Notice extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    public Notice(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.password = password;
        this.author = author;
    }

    public Notice(NoticeRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
        this.author = requestDto.getAuthor();
    }

    public void update(NoticeRequestDto requestDto) {
       this.title = requestDto.getTitle();
       this.content = requestDto.getContent();
       this.password = requestDto.getPassword();
       this.author = requestDto.getAuthor();

    }

}

