package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommendRepository extends JpaRepository<Commend,Integer> {
	//int countById(int id);
}
