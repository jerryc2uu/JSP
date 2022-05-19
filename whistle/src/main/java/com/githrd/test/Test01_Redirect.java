package com.githrd.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/test/test01_redirect.pink")//이 요청이 오면 아래 jsp 파일로 응답해주세요...
public class Test01_Redirect extends HttpServlet {
	//service() 오버라이딩
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("NAME", "jennie");
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/test01_redirect.jsp");
		rd.forward(req, resp);
	}
}
