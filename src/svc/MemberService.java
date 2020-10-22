package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberService {
	
	public boolean login (MemberBean member) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean loginResult = false;
		String loginId = memberDAO.selectLoginId(member);
		
		if(loginId != null) {
			loginResult = true;
		}
		
		close(con);
		return loginResult;
	}
	
	public boolean join (MemberBean member) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean joinResult = false;
		int joinCount = memberDAO.insertMember(member);
		
		if(joinCount > 0) {
			joinResult = true;
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		return joinResult;	
	}
	
	public boolean idTest(String id) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean idTestResult = memberDAO.memberIdTest(id);
		
		close(con);
		return idTestResult;
	}
	
	public String idFind(String name, String tel, String email) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		String idFindResult = memberDAO.memberIdFind(name, tel, email);
		
		close(con);
		return idFindResult;
	}
	
	public String pwFind(String id, String name, String tel, String email) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		String pwFindResult = memberDAO.memberPwFind(id, name, tel, email);
		
		close(con);
		return pwFindResult;
	}
	
	public MemberBean memberInfo(String id) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		MemberBean memberInfoResult = memberDAO.selectMemberInfo(id);
		
		close(con);
		return memberInfoResult;
	}
	
	public boolean delete(String id) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean deleteResult = false;
		int deleteCount = memberDAO.deleteMember(id);
		
		if(deleteCount > 0) {
			commit(con);
			deleteResult = true;
		} else {
			rollback(con);
		} 
		
		close(con);
		return deleteResult;
	}
	
	public boolean modify(MemberBean member) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean modifyResult = false;
		int modifyCount = memberDAO.updateMember(member);
		
		if(modifyCount > 0) {
			commit(con);
			modifyResult = true;
		} else {
			rollback(con);
		}
		
		close(con);
		return modifyResult;
	}

//관리자 Service ↓↓↓↓↓↓↓↓
	
	
	public ArrayList<MemberBean> memberList(){
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		ArrayList<MemberBean> memberList = memberDAO.selectMemberList();
		
		close(con);
		return memberList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
