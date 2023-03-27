<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


			<%
			int nb = (int) request.getAttribute("nb");
			for (int i = 0; i < nb; i++) {
				int j = i + 1;
				out.println("<p>"+ request.getAttribute("id" + i) +"</p>");
			
			}
			%>
			
			

</body>
</html>