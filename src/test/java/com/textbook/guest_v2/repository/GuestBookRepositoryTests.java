package com.textbook.guest_v2.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.textbook.guest_v2.entity.Guestbook;

@SpringBootTest
public class GuestBookRepositoryTests {
	@Autowired
	GuestbookRepository guestbookRepository;
	
	@Test
	public void insertDummies() {
		guestbookRepository.deleteAll();
		IntStream.rangeClosed(1, 300).forEach(i->{
			Guestbook guestBook = Guestbook.builder()
					.title("Title..."+i)
					.content("Content..."+i)
					.writer("user"+(i%10))
					.build();
			System.out.println(guestbookRepository.save(guestBook));
		});
	}
	@Test
	public void updateTest() {
		Optional<Guestbook> result = guestbookRepository.findById(300L);
		if(result.isPresent()) {
			Guestbook guestbook = result.get();
			guestbook.changeTitle("Changed Title....");
			guestbook.changeContent("Changed Content....");
			guestbookRepository.save(guestbook);
		}
	}
	@Test 
	public void testQuery1() {
		//Pageable pageable = PageRequest.of(0, 10, Sort.by("gno").ascending());
	    Optional<Guestbook> result =	guestbookRepository.findById(200L);
	    if(result.isPresent()) {
	    	System.out.println(result.get());
	    }
		//guestbookRepository.findAll().forEach(System.out::println);
	}
}






