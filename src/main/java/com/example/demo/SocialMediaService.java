package com.example.demo;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface SocialMediaService {
	User Post(User params);
    List<User> Get();
    User Get(int userId);
    User Update(User params, int userId);
    
    Post Post(Post params, int userId);
   
	Commend Post(Commend params, int userId, int postId);
	
	Reaction Post(Reaction params, int userId, int postId);
	
	
}
