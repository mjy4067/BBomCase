package dao;

import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;

import vo.MemberBean;
import static db.JdbcUtil.*;

public class MemberDAO {
	
	public static MemberDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	//로그인
	public String selectLoginId(MemberBean member) {
		String loginId = null;
		String sql = "select mem_id from member where mem_id = ? and mem_pass = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMem_id());
			pstmt.setString(2, member.getMem_pass());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("mem_id");
			}
		} catch(Exception e) {
			System.out.println("에러는 " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}
		
	
	//회원가입 
	public int insertMember (MemberBean member) {
		String sql = "insert into member values (?,?,?,?,?,?,?,?,?,?,?)";
		int insertCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMem_id());
			pstmt.setString(2, member.getMem_pass());
			pstmt.setString(3, member.getMem_name());
			pstmt.setString(4, member.getMem_tel());
			pstmt.setString(5, member.getMem_birth());
			pstmt.setInt(6, member.getZip_code());
			pstmt.setString(7, member.getAddr1());
			pstmt.setString(8, member.getAddr2());
			pstmt.setString(9, member.getMem_date());
			pstmt.setString(10, member.getMem_grade());
			pstmt.setString(11, member.getMem_email());
			insertCount = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			System.out.println("회원가입 에러 : " + e);
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	//회원 목록
	public ArrayList<MemberBean> selectMemberList(){
		String sql = "select * from member";
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		MemberBean mb = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					mb = new MemberBean();
					mb.setMem_id(rs.getString("mem_id"));
					mb.setMem_pass(rs.getString("mem_pass"));
					mb.setMem_name(rs.getString("mem_name"));
					mb.setMem_tel(rs.getString("mem_tel"));
					mb.setMem_birth(rs.getString("mem_birth"));
					mb.setZip_code(rs.getInt("zip_code"));
					mb.setAddr1(rs.getString("addr1"));
					mb.setAddr2(rs.getString("addr2"));
					mb.setMem_date(rs.getString("mem_date"));
					mb.setMem_grade(rs.getString("mem_grade"));
					mb.setMem_email(rs.getString("mem_email"));
					memberList.add(mb);
				} while(rs.next());
			}
		} catch(Exception e) {
			System.out.println("리스트 에러 :" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}
	
	//회원 정보 보기
	public MemberBean selectMemberInfo (String id) {
		String sql = "select * from member where mem_id = ?";   
		MemberBean mb = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mb = new MemberBean();
				mb.setMem_id(rs.getString("mem_id"));
				mb.setMem_pass(rs.getString("mem_pass"));
				mb.setMem_name(rs.getString("mem_name"));
				mb.setMem_tel(rs.getString("mem_tel"));
				mb.setMem_birth(rs.getString("mem_birth"));
				mb.setZip_code(rs.getInt("zip_code"));
				mb.setAddr1(rs.getString("addr1"));
				mb.setAddr2(rs.getString("addr2"));
				mb.setMem_date(rs.getString("mem_date"));
				mb.setMem_grade(rs.getString("mem_grade"));
				mb.setMem_email(rs.getString("mem_email"));
			}
		} catch(Exception e) {
			System.out.println("회원 정보 보기 에러" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return mb;
	}
	
	//회원 아이디 체크
	public boolean memberIdTest(String id) {
		boolean flag = true;
		try{
			pstmt = con.prepareStatement("select mem_id from member where mem_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()){
				flag = false;
			}else{
				flag = true;
			} 
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return flag;
	}

// 아이디 찾기
	public String memberIdFind(String name, String tel,  String email) {
		String findId = null;
		String sql="select mem_id from member where mem_name = ? and mem_tel = ? and mem_email = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				findId = rs.getString("mem_id");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return findId;
	}
	
// 비밀번호 찾기
	public String memberPwFind(String id, String name, String tel, String email) {
		String findPass = null;
		String sql = "select mem_pass from member where mem_id = ? and mem_name = ? and mem_tel = ? and mem_email = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				findPass = rs.getString("mem_pass");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return findPass;
	}
	
//아이디 삭제
	public int deleteMember(String id) {
		String sql="delete from member where mem_id = ?";
		int deleteCount=0;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("deleteMember 에러 : "+e);
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}
	
//회원 정보 수정
	public int updateMember(MemberBean member) {
		String sql="update member set mem_id=?, mem_pass=?, mem_name=?, mem_birth=?, mem_tel=?, zip_code=?, addr1=?, addr2=?, mem_grade=?, mem_email=? where mem_id = ?";
		int updateCount = 0;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getMem_id());
			pstmt.setString(2,member.getMem_pass());
			pstmt.setString(3, member.getMem_name());
			pstmt.setString(4, member.getMem_birth());
			pstmt.setString(5, member.getMem_tel());
			pstmt.setInt(6, member.getZip_code());
			pstmt.setString(7, member.getAddr1());
			pstmt.setString(8, member.getAddr2());
			pstmt.setString(9, member.getMem_grade());
			pstmt.setString(10, member.getMem_email());
			pstmt.setString(11, member.getMem_id());
			
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("updateMember 에러 : " + e);
		} finally {
			close(pstmt);
		}
		return updateCount;
	}

	
}
