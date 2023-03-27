<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Etudiant</title>
<link rel="stylesheet" href="style/StyleAcceuilEtu.css">
<style>
.button {
	background-color: #DC143C;
	border: none;
	color: white;
	padding: 20px 34px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
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


	
		<div id="content">



			<div>
				<h1>Veuillez choisir le mois pour lequel vous voulez consulter
					vos absences :</h1>
				<h2>2022</h2>
				<a href="CtrlFonctionalitesEtu?type_Moi=Septembre" class="button">Septembre</a> <a
					href="CtrlFonctionalitesEtu?type_Moi=Octobre" class="button">Octobre</a> <a
					href="CtrlFonctionalitesEtu?type_Moi=Novembre" class="button">Novembre</a>


				<a href="CtrlFonctionalitesEtu?type_Moi=Decembre" class="button">Decembre</a> <br>

				<h2>2023</h2>
				<a href="CtrlFonctionalitesEtu?type_Moi=Janvier" class="button">Janvier</a> <a
					href="CtrlFonctionalitesEtu?type_Moi=Fevrier" class="button">Fevrier</a> <a
					href="CtrlFonctionalitesEtu?type_Moi=Mars" class="button">Mars</a> <a
					href="CtrlFonctionalitesEtu?type_Moi=Avril" class="button">Avril</a> <a
					href="CtrlFonctionalitesEtu?type_Moi=Mai" class="button">Mai</a> <a
					href="CtrlFonctionalitesEtu?type_Moi=Juin" class="button">Juin</a>
			</div>

			<!-- 	<ul> -->

			<!-- 				<li><a href="CtrlFonctionalitesEtu?type_action=Fonct">Consulter mes absences </a></li> -->
			<!-- 			</ul> -->
		</div>
	</div>


</body>
</html>