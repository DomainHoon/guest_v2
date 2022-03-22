package com.textbook.guest_v2.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.textbook.guest_v2.dto.GuestbookDTO;
import com.textbook.guest_v2.dto.PageRequestDTO;
import com.textbook.guest_v2.dto.PageResultDTO;
import com.textbook.guest_v2.entity.Guestbook;
import com.textbook.guest_v2.repository.GuestbookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {

	private final GuestbookRepository repository;
	@Override
	public Long register(GuestbookDTO dto) {
		log.info("DTO --------------------  ");
		log.info(dto);
		Guestbook  entity = this.dtoToEntity(dto);
		log.info(entity);
		repository.save(entity);
		return entity.getGno();
	}
	@Override
	public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
		Pageable pageable = requestDTO.getPageable(Sort.by("gno"));
		Page<Guestbook> result = repository.findAll(pageable);
		Function<Guestbook, GuestbookDTO> fn = (entity-> entityTodto(entity));
		return new PageResultDTO<>(result, fn);
	}

}
