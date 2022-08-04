package com.sparta.notice.Controller;
;
import com.sparta.notice.model.Notice;
import com.sparta.notice.Dto.NoticeContainer;
import com.sparta.notice.Reposirtory.NoticeRepository;
import com.sparta.notice.Dto.NoticeRequestDto;

import com.sparta.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class NoticeController {

    private final NoticeRepository noticeRepository;

    private final NoticeService noticeService;


    @PostMapping("/api/auth/post")
    public NoticeContainer<Notice> createNotice(@RequestBody @AuthenticationPrincipal UserDetails users) {
        Notice notice = null;
        try {
            notice = new Notice((NoticeRequestDto) users);
            noticeRepository.save(notice);
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        return new NoticeContainer<>(true, notice, null);
    }

    @GetMapping("/api/post")
    public NoticeContainer<List<Notice>> getNotices() {
        List<Notice> notice = null;
        try {
            notice = noticeRepository.findAllByOrderByModifiedAtDesc();
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        return new NoticeContainer<>(true, notice, null);
    }

    @PutMapping("/api/post/{id}")
    public NoticeContainer<Notice> updateNotice(@AuthenticationPrincipal UserDetails users) {
        Notice notice = null;
        try {
            notice = noticeService.update(users);
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        return new NoticeContainer<>(true, notice, null);
    }

    @DeleteMapping("/api/post/{id}")
    public NoticeContainer<Boolean> deleteNotice(@PathVariable Long id) {
        try {
            noticeRepository.deleteById(id);
        } catch (Exception e){
            System.out.println("Exception" + e.getMessage());
        }
        return new NoticeContainer<>(true, true, null);
    }

    @PostMapping("/api/post/{id}")
    public NoticeContainer<Boolean> chkNotice(@AuthenticationPrincipal UserDetails users) {
        boolean chk = false;
        try {
            chk = noticeService.isValidPassword(users.getPassword());
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        return new NoticeContainer<>(true, chk, null);
    }

    @GetMapping("/api/post/{id}")
    public NoticeContainer<Notice> readNotice(@AuthenticationPrincipal UserDetails users) {
        Notice notice = null;
        try {
            notice = noticeRepository.findById(Long.valueOf(users.getUsername())).orElse(null);
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        return new NoticeContainer<>(true, notice, null);
    }
}
