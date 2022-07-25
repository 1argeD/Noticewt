package com.sparta.notice;

import com.sparta.notice.domain.Notice;
import com.sparta.notice.domain.NoticeRepository;
import com.sparta.notice.domain.NoticeRequestDto;
import com.sparta.notice.service.NoticeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class NoticeApplication {
	public static void main(String[] args) {
		SpringApplication.run(NoticeApplication.class, args);
	}

}
