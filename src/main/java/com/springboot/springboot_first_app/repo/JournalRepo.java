package com.springboot.springboot_first_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springboot_first_app.entity.JournalEntry;

@Repository
public interface JournalRepo extends JpaRepository<JournalEntry,Integer>{
	
}
