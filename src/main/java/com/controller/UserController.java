package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bean.ResponseBean;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.repository.RoleRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/public")
public class UserController {

	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	BCryptPasswordEncoder bcrypt;

	@PostMapping("/signup")
	public ResponseEntity<ResponseBean<UserBean>> signup(@RequestBody UserBean user) {
		UserBean dbUser = userRepo.findByEmail(user.getEmail());
		ResponseBean<UserBean> res = new ResponseBean<>();

		if (dbUser == null) {
			RoleBean role = roleRepo.findByRoleName("user");
			user.setRole(role);
 			String encPassword = bcrypt.encode(user.getPassword()); 
			user.setPassword(encPassword);
			userRepo.save(user);

			
			res.setMsg("Signup done...");

			return ResponseEntity.ok(res);
		} else {
			res.setData(user);
			res.setMsg("Email Already Taken");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
	}

	
}
