package com.db.multiplesources.db1source.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.multiplesources.db1source.entity.ColorEntity;

public interface ColorRepository extends JpaRepository<ColorEntity, Long> {

}
