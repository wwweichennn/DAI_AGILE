<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="metier.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Etudiant Absent</title>
<link rel="stylesheet" type="text/css" href="css/VerifJustificatif.css">

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
				<li><a href="Scolarite/AcceuilScolarite.jsp">Accueil</a>
			</div>
			</li>

			<div class="compte">
				<li><a href="#">Mon Compte</a>
					<ul>
						<li><a href="CtrlProfil">Mes informations</a></li>
						<li><a href="webapp/index.jsp">Déconnextion</a></li>
					</ul>
			</div>
			</li>
		</ul>
	</div>


	<div class="container">
		<h1>
			Les étudiants
			<%=request.getParameter("type_promo")%>
		</h1>

		<form action="CtrlUpdateJustificatif" method="GET">

			<%!String idChecked(long id, String[] tab) {
		if (tab != null) {
			for (String s : tab) {
				if (s.equals(id + ""))
					return " checked";
			}
		} else {
			return "";
		}
		return "";
	}%>
			<table border="1">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Motif d'absence</th>
						<th>Valider</th>
					</tr>
				</thead>
				<tbody>
					<!-- Object obj : listeAbs -->
					<%
					String[] id_check = (String[]) session.getAttribute("idChecked");

					List<Object> listeAbs = (List<Object>) request.getAttribute("listeAbs"); //Recupère la liste
					int nbJustif = listeAbs.size(); //nombre des justificatifs
					for (int i = 0; i < nbJustif; i++) {
						if (listeAbs.get(i) instanceof Justificatif) { //Si cest une instance de justif avec on le cast
							Justificatif justificatif = (Justificatif) listeAbs.get(i); //devient un attribut
					%>
					<td class="invisible" id="nbJ"><%=nbJustif%></td>
					<tr>
						<td><%=justificatif.getUsersJustificatif().getNom()%></td>
						<td><%=justificatif.getUsersJustificatif().getPrenom()%></td>
						<td><%out.print("<a style='color:black' href='" + justificatif.getUrl() + "'>Justificatif");%></td>
						<td>
							<%
							out.println("<input type='checkbox' name='justifId' value='" + justificatif.getCodeJust() + "' "
									+ idChecked(justificatif.getCodeJust(), id_check) + " />");
							%>
						</td>
					</tr>
					<%
					}
					}
					%>
				</tbody>

			</table>
			<div class="btn_action">
				<button>
					<a href="/DAI_projet_new/centrale">Retour</a>
				</button>
				<input type="submit" value="Enregistrer" />
			</div>
		</form>
		<div>${requestScope.msg_erreur}</div>
	</div>

	<script type="text/JavaScript" src="js/Fonction.js"></script>
</body>
</html>