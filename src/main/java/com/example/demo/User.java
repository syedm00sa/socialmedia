package com.example.demo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "User")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8645646376750489090L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "name")
	private String name;

	@Column(name = "DOB")
	@JsonFormat( pattern = "dd-MM-yyyy")
	private Date dateOfBirth;

	@Column(name = "log_In")
	private String logIn;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private String status;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Set<Post> post;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Set<Reaction> reaction;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Set<Commend> commend;

	public User(int userId, String name, Date dateOfBirth, String logIn, String password, String status,
			Set<Post> post, Set<Reaction> reaction, Set<Commend> commend) {
		super();
		this.userId = userId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.logIn = logIn;
		this.password = password;
		this.status = status;
		this.post = post;
		this.reaction = reaction;
		this.commend = commend;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getdateOfBirth() {
		return dateOfBirth;
	}

	public void setdateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLogIn() {
		return logIn;
	}

	public void setLogIn(String logIn) {
		this.logIn = logIn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@JsonManagedReference
	public Set<Post> getPost() {
		return post;
	}

	public void setPost(Set<Post> post) {
		this.post = post;
	}

	public Set<Reaction> getReaction() {
		return reaction;
	}

	public void setReaction(Set<Reaction> reaction) {
		this.reaction = reaction;
	}

	public Set<Commend> getCommend() {
		return commend;
	}

	public void setCommend(Set<Commend> commend) {
		this.commend = commend;
	}

}