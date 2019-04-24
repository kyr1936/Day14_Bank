package com.yr.control;

import java.util.Scanner;

import com.yr.account.AccountService;
import com.yr.ti.TransactionService;
import com.yr.view.View;

public class AccountCotroller {
	private Scanner sc;
	private AccountService as;
	private View view;
	private TransactionService ts;
	
	public AccountCotroller() {
		sc = new Scanner(System.in);
		as = new AccountService();
		view = new View();
		ts = new TransactionService();
		
	}
	public void start() {
		boolean check = true;
		String message;
		
		while(check) {
			System.out.println("1. 계좌 개설");
			System.out.println("2. 입 금");
			System.out.println("3. 출 금");
			System.out.println("4. 종  료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				message = as.insert();
				view.view(message);
				break;
			case 2:
				message = ts.tran(0);
				view.view(message);
				
				break;
			case 3: 
				message = ts.tran(1);
				view.view(message);
				break;
			default :
				System.out.println("종료");
				check=!check;
			}
		}
	}
	
	
	
	
	
}


