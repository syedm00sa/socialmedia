package com.example.demo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Reaction")
public class Reaction implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1367518959746995433L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reactionId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_id", referencedColumnName = "postId")
	private Post post;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	public Reaction(int reactionId, Post post, User user) {
		super();
		this.reactionId = reactionId;
		this.post = post;
		this.user = user;

	}

	public Reaction() {
		// TODO Auto-generated constructor stub
	}

	public int getreactionId() {
		return reactionId;
	}

	public void setreactionId(int reactionId) {
		this.reactionId = reactionId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static void save(Reaction params) {
		// TODO Auto-generated method stub
	}
}