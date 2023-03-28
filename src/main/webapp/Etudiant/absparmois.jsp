<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="metier.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style/absmois.css">
<title>Insert title here</title>
</head>
<body>



<!-- menu -->
	<div class="menu">
		<ul>
			<li><img src="img/logo-ut1.png" class="logo-ut1" /></li>
			<div class="accueil">
				<li><a href="webapp.AcceuilEtudiant">Accueil</a>
			</div>
			</li>
			

			<div class="compte">
				<li><a href="#">Mon Compte</a>
					<ul>
						<li><a href="CtrlProfil">Mes informations</a></li>
						<li>Déconnextion</li>
					</ul>
			</div>
			</li>
		</ul>
	</div>


	
		<div class="content">



			
				<h2>Abscenses pour le mois de 
<%-- 		<%= request.getParameter("type_Moi") %> --%>
		</h2><br>
			
<%-- 			<p><%= session.getAttribute("id") %></p><br> --%>
		
		

		
	
	<ul>
	
	<%
	for (Seance s :(List<Seance>)request.getAttribute("listeAbs") )
	{
		out.print("<ul>");
		out.print("<li>"+s.getDateS()+"</li>");
		
		out.print("</ul>");
	}
			
				                    	
	%>
			
	
	</ul>
		
	
			

			<!-- 	<ul> -->

			<!-- 				<li><a href="CtrlFonctionalitesEtu?type_action=Fonct">Consulter mes absences </a></li> -->
			<!-- 			</ul> -->
		</div>




x




			
		
</body>
</html>