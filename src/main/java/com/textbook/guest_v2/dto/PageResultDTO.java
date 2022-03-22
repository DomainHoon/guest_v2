package com.textbook.guest_v2.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class PageResultDTO<DTO, EN> {
	private List<DTO> dtoList;
	
	private int totalPage;
	private int page;
	private int size;
	private int start, end;
	private boolean prev, next;
	private List<Integer> pageList;
		
	public PageResultDTO(Page<EN> result, Function<EN,DTO> fn ) {
		dtoList = result.stream().map(fn).
				collect(Collectors.toList());
		this.totalPage = result.getTotalPages();
		makePageList(result.getPageable());
		
	}
	private void makePageList(Pageable pageable) {
		
		this.page = pageable.getPageNumber()+1;
		this.size = pageable.getPageSize();
		//1, 11, 21, 31
		//10,20, 30, 40
		int tempEnd = ((int) Math.ceil(page/(double)this.size)) *this.size;
		start = tempEnd -this.size+1;
		prev = start > 1;
		end = this.totalPage > tempEnd ? tempEnd: this.totalPage;
		next = this.totalPage > tempEnd;
		pageList = IntStream.rangeClosed(start, end).boxed()
				.collect(Collectors.toList());
	}
}
