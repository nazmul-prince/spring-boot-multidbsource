package com.db.multiplesources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.db.multiplesources.db1source.entity.ColorEntity;
import com.db.multiplesources.db1source.repositories.ColorRepository;
import com.db.multiplesources.db2source.entity.BanksEntity;
import com.db.multiplesources.db2source.repositories.BankRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestRunner implements CommandLineRunner{
	
	@Autowired
	private ColorRepository colorRepository;
	
	@Autowired
	private BankRepository bankRepository;

	@Override
	public void run(String... args) throws Exception {
		log.info("Running.........");
		
		List<ColorEntity> colors = colorRepository.findAll();
		log.info("all colors: " + colors);
		
		List<BanksEntity> banks = bankRepository.findAll();
		log.info("banks: " + banks);
	}

}
