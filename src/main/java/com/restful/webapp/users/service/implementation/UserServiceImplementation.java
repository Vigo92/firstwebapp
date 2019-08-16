package com.restful.webapp.users.service.implementation;

import java.util.HashMap;
import java.util.Map;
//import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.webapp.model.request.UserDetailsRequestModel;
import com.restful.webapp.model.response.UserRest;
import com.restful.webapp.users.service.UserService;
import com.restful.webapp.utils.Utils;


@Service
public class UserServiceImplementation implements UserService{

	Map<String, UserRest> mapuser;
	Utils utils;
	
	 public UserServiceImplementation() {
		
	}
	 @Autowired
	 public UserServiceImplementation(Utils utils) {
		 this.utils = utils;
	 }
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetail) {
	
		
		UserRest user = new UserRest();
		user.setFirstName(userDetail.getFirstName());
		user.setLastName(userDetail.getLastName());
		user.setEmail(userDetail.getEmail());
		String userId = utils.generateId();
		user.setUserId(userId);
		
		if(mapuser == null)
			mapuser = new 	HashMap<>();
		mapuser.put(userId, user);
		return user;
	}

}
