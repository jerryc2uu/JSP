package com.githrd.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.githrd.test.dao.*;
import com.githrd.test.vo.*;

@WebServlet("/test/avtInfo.pink")
public class AvtInfo extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//할일
		//1. 파라미터 꺼내고
		String sno = req.getParameter("ano");
		int ano = Integer.parseInt(sno);
		
		//2. 데이터 베이스 작업해서 결과 받는다
		AvatarDao aDao = new AvatarDao();
		AvatarVO aVO = aDao.getAnoINFO(ano);
		//3. 응답 문서 만든다 (ano, savename, dir, gen)
		PrintWriter pw = resp.getWriter();//응답 문서 도구 가져오고
		/*pw.println("{");
		pw.println("\"ano\": \"" + aVO.getAno() + "\",");	
		pw.println("\"savename\": \"" + aVO.getSavename() + "\",");	
		pw.println("\"dir\": \"" + aVO.getDir() + "\",");	
		pw.println("\"gen\": \"" + aVO.getGen() + "\"");	
		pw.println("}");*/
		
		pw.print(aVO.getJson());
		//http://localhost/whistle/test/avtInfo.pink?ano=11
		
	}

}
