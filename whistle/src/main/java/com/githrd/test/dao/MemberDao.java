package com.githrd.test.dao;

import com.githrd.test.db.*;
import com.githrd.test.sql.*;
import com.githrd.test.vo.MemberVO;

import java.sql.*;

public class MemberDao {

	private JennieJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private MemberSQL mSQL;

	public MemberDao() {
		db = new JennieJDBC();
		mSQL = new MemberSQL();
	}

	//로그인 데이터베이스 작업 전담 처리함수
	public int getLoginCnt(String id, String pw) {
		//반환값 변수
		int cnt = 0;
		
		//작업 순서
		//1. 커넥션
		con = db.getCon();
		//2. 질의명령
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
		//3. 명령 전달 도구
		pstmt = db.getPstmt(con, sql);
		try {
			//4. 질의명령 완성
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			//5. 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			//6. 결과에서 데이터 꺼내고
			rs.next();
			cnt = rs.getInt("cnt");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		//7. 데이터 반환
		return cnt;
	}
	
	//회원정보 조회 전담 함수
	public MemberVO getMemInfo(String id) {
		MemberVO mvo = new MemberVO();
		
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_MEMBER_INFO);
		pstmt = db.getPstmt(con, sql);
		
		try {
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			//회원번호, 회원이름, 아이디, 메일, 전화번호, 가입일, 성별, 아바타 이미지
			mvo.setMno(rs.getInt("mno"));
			mvo.setName(rs.getString("name"));
			mvo.setId(rs.getString("id"));
			mvo.setMail(rs.getString("mail"));
			mvo.setTel(rs.getString("tel"));
			mvo.setJdate(rs.getDate("joindate"));
			mvo.setJtime(rs.getTime("joindate"));
			mvo.setSdate();
			mvo.setGen(rs.getString("gen"));
			mvo.setSavename(rs.getString("savename"));
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
				
		return mvo;
	}
	
}
