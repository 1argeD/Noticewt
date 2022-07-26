package com.sparta.notice.Controller;

import com.sparta.notice.domain.Notice;
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
    public Notice createNotice(@RequestBody NoticeRequestDto requestDto) {
        Notice notice = new Notice(requestDto);
        return noticeRepository.save(notice);
    }

    @GetMapping("/api/post")
    public List<Notice> getNotices() {
        return noticeRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/post/{id}")
    public Long updateNotice(@PathVariable Long id, @RequestBody NoticeRequestDto requestDto) {
        noticeService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/post/{id}")
    public Long deleteNotice(@PathVariable Long id) {
        noticeRepository.deleteById(id);
        return id;
    }

    @GetMapping("/api/post/{id}")
    public Notice readNotice(@PathVariable Long id) {
        return noticeRepository.findById(id).orElse(null);
    }
}
