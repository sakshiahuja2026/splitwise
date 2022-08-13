package com.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class UserBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userId;

	String firstName;
	String email;

	String password;
	String gender;

	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false)
	RoleBean role;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	Set<ExpenseBean> expense = new HashSet<>();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public RoleBean getRole() {
		return role;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}

	public Set<ExpenseBean> getExpense() {
		return expense;
	}

	public void setExpense(Set<ExpenseBean> expense) {
		this.expense = expense;
	}

	
}