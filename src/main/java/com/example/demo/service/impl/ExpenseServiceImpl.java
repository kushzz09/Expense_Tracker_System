package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Expense;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	private ExpenseRepository expenseRepository;
		
	public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}
	
	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	@Override
	public Expense saveExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	@Override
	public Expense getExpenseById(Long id) {
		
		return expenseRepository.findById(id).get();
	}

	@Override
	public Expense updateExpense(Expense expense) {
		
		return expenseRepository.save(expense);
	}

	@Override
	public void deleteExpenseById(Long id) {
		expenseRepository.deleteById(id);		
	}

}
