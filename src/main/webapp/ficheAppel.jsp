<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche d'Appel</title>
<link rel="stylesheet" type="text/css" href="css/ficheAppel.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
    .invisible {
  display: none;
}
  </style>
</head>
<body>
<!-- menu -->
<div class="menu">
		<ul>
			<li><img src="img/logo-ut1.png" class="logo-ut1" /></li>
			<div class="accueil">
				<li><a href="webapp.EmploiDuTemps">Accueil</a>
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
<p id="nb" class="invisible">${requestScope.nb_etudiant}</p>
<p id="id" class="invisible">${requestScope.id_trans}</p>
<h1 class="titre">Fiche d'appel pour le cours <b>${requestScope.cours}</b> le<b> ${requestScope.date}</b></h1>
<ul class="appel">
<%
int nb=(int)request.getAttribute("nb_etudiant");
for(int i=0;i<nb;i++){
	int j=i+1;
	out.println("<li class='appel-item'>");
	out.println("<img src='imgStudent/"+j+".jpg' alt='Photo de l'étudiant "+i+"' class='imge' id='img"+i+"'>");
	out.println("<p class='invisible' id='etu_id"+i+"'>"+request.getAttribute("etudiant_id"+i)+"</p>");
	out.println("<h3>"+request.getAttribute("etudiant_nom"+i)+" "+request.getAttribute("etudiant_prenom"+i)+"</h3>");
	out.println("<span class='formation'>"+request.getAttribute("etudiant_formation"+i)+"</span>");
	out.println("<span class='present' id='text"+i+"'>n'a pas été appelé</span>");
	out.println("</li>");
}
%>
</ul>
<input type="submit" class="btn" value="Enregistrer"  onclick="location.href='CtrlActionFicheAppel?type_action=enregistrer'">
<input type="submit" class="btn" value="Valider"  onclick="submitData()">
</div>
<script>
const data = [];
var nb=document.getElementById("nb").innerHTML;
let imageId, textId;
for (let i = 0; i < nb; i++) {
  imageId = "img" + i;
  textId = "text" + i;
  data.push({ imageId: imageId, textId: textId });
}

	data.forEach(function(item) {
	  const image = document.getElementById(item.imageId); 
	  const text = document.getElementById(item.textId); 
	  let index = 0;
	  const colors = ["green","red","orange"]; 
	  const captions = ["present", "absent", "retard"]; 
	  image.addEventListener("click", function() {
	    image.style.borderColor = colors[index % colors.length]; 
	    text.innerHTML = captions[index % captions.length];
	    index++; 
	  });
	});
	
function submitData() {
		  // get seance id,etudiant,statut
		  const seanceId = document.getElementById("id").innerHTML;
		  const type_action = "valider";
		  const students = [];
		  const nb = document.getElementById("nb").innerHTML;
		  for (let i = 0; i < nb; i++) {
		    const studentid = document.getElementById("etu_id" + i).innerHTML;
		    const status = document.getElementById("text" + i).innerHTML;
		    students.push({ id: studentid, status: status });
		  }

		  // data qui va etre transmit au servlet
		  const data = {
			type: type_action,
		    seance_id: seanceId,
		    students: students
		  };

		  // post
		  const xhr = new XMLHttpRequest();
		  xhr.open("POST", "CtrlActionFicheAppel");
		  xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		  xhr.send(JSON.stringify(data));

		  // chainage servlet
		  window.location.href = "CtrlActionFicheAppel";
		}
</script>
</body>
</html>