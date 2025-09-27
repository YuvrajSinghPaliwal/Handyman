package com.app.HandyMan.Service;

import com.app.HandyMan.Entity.Wallet;
import com.app.HandyMan.Repository.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

		 @Autowired
		 private WalletRepo walletRepo;
		
		 public List<Wallet> findAll() {
		     return walletRepo.findAll();
		 }
		
		 public Optional<Wallet> findById(Long id) {
		     return walletRepo.findById(id);
		 }
		
		 public Wallet save(Wallet wallet) {
		     return walletRepo.save(wallet);
		 }
		
		 public void deleteById(Long id) {
		     walletRepo.deleteById(id);
		 }
}

