package com.sparta.notice.service;

import com.sparta.notice.domain.Notice;
import com.sparta.notice.domain.NoticeRepository;
import com.sparta.notice.domain.NoticeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public Long update(Long id, NoticeRequestDto requestDto) {
        Notice notice = noticeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        notice.update(requestDto);
        return notice.getId();
    }
    @Transactional
    public boolean isValidPassword(String password, Long id) {
        Notice notice  = noticeRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        boolean isEq = Objects.equals(notice.getPassword(), password);
        System.out.println("date:true");
        return isEq;
        }
    }

