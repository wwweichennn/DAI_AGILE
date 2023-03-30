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
				<li><a href="CtrlFonctionalitesEtu">Accueil</a>
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



			
				<h3>Dernieres abscences </h3><br>
<%-- 		<%= request.getParameter("type_Moi") %> --%>
		
			
<%-- 			<p><%= session.getAttribute("id") %></p><br> --%>
		
		

		
	<table style="width:100%" border="1">
  <tr>
    <th>Date</th>
    <th>Heure</th>
    <th>Cours</th>
   	<th>Justificatif</th>

  </tr>
  <form action ="CtrlAjouterJust" method="post" enctype="multipart/form-data">

<!-- 	enctype="multipart/form-data -->
	<%
	
	for (Seance s :(List<Seance>)request.getAttribute("listeAbs") )
	{
		out.print("<tr>");
		out.print("<td>"+s.getDateS()+"</td>");
		out.print("<td>"+s.getHeureDebut()+"</td>");
		out.print("<td>"+s.getCours().getNomCours()+"</td>");
		out.print("<td> <label for='file'>SELECT</label> <input type='file' name='file' /></td>");
		out.println("</tr>");
				
	}
	List<Object> files = new ArrayList<>();
				                    	
	%>
			
	

		</table >
		
		 <input type="submit" value="Upload">
		 </form>
		 
		 <button ><a href="CtrlFonctionalitesEtu?type_Fonct=Retour" >Retour</a></button>
	
			

			<!-- 	<ul> -->

			<!-- 				<li><a href="CtrlFonctionalitesEtu?type_action=Fonct">Consulter mes absences </a></li> -->
			<!-- 			</ul> -->
		</div>




x




			
		
</body>
</html>