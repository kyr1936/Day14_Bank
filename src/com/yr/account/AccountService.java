package com.yr.account;

import java.util.Scanner;

import com.yr.member.MemberDTO;
import com.yr.util.DBConnector;
import com.yr.util.Session;

public class AccountService {
	private Scanner sc;
	private AccountDAO accDAO;
	public AccountService() {
		sc = new Scanner(System.in);
		accDAO = new AccountDAO();
	}
	
	public String insert() {
		String message="계좌개설 성공";
		AccountDTO accDTO = new AccountDTO();
		System.out.println("계좌번호 입력");
		accDTO.setAccountNum(sc.next());
		System.out.println("계좌명 입력");
		accDTO.setAccountName(sc.next());
		accDTO.setId(((MemberDTO)(Session.member)).getId());
		int result=0;
		try {
			result = accDAO.insert(accDTO, DBConnector.getConnect());
			if(result<1) {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "계좌개설 실패";
			
			
		}
		return message;
		
	}
	
	
	
}
