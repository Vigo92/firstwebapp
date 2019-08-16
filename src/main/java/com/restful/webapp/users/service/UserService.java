package com.restful.webapp.users.service;

import com.restful.webapp.model.request.UserDetailsRequestModel;
import com.restful.webapp.model.response.UserRest;

public interface UserService {
	
	UserRest createUser(UserDetailsRequestModel user);

}
