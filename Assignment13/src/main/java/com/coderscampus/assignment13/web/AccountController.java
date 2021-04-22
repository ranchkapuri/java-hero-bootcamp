package com.coderscampus.assignment13.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.AccountService;
import com.coderscampus.assignment13.service.UserService;

@Controller
public class AccountController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/users/{userId}/accounts")
	public String createAccount (@PathVariable Long userId) {
		Account acct = new Account();
		User user = userService.findById(userId);
		acct.getUsers().add(user);
		user.getAccounts().add(acct);
		acct.setAccountName("Account #" + user.getAccounts().size());
		acct = accountService.save(acct);
		System.out.println(acct);
		return "redirect:/users/"+userId+"/accounts/"+acct.getAccountId();
	}
	
	@PostMapping("/users/{userId}/accounts/{accountId}")
	public String saveAccount(Account account, @PathVariable Long userId) {
		account = accountService.save(account);
		return "redirect:/users/"+userId+"/accounts/"+account.getAccountId();
	}
	
	@GetMapping("/users/{userId}/accounts/{accountId}")
	public String getAccount(ModelMap model, @PathVariable Long userId, @PathVariable Long accountId) {
		Account account = accountService.findById(accountId);
		User user = userService.findById(userId);
		model.put("account", account);
		model.put("user", user);
		return "account";
	}
}
