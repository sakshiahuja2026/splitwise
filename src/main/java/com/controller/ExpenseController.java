package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bean.ExpenseBean;
import com.bean.ResponseBean;
import com.bean.UserBean;
import com.repository.ExpenseRepository;

@RestController
@RequestMapping("/user")
public class ExpenseController {
@Autowired
ExpenseRepository  expenseRepo;

@PostMapping("/expense")
public ResponseEntity<?> addExpense(@RequestBody ExpenseBean expense){

	System.out.println(expense.getUser());
	System.out.println(expense.getUser().getUserId());
	expenseRepo.save(expense);
	
	ResponseBean<ExpenseBean> res = new ResponseBean<>();
	res.setData(expense);
	res.setMsg("expense added");
	
	return ResponseEntity.ok(res);
	
}

}
