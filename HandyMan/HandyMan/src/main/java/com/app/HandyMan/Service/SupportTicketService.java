package com.app.HandyMan.Service;

import com.app.HandyMan.Entity.SupportTicket;
import com.app.HandyMan.Repository.SupportTicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportTicketService {

		 @Autowired
		 private SupportTicketRepo supportTicketRepo;
		
		 public List<SupportTicket> findAll() {
		     return supportTicketRepo.findAll();
		 }
		
		 public Optional<SupportTicket> findById(Long id) {
		     return supportTicketRepo.findById(id);
		 }
		
		 public SupportTicket save(SupportTicket supportTicket) {
		     return supportTicketRepo.save(supportTicket);
		 }
		
		 public void deleteById(Long id) {
		     supportTicketRepo.deleteById(id);
		 }
}
