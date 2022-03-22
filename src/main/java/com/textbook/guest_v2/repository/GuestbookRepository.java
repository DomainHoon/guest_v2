package com.textbook.guest_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.textbook.guest_v2.entity.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {

}
