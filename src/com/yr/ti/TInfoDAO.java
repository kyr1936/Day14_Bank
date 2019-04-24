package com.yr.ti;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TInfoDAO {

	public int insert (TInfoDTO tDTO, Connection con, String id) throws Exception{
		
		String sql = "insert into transactionInfo values(ti_seq.nextval, (select accountnum from account where id=?), ?, ?, sysdate)";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, tDTO.getAccountNum());
		st.setInt(2, tDTO.getAmount());
		st.setInt(3, tDTO.getKind());
		
		
		
		int result = st.executeUpdate();
		st.close();
		return result;
	}
	
}
