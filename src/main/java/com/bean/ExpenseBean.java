package com.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="expenses")
public class ExpenseBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer expenseId;
	
	Integer amount;
	
<<<<<<< HEAD
	String date;
	String time;
=======
	Date date;
	Integer time;
>>>>>>> f466871af5531cf53049f15fb38f9c095252709c
	String description;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	UserBean user = new UserBean();
	public Integer getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
<<<<<<< HEAD
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
=======
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
>>>>>>> f466871af5531cf53049f15fb38f9c095252709c
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	
}
