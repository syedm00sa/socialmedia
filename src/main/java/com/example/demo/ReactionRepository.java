package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<Reaction,Integer> {
	 //int countById(int id);

}
