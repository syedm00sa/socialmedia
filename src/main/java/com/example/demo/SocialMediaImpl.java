package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialMediaImpl implements SocialMediaService {
	private UserRepository userRepository;
	private PostRepository PostRepository;
	private ReactionRepository ReactionRepository;
	private CommendRepository CommendRepository;

	public SocialMediaImpl(UserRepository userRepository, PostRepository postRepository,
			ReactionRepository reactionRepository, CommendRepository commendRepository) {
		this.userRepository = userRepository;
		this.PostRepository = postRepository;
		this.ReactionRepository = reactionRepository;
		this.CommendRepository = commendRepository;
	}

//USER
	// post
	@Override
	public User Post(User params) {
		userRepository.save(params);
		return params;
	}

	// GET
	@Override
	public List<User> Get() {
		return userRepository.findAll();
	}

	// GET ID
	@Override
	public User Get(int userId) {
		return userRepository.findById(userId).get();
	}

	// PUT
	@Override
	public User Update(User params, int userId) {
		User user = userRepository.findById(userId).get();
		user.setName(params.getName());
		user.setdateOfBirth(params.getdateOfBirth());
		user.setLogIn(params.getLogIn());
		user.setPassword(params.getPassword());
		user.setStatus(params.getStatus());
		return userRepository.save(user);
	}

//post
	// POST
	public Post Post(Post params, int userId) {
		Optional<User> user = userRepository.findById(userId);
		params.setUser(user.get());
		// int count=CommendRepository.countById(params.getcommendId());
		// int count1=ReactionRepository.countById(params.getReactionCount());
		PostRepository.save(params);
		return params;
	}

//reaction	    
	public Reaction Post(Reaction params, int userId, int postId) {

		Optional<User> user = userRepository.findById(userId);
		params.setUser(user.get());
		Optional<Post> post = PostRepository.findById(postId);
		params.setPost(post.get());
		ReactionRepository.save(params);
		return params;
	}

//commend
	public Commend Post(Commend params, int userId, int postId) {
		Optional<User> user = userRepository.findById(userId);
		params.setUser(user.get());
		Optional<Post> post = PostRepository.findById(postId);
		params.setPost(post.get());
		CommendRepository.save(params);
		return params;
	}
}