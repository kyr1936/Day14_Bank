package com.yr.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.yr.account.AccountDTO;
import com.yr.util.DBConnector;

public class MemberDAO {
	// 회원가입
	public int insert(MemberDTO memDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		
		String sql = "insert into member values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memDTO.getId());
		st.setString(2, memDTO.getPw());
		st.setString(3, memDTO.getName());
		st.setString(4, memDTO.getPhone());
		st.setString(5, memDTO.getEmail());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(con, st);
		return result;
	}
	
	// 로그인
	public MemberDTO login(MemberDTO memDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		
		String sql = "select * from member  where id=? and pw=?";
		PreparedStatement st =con.prepareStatement(sql);
		st.setString(1, memDTO.getId());
		st.setString(2, memDTO.getPw());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			
			memDTO.setName(rs.getString("name"));
			memDTO.setPhone(rs.getString("phone"));
			memDTO.setEmail(rs.getString("email"));
		} else {
			memDTO = null;
		}
		DBConnector.disConnect(con, st, rs);
		return memDTO;
	}
}

