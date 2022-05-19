package com.githrd.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.githrd.test.dao.MemberDao;
import com.githrd.test.vo.MemberVO;


@WebServlet("/test/myinfo.pink")
public class MyInfo extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//세션 검사
		//HttpSession session = req.getSession();
		/*
		
		if(session.getAttribute("SID") == null) {
			resp.sendRedirect("/whistle/test/login.pink");
			return;
		}*/
		
		
		String pid = req.getParameter("id");
		
		
		
		MemberDao mDao = new MemberDao();		
		MemberVO mvo = mDao.getMemInfo(pid);
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("{");
		pw.println("\"mno\": \"" + mvo.getMno() + "\",");
		pw.println("\"name\": \"" + mvo.getName() + "\",");
		pw.println("\"id\": \"" + mvo.getId() + "\",");
		pw.println("\"mail\": \"" + mvo.getMail() + "\",");
		pw.println("\"tel\": \"" + mvo.getTel() + "\",");
		pw.println("\"joindate\": \"" + mvo.getJdate() + "\",");
		pw.println("\"gen\": \"" + mvo.getGen() + "\",");
		pw.println("\"savename\": \"" + mvo.getSavename() + "\"");
		pw.println("}");

	}
}
