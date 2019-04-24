package com.yr.member;

import java.util.Scanner;

import com.yr.util.Session;

public class MemberService {

	private Scanner sc;
	private MemberDAO memDAO;
	
	public MemberService () {
		sc = new Scanner(System.in);
		memDAO = new MemberDAO();
		
	}
	public String insert() {
		MemberDTO memDTO = new MemberDTO();
		System.out.println("ID 입력 ");
		memDTO.setId(sc.next());
		System.out.println("pw 입력");
		memDTO.setPw(sc.next());
		System.out.println("username 입력");
		memDTO.setName(sc.next());
		System.out.println("phone 입력");
		memDTO.setPhone(sc.next());
		System.out.println("email 입력");
		memDTO.setEmail(sc.next());
		int result=0;
		String message = "회원가입 성공";
		
		try {
			result = memDAO.insert(memDTO);
			if(result <1) {
				throw new Exception();   // 강제로 예외 발생
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "회원가입 실패";
			
		}
		return message;
	}
	
	public String login() {
		MemberDTO memDTO = new MemberDTO();
		System.out.println("id 입력");
		memDTO.setId(sc.next());
		System.out.println("pw 입력");
		memDTO.setPw(sc.next());
		String message = "로그인 실패";
		try {
			memDTO = memDAO.login(memDTO);
			Session.member = memDTO;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		if(memDTO != null) {
			message = "로그인 성공";
		}
		return message;
	}
	
	
	
	
	
	
	
	
	
	
}
