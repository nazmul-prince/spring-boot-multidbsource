package com.db.multiplesources.db2source.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.multiplesources.db2source.entity.BanksEntity;

public interface BankRepository extends JpaRepository<BanksEntity, Long> {

}
