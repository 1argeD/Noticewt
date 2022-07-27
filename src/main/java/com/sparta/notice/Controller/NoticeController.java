package com.sparta.notice.Controller;

import com.sparta.notice.domain.Notice;
import com.sparta.notice.domain.NoticeContainer;
import com.sparta.notice.domain.NoticeRepository;
import com.sparta.notice.domain.NoticeRequestDto;

import com.sparta.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class NoticeController {

    private final NoticeRepository noticeRepository;

    private final NoticeService noticeService;


    @PostMapping("/api/post")
    public NoticeContainer<Notice> createNotice(@RequestBody NoticeRequestDto requestDto) {
        Notice notice = null;
        try {
            notice = new Notice(requestDto);
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
    public NoticeContainer<Notice> updateNotice(@PathVariable Long id, @RequestBody NoticeRequestDto requestDto) {
        Notice notice = null;
        try {
            notice = noticeService.update(id, requestDto);
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
    public NoticeContainer<Boolean> chkNotice(@PathVariable Long id, @RequestBody NoticeRequestDto requestDto) {
        boolean chk = false;
        try {
            chk = noticeService.isValidPassword(String.valueOf(requestDto.getPassword()), id);
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        return new NoticeContainer<>(true, chk, null);
    }

    @GetMapping("/api/post/{id}")
    public NoticeContainer<Notice> readNotice(@PathVariable Long id) {
        Notice notice = null;
        try {
            notice = noticeRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        return new NoticeContainer<>(true, notice, null);
    }
}
