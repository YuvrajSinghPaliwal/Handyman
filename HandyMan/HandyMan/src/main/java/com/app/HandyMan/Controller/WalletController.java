package com.app.HandyMan.Controller;

import com.app.HandyMan.Entity.Wallet;
import com.app.HandyMan.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

		 @Autowired
		 private WalletService walletService;
		
		 @GetMapping
		 public ResponseEntity<List<Wallet>> getAllWallets() {
		     return ResponseEntity.ok(walletService.findAll());
		 }
		
		 @GetMapping("/{id}")
		 public ResponseEntity<Wallet> getWalletById(@PathVariable Long id) {
		     return walletService.findById(id)
		             .map(ResponseEntity::ok)
		             .orElse(ResponseEntity.notFound().build());
		 }
		
		 @PostMapping
		 public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet) {
		     return ResponseEntity.ok(walletService.save(wallet));
		 }
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<Void> deleteWallet(@PathVariable Long id) {
		     walletService.deleteById(id);
		     return ResponseEntity.noContent().build();
		 }
}

