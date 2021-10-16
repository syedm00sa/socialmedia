package com.example.demo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Post")
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1229238002171536593L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;

	@Column(name = "Text")
	private String text;

	@Column(name = "Reaction_Count")
	private int reactionCount;

	@Column(name = "Commend_Count")
	private int commendCount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Set<Reaction> reaction;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Set<Commend> commend;

	public Post(int postId, String text, User user, int reactionCount, int commendCount, Set<Reaction> reaction,
			Set<Commend> commend) {
		super();
		this.postId = postId;
		this.text = text;
		this.user = user;
		this.reaction = reaction;
		this.commend = commend;
		this.reactionCount = reactionCount;
		this.commendCount = commendCount;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getReactionCount() {
		return reactionCount;
	}

	public void setReactionCount(int reactionCount) {
		this.reactionCount = reactionCount;
	}

	public int getCommendCount() {
		return commendCount;
	}

	public void setCommendCount(int commendCount) {
		this.commendCount = commendCount;
	}

	@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public static void save(Post params) {
		// TODO Auto-generated method stub

	}

}
