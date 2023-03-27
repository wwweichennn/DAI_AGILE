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
		<form action="ServletPDF" method="POST">
		<p id="id" name="codeSeance" class="invisible">${requestScope.id_trans}</p>
		</form>
		<h1 class="titre">
			Fiche d'appel pour le cours <b>${requestScope.cours}</b> le<b>
				${requestScope.date}</b>
		</h1>
		<ul class="appel" id="student-list">
			<%
			int nb = (int) request.getAttribute("nb_etudiant");
			for (int i = 0; i < nb; i++) {
				int j = i + 1;
				out.println("<li class='appel-item'>");
				out.println("<img src='imgStudent/" + j + ".jpg' alt='Photo de l'étudiant " + i + "' class='imge' id='img" + i + "'>");
				out.println("<input type='hidden' id='etu_id" + i + "' value='"+request.getAttribute("etudiant_id" + i)+"'>");
				out.println("<h3>" + request.getAttribute("etudiant_nom" + i) + " " + request.getAttribute("etudiant_prenom" + i)
				+ "</h3>");
				out.println("<span class='formation'>" + request.getAttribute("etudiant_formation" + i) + "</span>");
				out.println("<span class='present' id='text" + i + "'>n'a pas été appelé</span>");
				out.println("</li>");
			}
			%>
		</ul>

		<input type="button" class="btn" value="Enregistrer" onclick="location.href='CtrlActionFicheAppel?type_action=enregistrer'">
		<input type="button" class="btn" id="btnValider" value="Valider" onclick="submitData()"> 
		<input type="submit" class="btn" value="Télécharger PDF" onclick="">
	</form>
	<p id="test"></p>
	</div>
	<script>
		const data = [];
		var nb = document.getElementById("nb").innerHTML;
		let imageId, textId;
		for (let i = 0; i < nb; i++) {
			imageId = "img" + i;
			textId = "text" + i;
			data.push({
				imageId : imageId,
				textId : textId
			});
		}

		data.forEach(function(item) {
			const image = document.getElementById(item.imageId);
			const text = document.getElementById(item.textId);
			let index = 0;
			const colors = [ "green", "red", "orange" ];
			const captions = [ "present", "absent", "retard" ];
			image.addEventListener("click", function() {
				image.style.borderColor = colors[index % colors.length];
				text.innerHTML = captions[index % captions.length];
				index++;
			});
		});

		function submitData() {
		    // 获取学生列表元素
		    var nb = document.getElementById("nb").innerHTML;
		    var seanceID = document.getElementById("id").innerHTML;
		    var studentItems = [];

		    for (let i = 0; i < nb; i++) {
		        const text = document.getElementById("text" + i);
		        if (text.innerHTML === "absent") {
		            studentItems.push(document.getElementById("etu_id" + i));
		        }
		    }

		    // 创建一个包含所有学生值的数组
		    var students = [];
		    for (var i = 0; i < studentItems.length; i++) {
		        students.push(studentItems[i].getAttribute('value'));
		    }

		    // 将学生数组添加到表单数据中
		    var formData = new FormData();
		    for (var j = 0; j < students.length; j++) {
		        formData.append('students[]', students[j]);
		    }
		    formData.append('seance_id', seanceID);
		    
		    var xhr = new XMLHttpRequest();
		    xhr.open('POST', 'CtrlValiderFicheAppel', true);
		    xhr.send(formData);


		}
	</script>
</body>
</html>