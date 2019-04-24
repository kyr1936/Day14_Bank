package com.yr.ti;

import java.sql.Date;

public class TInfoDTO {
	private int num;
	private String accountNum;
	private int kind;
	private int amount;
	private Date Tdate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getTdate() {
		return Tdate;
	}
	public void setTdate(Date tdate) {
		Tdate = tdate;
	}



	
	
}
