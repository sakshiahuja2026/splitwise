package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bean.ExpenseBean;
import com.bean.ResponseBean;
import com.repository.ExpenseRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class ExpenseController {
@Autowired
ExpenseRepository  expenseRepo;
@Autowired
UserRepository userRepo;

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
/*@GetMapping("/expense/{userId}")
public ResponseEntity<?> authenticate(@RequestBody ExpenseBean expense) {
	List<ExpenseBean> expenses = expenseRepo.findByUser(expense.getUser().getUserId());
	
	
	ResponseBean<List<Object>> res = new ResponseBean<>();
	List<Object> list = new ArrayList<Object>();
	
	list.add(expenses);
	res.setData(list);
	res.setMsg("");
	return ResponseEntity.ok(res);*/
@GetMapping("/expense/{userId}")
public ResponseEntity<?> getAccountByUser(@PathVariable("userId") Integer userId) {

	List<ExpenseBean> expenses = expenseRepo.findByUser(userId);

	ResponseBean<List<ExpenseBean>> res = new ResponseBean<>();
	res.setData(expenses);
	res.setMsg("expenses...");
	return ResponseEntity.ok(res);

}
}
