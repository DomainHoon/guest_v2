package com.textbook.guest_v2.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.textbook.guest_v2.dto.GuestbookDTO;
import com.textbook.guest_v2.dto.PageRequestDTO;
import com.textbook.guest_v2.dto.PageResultDTO;
import com.textbook.guest_v2.entity.Guestbook;

@SpringBootTest
public class GuestbookServiceTest {
    @Autowired
    private GuestbookService service;
    
//    @Test
//    public void testRegister() {
//    	GuestookDTO guestookDTO = GuestookDTO.builder()
//    			.title("Sample Title...")
//    			.content("Samle Content...")
//    			.writer("user0")
//    			.build();
//    	System.out.println(this.sevice.register(guestookDTO));
//    }
    @Test
    public void testList() {
    	PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
    			.page(5).size(7).build();
    	PageResultDTO<GuestbookDTO, Guestbook> resultDTO =
    			service.getList(pageRequestDTO);
    	resultDTO.getDtoList().forEach(System.out::println);
    	System.out.println("이전: " +resultDTO.isPrev());
    	System.out.println("이후: " +resultDTO.isNext());
    	System.out.println("전체페이지수: " +resultDTO.getTotalPage());
    	System.out.println("======================== ");
    	resultDTO.getDtoList().forEach(System.out::println);
    	System.out.println("======================== ");
    	resultDTO.getPageList().forEach(System.out::println);
    	
    }
}
