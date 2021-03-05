package com.codercampus.Assignment11.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.ServiceTransactions;

@Controller
public class TransactionsController {

	@Autowired
	private ServiceTransactions serviceTransactions;

	@GetMapping("/transactions")
	public String getTransactions(ModelMap model) {

		List<Transaction> transactions = serviceTransactions.findAll();
		Collections.sort(transactions);

		for (Transaction tr : transactions) {
			System.out.println(tr);
		}
		model.put("transactions", transactions);

		return "transactions";
	}

	@GetMapping("/transactions/{transactionsId}")
	public String getTransactionById(@PathVariable("transactionsId") Long transactionId, ModelMap model) {
		Transaction txn = serviceTransactions.findById(transactionId);
		System.out.println(transactionId);
		System.out.println(txn);
		model.put("txn", txn);
		return "transaction";
	}

}
