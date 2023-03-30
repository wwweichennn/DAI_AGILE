<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Etudiant</title>
<link rel="stylesheet" href="style/StyleAcceuilEtu.css">


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



			<div>
				<h2>Bienvenue de nouveau, ${requestScope.nom}</h2>
				
					 
					    <a href="CtrlFonctionalitesEtu?type_Fonct=abs" class="button">Consulter mes dernieres abscences</a><br>
					    <a href="CtrlFonctionalitesEtu?type_Fonct=absmois" class="button">Consulter mes abscences par mois</a><br>
			
					
				
			<p >${msg_info}</p>
				
					
			</div>
			

			<!-- 	<ul> -->

			<!-- 				<li><a href="CtrlFonctionalitesEtu?type_action=Fonct">Consulter mes absences </a></li> -->
			<!-- 	
					</ul> -->
					
		</div>
		
	


</body>
</html>