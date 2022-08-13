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

@RestController
@RequestMapping("/user")
public class ExpenseController {
	@Autowired
	ExpenseRepository expenseRepository;

	@PostMapping("/expense")
	public ResponseEntity<?> addExpense(@RequestBody ExpenseBean expense) {

		System.out.println(expense.getUser());
		System.out.println(expense.getUser().getUserId());
		expenseRepository.save(expense);

		ResponseBean<ExpenseBean> res = new ResponseBean<>();
		res.setData(expense);
		res.setMsg("expense added");

		return ResponseEntity.ok(res);
	}
	
	@GetMapping("/expense/{userId}")
	public ResponseEntity<?> listExpense(@PathVariable("userId") Integer userId){
		List<ExpenseBean> expenses = expenseRepository.findByUserId(userId);
		ResponseBean<List<ExpenseBean>> res = new ResponseBean<>();
		res.setData(expenses);
		res.setMsg("accountr retrieved..");
		return ResponseEntity.ok(res);
		}
	}


