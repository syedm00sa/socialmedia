package com.example.demo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Commend")
public class Commend implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3058175855103473435L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commendId;

	@Column(name = "Comment")
	private String Comment;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_id", referencedColumnName = "postId")
	private Post post;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	public Commend(int commendId, String comment, Post post, User user) {
		super();
		this.commendId = commendId;
		this.Comment = comment;
		this.post = post;
		this.user = user;

	}

	public Commend() {
		// TODO Auto-generated constructor stub
	}

	public int getcommendId() {
		return commendId;
	}

	public void setcommendId(int commendId) {
		this.commendId = commendId;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		this.Comment = comment;
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

	public static void save(Commend params) {
		// TODO Auto-generated method stub

	}

}
