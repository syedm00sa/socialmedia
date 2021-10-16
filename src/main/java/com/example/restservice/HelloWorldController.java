package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@RequestMapping("/hello")
	public String hello(){
		return "Hello World";
	}
	
	@GetMapping("/hello/person")
	public List<Person> getAllPersons(){
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person(1,"Syed", 21));
		personList.add(new Person(2,"Ajay", 22));
		personList.add(new Person(3,"Sundar", 25));
		return personList;
	}
	@GetMapping("/hello/person/{Id}")
	public Person getPersonWithId1(@PathVariable("Id") Integer Id){
		if (Id==1) {
		        return new Person(1,"Syed", 21);
		    } 
		 else if (Id==2) {       
		        return new Person(2,"Ajay", 22);
		 }
		 else if (Id==3) {       
		       return new Person(3,"Sundar", 25);
		 }	 
		 return null;
	}
}