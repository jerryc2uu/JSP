<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<%-- 
			EL은 문서 만들 때 실행되는 명령
			따라서 이 문서 만들 때 조립하는 명령으로서 작동하게 된다.
			이때 문자열을 EL로 전달받게 되는 경우
			
			표현 부분에 따옴표는 생략되어서 채워지게 된다.
			따라서 자바스크립트에서 변수에 문자열 데이터를 EL의 값을 사용하려면
			따옴표 안에 작성하면 된다.
			
			예]
				컨트롤러에서 기억시키는 경우
				name="JENNIE";
				req.setAttribute("NAME", name);
				
				jsp 문서의 script 태그 내에서는
				
				var name = ${NAME}; 
				==> 실행해서 이 문서를 조립한 결과 : var name = JENNIE; (X)
				
				var name = '${NAME}';
				==> var naem = 'JENNIE'; (O)
				
		--%>
		<footer>
			<div>Member List</div>
			<div>edit</div>
			<div>회원탈퇴</div>
		</footer>
</body>
</html>