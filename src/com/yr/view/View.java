package com.yr.view;

import com.yr.member.MemberDTO;
import com.yr.util.Session;

public class View {
	
	public void view(String message) {
		System.out.println(message);
	}
	
	public void view() {
		MemberDTO memDTO = (MemberDTO)Session.member;
		System.out.println("id : " + memDTO.getId());
		System.out.println("name : " + memDTO.getName());
		System.out.println("phone : " + memDTO.getPhone());
		System.out.println("email : " + memDTO.getEmail());
	}
	
}
