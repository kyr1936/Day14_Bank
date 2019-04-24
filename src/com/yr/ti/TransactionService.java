package com.yr.ti;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.EmptyStackException;
import java.util.Scanner;

import com.yr.account.AccountDAO;
import com.yr.account.AccountDTO;
import com.yr.member.MemberDTO;
import com.yr.util.DBConnector;
import com.yr.util.Session;

public class TransactionService {
	private Scanner sc;
	private TInfoDAO tDAO;
	private AccountDAO accDAO;
	
	public TransactionService() {
		sc = new Scanner(System.in);
		tDAO = new TInfoDAO();
		accDAO = new AccountDAO();
	}
	public String tran(int num) {
		// 입금, 출금 금액 받기
		// num으로 입/출금 구분
		String message = "입금";
		if(num!=0) {
			message = "출금";
		} 
		System.out.println(message + " 금액 입력");
		TInfoDTO tDTO = new TInfoDTO();
		//accountnum, amount, kind
		tDTO.setAmount(sc.nextInt());
		tDTO.setKind(num);
		
		int result=0;
		String id = ((MemberDTO)Session.member).getId();
		Connection con=null;
		try {
			con = DBConnector.getConnect();
			con.setAutoCommit(false);
			result = tDAO.insert(tDTO, con, id);
			if(result<1) {
				throw new Exception();
			}
			AccountDTO accDTO = new AccountDTO();
			accDTO.setBalance((long)(tDTO.getAmount()));
			accDTO.setId(id);
			
			result = accDAO.update(accDTO, con);
			if(result<1) {
				throw new Exception();
			}
			con.commit();
			message = message + "성공";
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			message = message + "실패";
		}
		
		return message;
	}
	
	
}
