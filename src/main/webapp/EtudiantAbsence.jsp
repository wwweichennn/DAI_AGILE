<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="css/EtudiantAbsence.css">
<link rel="stylesheet" type="text/css" href="css/flexbox.css">
<link rel="stylesheet" type="text/css" href="css/utils.css">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Absence et Retards</title>
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
	
	<!-- table -->
	<div class="container">
		<h1>L'assiduité de Rong en cours.</h1>
		
		<table data-component="datatable" id="example" data-locale="en" data-search="true">
            <thead>
                <tr>
                    <th>IdCours</th>
                    <th>Nom de Cours</th>
                    <th>Nombre de Absence</th>
                    <th>Nombre de Retard</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>124</td>
                    <td>Agile</td>
                    <td>2</td>
                    <td>3</td>
                </tr>
                <tr>
                    <td>1224</td>
                    <td>Anglais</td>
                    <td>1</td>
                    <td>3</td>
                </tr>
                <tr>
                    <td>1543</td>
                    <td>Big Data</td>
                    <td>0</td>
                    <td>1</td>
                </tr>
                
            </tbody>
          </table>
          
	</div>
	
	<script src="js/locales.js"></script>
    <script src="js/datatable.js"></script> 
</body>
</html>