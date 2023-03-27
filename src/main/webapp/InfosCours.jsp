<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="css/InfosCoursStyle.css">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Informations détails d'un cours</title>
</head>
<body>
	<!-- menu -->
	<div class="menu">
		<ul>
			<li><img src="img/logo-ut1.png" class="logo-ut1" /></li>
			<div class="accueil">
				<li><a href="webapp.EmploiDuTemps.jsp">Accueil</a>
			</div>
			</li>
			<li class="cours"><a href="#">Mes cours</a>
				<ul>
					<li><a href="CoursAnnee.jsp">2022-2023</a></li>
					<li><a href="">2021-2022</a></li>
				</ul></li>

			<div class="compte">
				<li><a href="#">Mon Compte</a>
					<ul>
						<li><a href="">Mes informations</a></li>
						<li>Déconnextion</li>
					</ul>
			</div>
			</li>
		</ul>
	</div>
	
	<!-- /menu -->
	<div class="container">
		<h1>Informations d'appel passé pour le cours Agile</h1>
		<div class= "all"><a href="#" id="tree-expand-all">Tout élargir</a> | <a href="#" id="tree-collapse-all">Tout réduire</a></div>
		 
		<div class="infos"><ul id="tree">
	        <li>Absences
	            <ul>
	                <li>Nombre d'absences en moyennes : 3</li>
					<li>Taux d'absence : 32.2%</li>
	                <li>Étudiants absents plus de 3 fois (injustifiées): 3
	                    <ul>
	                        <li><a href="EtudiantAbsence.jsp">Rong Ma</a></li>
	                        <li>Lily</li>
	                        <li>Bob</li>
	                    </ul>
	                </li>
	            </ul>
	        </li>
	        
	    </ul></div>
	 
		<script type="text/JavaScript"  src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	    <script type="text/JavaScript"  src="js/abixTreeList.min.js"></script>
	    <script type="text/JavaScript"  src="js/abixTreeList.js"></script>
	  
	    <script>
	        $(document).ready(function() {
	            $('#tree').abixTreeList();
	        });
	    </script>
    </div>
</body>
</html>