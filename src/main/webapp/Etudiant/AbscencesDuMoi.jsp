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



			
				<h3>Absences de <%= request.getParameter("type_Moi") %> </h3><br>
	
		
			
<%-- 			<p><%= session.getAttribute("id") %></p><br> --%>
		
		

		

  <form action ="CtrlAjouterJust" method="post" enctype="multipart/form-data">

<!-- 	enctype="multipart/form-data -->
	<%
	List<Seance> liste = (List<Seance>)request.getAttribute("listeAbs");
	
	{if(liste.size()!=0){
	for (Seance s : liste ){
	
		
		out.print("<ul>");
		out.print("<li>"+s.getDateS()+" "+s.getHeureDebut()+" "+s.getCours().getNomCours()+"</li>");
		out.print("</ul>");
				
	
		
		
		}}
	else
	{
		

		out.println("<h3>Pas d'absence pour ce mois!</h3>");
				
				
	}
		
	}	
	

				                    	
	%>
			
	

		
		
		
		
			

			<!-- 	<ul> -->

			<!-- 				<li><a href="CtrlFonctionalitesEtu?type_action=Fonct">Consulter mes absences </a></li> -->
			<!-- 			</ul> -->
		</div>




x




			
		
</body>
</html>