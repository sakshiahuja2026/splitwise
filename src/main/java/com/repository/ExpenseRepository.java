package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.ExpenseBean;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseBean, Integer>{

}
