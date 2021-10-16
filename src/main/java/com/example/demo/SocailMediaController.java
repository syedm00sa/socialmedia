package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocailMediaController {
	private final SocialMediaService socialmediaService;

	public SocailMediaController(SocialMediaService socialmediaService, UserRepository userRepository,
			PostRepository postrepository, ReactionRepository reactionrepository, CommendRepository commendrepository) {
		this.socialmediaService = socialmediaService;
	}

	@RequestMapping("/greeting")
	public String Hello() {
		return "Hi Everyone #";
	}

	// USER
	@PostMapping(value = "/user")
	public ResponseEntity<Object> Post(@Valid @RequestBody User params) {
		try {
			User result = socialmediaService.Post(params);
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@GetMapping(value = "/user")
	public ResponseEntity<Object> Get() {
		try {
			List<User> result = socialmediaService.Get();
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<Object> Get(@PathVariable int userId) {
		try {
			User result = socialmediaService.Get(userId);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@PutMapping(value = "/user/{userId}")
	public ResponseEntity<Object> Update(@PathVariable int userId, @Valid @RequestBody User params) {
		try {
			User result = socialmediaService.Update(params, userId);
			return ResponseHandler.generateResponse("Successfully Updated", HttpStatus.OK, result);
		} catch (Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	// Post
	@PostMapping(value = "/user/{userId}/post")
	public ResponseEntity<Object> Post(@PathVariable int userId, @Valid @RequestBody Post params) {
		try {
			Post result = socialmediaService.Post(params, userId);
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	// reaction
	@PostMapping(value = "/user/{userId}/post/{postId}/reaction")
	public ResponseEntity<Object> Post(@PathVariable int userId, @PathVariable int postId, @Valid @RequestBody Reaction params) {
		try {
			Reaction result = (Reaction) socialmediaService.Post(params, userId, postId);
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	// commend
	@PostMapping(value = "/user/{userId}/post/{postId}/commend")
	public ResponseEntity<Object> Post(@PathVariable int userId, @PathVariable int postId, @Valid @RequestBody Commend params) {
		try {
			Commend result = socialmediaService.Post(params, userId, postId);
			return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

}