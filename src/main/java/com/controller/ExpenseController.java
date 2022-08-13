package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.bean.ExpenseBean;
import com.bean.ResponseBean;
import com.bean.UserBean;
import com.repository.ExpenseRepository;

@RestController
public class ExpenseController {
@Autowired
ExpenseRepository  expenseRepo;

@PostMapping("/expense")
public ResponseEntity<ResponseBean<ExpenseBean>> addExpense(@RequestBody ExpenseBean expense){

	//System.out.println(expense.ge);
	//System.out.println(expense.get);
	
	ResponseBean<ExpenseBean> res = new ResponseBean<>();
	expenseRepo.save(expense);
	
	res.setData(expense);
	res.setMsg("account added");
	
	return ResponseEntity.ok(res);
	
}

}
