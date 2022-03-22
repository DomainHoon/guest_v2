package com.textbook.guest_v2.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SequenceGenerator(name="guestbook_seq_generator", 
sequenceName ="guestbook_seq",
initialValue = 1, allocationSize = 1)
public class Guestbook extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="guestbook_seq_generator")
	private Long gno;
	@Column(length = 100, nullable = false)
	private String title;
	@Column(length = 1500, nullable = false)
	private String content;
	@Column(length = 50, nullable = false)
	private String writer;
    public void changeTitle(String title) {
    	this.title = title;
    }
    public void changeContent(String content) {
    	this.content = content;
    }
  
}
