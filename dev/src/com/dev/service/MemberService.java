// 회원에 관한 모든 서비스 기능을 처리하는 모델 객체

package com.dev.service;

import com.dev.dao.MemberDAO;
import com.dev.vo.MemberVO;

public class MemberService {
	
	private static MemberService service = new MemberService();	// service 변수의 접근자 private : 현재 클래스 내에서만 접근가능, 외부에서 불가(값 수정 불가)
	public MemberDAO dao = MemberDAO.getInstance();		
	
	private MemberService() {}	// 생성자의 접근자도 private : 객체 생성 불가
	public static MemberService getInstance() {
		return service;
	}
	
	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);	// VO객체 안에 저장된 회원정보들을 DB의 member테이블에 삽입
	}

}
