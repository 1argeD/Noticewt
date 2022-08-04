package com.sparta.notice.Reposirtory;

import com.sparta.notice.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findAllByOrderByModifiedAtDesc();

    Object getPassword();
    Object getUsername();
}
