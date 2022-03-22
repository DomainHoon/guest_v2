package com.textbook.guest_v2.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public class BaseEntity {
  @CreatedDate
  @Column(name="regdate", updatable=false)
  private LocalDateTime regDate;
  @LastModifiedDate
  @Column(name="moddate")
  private LocalDateTime modDate;
  @PrePersist
  public void prePersist(){
	    System.out.println("========================>입력이전");
	    this.regDate = LocalDateTime.now();
	    this.modDate = LocalDateTime.now();
	}
}
