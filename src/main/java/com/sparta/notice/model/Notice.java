package com.sparta.notice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.notice.Dto.NoticeRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
public class Notice extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

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

    public void info(@AuthenticationPrincipal UserDetails users) {
        this.username = users.getUsername();
    }
}

