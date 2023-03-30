<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mois</title>
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
				<h2>Veuillez choisir le mois pour lequel vous voulez consulter
					vos absences :</h2>
					<p  class="invisible">${requestScope.id}</p>
				<h2>2022</h2>
				<a href="CtrlMois?type_Moi=Septembre" class="button">Septembre</a> <a
					href="CtrlMois?type_Moi=Octobre" class="button">Octobre</a> <a
					href="CtrlMois?type_Moi=Novembre" class="button">Novembre</a>


				<a href="CtrlMoistype_Moi=Decembre" class="button">Decembre</a> <br>

				<h2>2023</h2>
				<a href="CtrlMois?type_Moi=Janvier" class="button">Janvier</a> <a
					href="CtrlMois?type_Moi=Fevrier" class="button">Fevrier</a> <a
					href="CtrlMois?type_Moi=Mars" class="button">Mars</a> <a
					href="CtrlMois?type_Moi=Avril" class="button">Avril</a> <a
					href="CtrlMois?type_Moi=Mai" class="button">Mai</a> <a
					href="CtrlMois?type_Moi=Juin" class="button">Juin</a>
			</div>

			<!-- 	<ul> -->

			<!-- 				<li><a href="CtrlFonctionalitesEtu?type_action=Fonct">Consulter mes absences </a></li> -->
			<!-- 			</ul> -->
		</div>
	</div>


</body>
</html>