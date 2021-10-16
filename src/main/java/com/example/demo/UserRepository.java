package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Integer> {

	/*
	 * @Query("select ln from User ln where ln.name like %:name% ") public
	 * List<User> getNames(String name);
	 */

}
