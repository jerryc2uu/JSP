<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whistle/resources/css/base.css">
<script type="text/javascript" src="/whistle/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#obtn').click(function(){
			$(location).attr('href', '/whistle/test/logout.pink');
		});
		
		$('#lbtn').click(function(){
			$(location).attr('href', '/whistle/test/login.pink');
		});
		$('#ibtn').click(function(){
			
			var tid = $('#tid').html();
			tid = tid.substring(6)
			
			$.ajax({
				url: '/whistle/test/myinfo.pink',
				//url: 'http://localhost/whistle/test/avtInfo.pink?ano=11'
				type: 'POST',
				dataType: 'json',
				data: {
					id: tid
				},
				success: function(data) {
					if(!data) {
						$(location).attr('href', '/test/login.pink');
						return;
					}	
					
					$('#info').append(
						'<h1>회원번호 : '+ data.mno + '</h1>'+
						'<h1>이름 : '+ data.name + '</h1>'+
						'<h1>아이디 : '+ data.id + '</h1>'+
						'<h1>메일 : '+ data.mail + '</h1>'+
						'<h1>전번 : '+ data.tel + '</h1>'+
						'<h1>가입일 : '+ data.joindate + '</h1>'+
						'<h1>성별 : '+ data.gen + '</h1>'
					);
					
					$('img').attr('src', '/whistle/resources/img/avatar/' + data.savename);
				},
				error: function(){
					alert('### 통신 에러 ###');
				}
			
			});
		});
	});
</script>
</head>
<body>
	<div class="w3-content mx650">
<c:if test="${not empty SID}">
		<h1 class="w3-blue w3-padding w3-center" id="tid">Hello ${SID}</h1>
		<div class="w3-col m2 w3-button w3-red" id="obtn">logout</div>
		<div class="w3-col m2 w3-button w3-green w3-right" id="ibtn">myInfo</div>
</c:if>
<c:if test="${empty SID}">
		<h1 class="w3-blue w3-padding w3-center">Hello JSP!</h1>
		<div class="w3-col m2 w3-button w3-pink" id="lbtn">login</div>
</c:if>
		<!-- 회원 정보 태그 -->
		<div class="w3-content mx650" id="info">
			<h1 class="w3-blue w3-padding w3-center">${SID} 정보</h1>
			<div id="avtimg">
				<img>
			</div>
		</div>
	</div>
	
</body>
</html>