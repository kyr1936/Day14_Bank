package com.yr.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import com.yr.util.DBConnector;

public class AccountDAO {
	
	public int insert(AccountDTO accDTO, Connection con) throws Exception{
		
		String sql = "insert into account values(?,?,?,0,sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, accDTO.getAccountNum());
		st.setString(2, accDTO.getAccountName());
		st.setString(3, accDTO.getId());
		
		int result = st.executeUpdate();
		st.close();
		
		return result;	
	}
	
	public int update(AccountDTO accDTO, Connection con) throws Exception {
		
		String sql = "update account set balance=(select balance from account where id=?)+? where accountNum=(select accountnum from account where id=?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, accDTO.getId());
		st.setLong(2, accDTO.getBalance());
		st.setString(3, accDTO.getId());
		
		int result = st.executeUpdate();
		st.close();
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public BankbookDTO bookList(MemberDTO memDTO, BankbookDTO bookDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		
		String sql = "select * from bankbook where account=?";
		PreparedStatement st =con.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌 입력");
		st.setString(1, sc.next());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bookDTO = new BankbookDTO();
			memDTO.setId(rs.getString("id"));
			bookDTO.setBookpw(rs.getString("bookpw"));
			bookDTO.setAccount(rs.getString("account"));
			bookDTO.setOdate(rs.getString("odate"));
			bookDTO.setBookname(rs.getString("bookname"));
			bookDTO.setBalance(rs.getInt("balance"));
		} return bookDTO;
	} 
	
	// 잔액 조회
	public BankbookDTO balanceView(int balance) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select balance from bankbook";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		BankbookDTO bookDTO = null;
		if(rs.next()) {
			bookDTO = new BankbookDTO();
			bookDTO.setBalance(rs.getInt("balance"));
		}
		DBConnector.disConnect(con, st, rs);
		
		return bookDTO;
	}
	
	
	
	
	
	
	
	

}
