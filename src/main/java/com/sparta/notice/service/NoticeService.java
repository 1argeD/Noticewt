package com.sparta.notice.service;

import com.sparta.notice.Dto.NoticeRequestDto;
import com.sparta.notice.model.Notice;
import com.sparta.notice.Reposirtory.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private UserDetails users;

    @Transactional
    public Notice update(@AuthenticationPrincipal UserDetails users) {
        Notice notice = noticeRepository.findById(Long.valueOf(users.getUsername())).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        NoticeRequestDto NoticeRequestDto =new NoticeRequestDto();
        notice.update(NoticeRequestDto);
        return notice;
    }
    @Transactional
    public boolean isValidPassword(@AuthenticationPrincipal String users) {
        Notice notice  = noticeRepository.findById(Long.valueOf(users)).orElseThrow(
            () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        boolean isEq = Objects.equals(users, noticeRepository.getPassword());
        System.out.println("a");
        return isEq;
        }

    @Transactional
    public boolean isValidUsername(@AuthenticationPrincipal UserDetails users) {
        Notice notice  = noticeRepository.findById(Long.valueOf(users.getUsername())).orElseThrow(
                () -> new IllegalArgumentException("")
        );
        boolean isEq = Objects.equals(users.getUsername(), noticeRepository.getUsername());
        System.out.println("b");
        return isEq;
    }

    @Transactional
    public boolean isValidPassword(@AuthenticationPrincipal UserDetails users) {
        Notice notice  = noticeRepository.findById(Long.valueOf(users.getUsername())).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        boolean isEq = Objects.equals(users.getPassword(), noticeRepository.getPassword());
        System.out.println("a");
        return isEq;
    }

}

