package com.restful.webapp.ui.controller;

//import java.util.HashMap;
import java.util.Map;
//import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webapp.model.request.UpdateUserDetailsRequestModel;
import com.restful.webapp.model.request.UserDetailsRequestModel;
import com.restful.webapp.model.response.UserRest;
import com.restful.webapp.users.service.UserService;
//import com.restful.webapp.users.service.implementation.UserServiceImplementation;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	Map<String, UserRest> mapuser;

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "100") int limit,
			@RequestParam(value = "sort", defaultValue = "Desc", required = false) String sort) {
		return "Get users was called with page =" + page + " and limit = " + limit + " and sort = " + sort;
	}

	@GetMapping(path = "/{userid}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userid) {

	
		if (mapuser.containsKey(userid)) {
			return new ResponseEntity<UserRest>(mapuser.get(userid), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel users) {

	//	UserRest user = new UserServiceImplementation().createUser(users);
		UserRest user = userService.createUser(users);
		return new ResponseEntity<UserRest>(user, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String userId,
			@Valid @RequestBody UpdateUserDetailsRequestModel updateuser) {

		UserRest user = mapuser.get(userId);
		user.setFirstName(updateuser.getFirstName());
		user.setLastName(updateuser.getLastName());

		mapuser.put(userId, user);
		return user;
	}

	@DeleteMapping(path = "/{userid}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userid) {
		mapuser.remove(userid);
		return ResponseEntity.noContent().build();
	}

}
