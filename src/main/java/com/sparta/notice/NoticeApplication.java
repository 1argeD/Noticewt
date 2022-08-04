package com.sparta.notice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NoticeApplication {

	public static void main(String[] args) { SpringApplication.run(NoticeApplication.class, args);}
//	@Bean
//	public CommandLineRunner demo(NoticeRepository noticeRepository, NoticeService noticeService) {
//		return (args) -> {
//			NoticeRepository.save(new Notice( id, String title, String author, String content));
//			List<Notice> noticeList = noticeRepository.findAll();
//			for (int i = 0; i < noticeList.size(); i++) {
//				Notice notice = noticeList.get(i);
//				System.out.println(notice.getId());
//				System.out.println(notice.getTitle());
//				System.out.println(notice.getAuthor());
//				System.out.println(notice.getContent());
//			}
//
//			NoticeRequestDto requestDto = new NoticeRequestDto(id, String title, String author, String content );
//			noticeService.update(1L, requestDto);
//			noticeList = noticeRepository.findAll();
//			for (int i = 0; i < noticeList.size(); i++) {
//				Notice notice = noticeList.get(i);
//				System.out.println(notice.getId());
//				System.out.println(notice.getTitle());
//				System.out.println(notice.getAuthor());
//				System.out.println(notice.getContent());
//			}
//
//			noticeRepository.deleteAll();
//		};

}
