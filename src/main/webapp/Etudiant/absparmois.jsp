<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="metier.*"%>
<%@page import="java.util.ArrayList"%>
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
		<%= request.getParameter("type_Moi") %></h2><br>
		
		<table border="1">
		<thead>
			<tr>
				<th>Date</th>
			
			</tr>
		</thead>
		<tbody>
		
			<%
			List<Object> listeAbs = (List<Object>) request.getAttribute("listeAbs");
				            for (Object obj : listeAbs) {
				                    if (obj instanceof Users) {
				                    	 Seance s = (Seance) obj;
				                    	
				//                 for (Utilisateurs etudiant : (ArrayList<Utilisateurs>) request.getAttribute("listeAbs"))
			%>
			<tr>
				<td><%= s.getDateS() %></td>
			
			</tr>
			<% } }%>
		</tbody>
	</table>
		
	
			

			<!-- 	<ul> -->

			<!-- 				<li><a href="CtrlFonctionalitesEtu?type_action=Fonct">Consulter mes absences </a></li> -->
			<!-- 			</ul> -->
		</div>




x




			
		
</body>
</html>