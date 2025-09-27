package com.app.HandyMan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.HandyMan.Entity.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Long> {
}

