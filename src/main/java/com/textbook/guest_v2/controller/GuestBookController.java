package com.textbook.guest_v2.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.textbook.guest_v2.dto.GuestbookDTO;
import com.textbook.guest_v2.dto.PageRequestDTO;
import com.textbook.guest_v2.service.GuestbookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("guestbook")
@Log4j2
@RequiredArgsConstructor
public class GuestbookController {
	
	private final GuestbookService service;
	/*
	@GetMapping({"/","/list"})
	public String list() {
		log.info("list ....");
		return "/guestbook/list";
	}*/
	@GetMapping("/")
	public String index() {
		log.info("list ....");
		return "redirect:/guestbook/list";
	}
	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		
		log.info("list ...."+pageRequestDTO);
		model.addAttribute("result", service.getList(pageRequestDTO));
       //List<GuestbookDTO>	list =	service.getList(pageRequestDTO).getDtoList();
       
		//service.getList(pageRequestDTO).isNext()
	}
	@GetMapping("/register")
	public void register() {
		log.info("register get...");
	}
	@PostMapping("/register")
	public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes) {
		log.info("dto...." + dto);
		Long gno = service.register(dto);
		redirectAttributes.addFlashAttribute("msg", gno);
		return "redirect:/guestbook/list";
	}
}
