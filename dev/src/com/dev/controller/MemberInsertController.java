// memberInsert.do 요청을 처리하는 객체로서 회원정보 생성에 관한 기능을 execute() 메소드에 구현
package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws 
						ServletException, IOException {
		
		// 파라미터 추출
		// 클라이언트가 보낸 질의 문자열들을 각각 추출하여 지역변수들에 저장
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		
		// 유효성 체크
		// isEmpty 메소드는 입력값이 없을 때 true를 반환
		if (id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다.!");
			HttpUtil.forward(request, response, "/memberInsert.jsp");
			return;
		}
		
		// vo 객체에 데이터 바인딩(저장)
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);
		
		// service 객체의 메소드 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		// Output View 페이지로 이동
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/result/memberInsertOutput.jsp");
		
	}

}
