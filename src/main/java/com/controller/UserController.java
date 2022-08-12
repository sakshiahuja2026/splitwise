package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.LoginBean;
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
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody LoginBean login) {
		UserBean dbUser = userRepo.findByEmail(login.getEmail());
		//ram@ram.com ram --> sfesfsdsdr4wrwewf4wefewr --> ram  
		//ram -> 3ew3dsdsfddssfsdfs
 
		if (dbUser == null ||   bcrypt.matches(login.getPassword(), dbUser.getPassword())  == false ) {
			ResponseBean<LoginBean> res = new ResponseBean<>();
			res.setData(login);
			res.setMsg("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
		} else {
			//temp bean -> UserAccount --> fields -> account create 
			
//			List<AccountBean> accounts = accountRepo.findByUser(dbUser.getUserId());
//			ResponseBean<List<Object>> res = new ResponseBean<>();
//			List<Object> list = new ArrayList<Object>();
//			list.add(dbUser);
//			list.add(accounts);
//			res.setData(list);
//			res.setMsg("Login done...");
//			return ResponseEntity.ok(res);

			

			ResponseBean<Map<String,Object>> res = new ResponseBean<>();
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("user", dbUser);
			res.setData(data);
			res.setMsg("Login done...");
			return ResponseEntity.ok(res);

		}
	}

	
}
