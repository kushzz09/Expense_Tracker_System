package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.entity.Expense;
import com.example.demo.repository.ExpenseRepository;

@SpringBootApplication
public class ExpenseTrackerSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerSystemApplication.class, args);
	}
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public void run(String... args) throws Exception {
		
//		Expense expense1 = new Expense("Sleeve","10th June 2023","100");
//		expenseRepository.save(expense1);
//		
//		Expense expense2 = new Expense("Bag","15th January 2023","1000");
//		expenseRepository.save(expense2);
//		
//		Expense expense3 = new Expense("Laptop","10th June 2023","770000");
//		expenseRepository.save(expense3);
//		
//		Expense expense4 = new Expense("Coffee","10th December 2023","250");
//		expenseRepository.save(expense4);
//		
//		Expense expense5 = new Expense("Bottle","9th February 2023","100");
//		expenseRepository.save(expense1);
//		
		
	}

}
