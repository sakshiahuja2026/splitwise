package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.bean.ExpenseBean;


@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseBean, Integer> {
	@Query(value = "select * from expenses where user_id = :userId", nativeQuery = true)
	List<ExpenseBean> findByUser(Integer userId);
}
