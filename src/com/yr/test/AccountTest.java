package com.yr.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yr.account.AccountDAO;
import com.yr.account.AccountDTO;
import com.yr.util.DBConnector;

public class AccountTest {
	private AccountDAO accDAO;

	@BeforeClass
	public static void start() {
	
		
	}
	
	@AfterClass
	public static void end() {
		
	}
	
	@Before
	public void makeDAO() {
		accDAO = new AccountDAO();
		
	}

	@Test
	public void test() throws Exception {
		Connection con = DBConnector.getConnect();
		AccountDTO accDTO = new AccountDTO();
		accDTO.setAccountNum("1");
		accDTO.setAccountName("test");
		accDTO.setId("iu");
		int result = accDAO.insert(accDTO, con);
		assertEquals(1, result);
		
	}
	@After
	public void after() {
		
	}
	

}
