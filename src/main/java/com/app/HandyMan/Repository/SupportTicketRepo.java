package com.app.HandyMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.HandyMan.Entity.SupportTicket;

@Repository
public interface SupportTicketRepo extends JpaRepository<SupportTicket, Long> {
}

