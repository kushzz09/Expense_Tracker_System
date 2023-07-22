package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Expense;

import com.example.demo.service.ExpenseService;

@Controller
public class ExpenseController {
	private ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		super();
		this.expenseService = expenseService;
	}
	
	//handler method to handle list students and return model and view 
	@GetMapping("/viewExpense")
	public String listExpenses(Model model) {
		model.addAttribute("expense",expenseService.getAllExpenses());
		return "view_expense";
	}
	
	//To handle add Expense 
	
	@GetMapping("/addExpense")
	public String addExpense(Model model) {
		
		//create expense object to hold expense data
		Expense expense =new Expense();
		model.addAttribute("expense",expense);
		return "add_expense";
	}
	
	@PostMapping("/viewExpense")
	public String saveExpense(@ModelAttribute("expense") Expense expense) {
		expenseService.saveExpense(expense);
		return "redirect:/viewExpense";
	}
	
	//To handle update feature
	@GetMapping("/viewExpense/editExpense/{id}")
	public String editExpense(@PathVariable Long id, Model model) {
		model.addAttribute("expense",expenseService.getExpenseById(id));
		return "edit_expense";
	}
	
	@PostMapping("/viewExpense/{id}")
	public String updateExpense(@PathVariable Long id, @ModelAttribute("expense") Expense expense,Model model) {
		
		//getExpense from Database by id
		Expense existingExpense = expenseService.getExpenseById(id);
		existingExpense.setId(id);
		existingExpense.setExpense_name(expense.getExpense_name());
		existingExpense.setDate(expense.getDate());
		existingExpense.setPrice(expense.getPrice());
		
		//save updated expense object
		expenseService.updateExpense(existingExpense);
		return "redirect:/viewExpense";		
		
	}
	
	//Handler method to handle delete expense
	@GetMapping("/viewExpense/{id}")
	public String deleteExpense(@PathVariable Long id) {
		expenseService.deleteExpenseById(id);
		return "redirect:/viewExpense";
	}
	
	
	//to profile page
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
}
