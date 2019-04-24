package com.yr.control;

import java.util.Scanner;

import com.yr.member.MemberService;
import com.yr.util.Session;
import com.yr.view.View;

public class MemberController {
	private MemberService ms;
	private Scanner sc;
	private View view;
	private AccountCotroller ac;

	public MemberController() {
		ms = new MemberService();
		sc = new Scanner(System.in);
		view = new View();
		ac = new AccountCotroller();

	}

	public void start() {
		boolean check = true;
		String message = null;
		while(check) {
			if(Session.member!=null) {
				System.out.println("1. MyPage");
				System.out.println("2. 로그아웃");
				System.out.println("3. 계좌 관리");
				int select = sc.nextInt();
				if(select==1) {
					view.view();
				} else if (select==2) {
					Session.member=null;
				} else {
					ac.start();
				}
			} else {
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("3. 종 료");
				int select = sc.nextInt();

				switch(select) {
				case 1:
					message = ms.insert();
					view.view(message);
					break;
				case 2: 
					message = ms.login();
					view.view(message);
					break;
				default :
					message = "종료합니다";
					view.view(message);
					check=!check;

			}
			
	
			}

		}
	}
}