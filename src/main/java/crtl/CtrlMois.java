package crtl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestHibernate;
import metier.Seance;

/**
 * Servlet implementation class CtrlMois
 */
@WebServlet("/CtrlMois")
public class CtrlMois extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	javax.servlet.http.HttpSession session = request.getSession();
	
	String id = session.getAttribute("id").toString();
	//int id = (int) request.getAttribute("id");
	String action = request.getParameter("type_Moi");
	String url;
	





	if (action ==  null)
		url = "AcceuilEtudiant";
	else
		{
	

		switch (action)
			{
			case "Modif":
				url = "ModifProfil";
				break;

			case "Janvier":
				url = "absparmois";
				break;
			case "Fevrier":
				url = "absparmois";
				break;
			case "Mars":
				url = "absparmois";
				break;
			case "Avril":
				url = "absparmois";
				break;
			case "Mai":
				url = "absparmois";
				break;
			case "Juin":
				url = "absparmois";
				break;
			case "Septembre":
				url = "absparmois";
				break;
			case "Octobre":
				url = "absparmois";
				break;
			case "Novembre":
				url = "absparmois";
				break;
			case "Decembre":
				url = "absparmois";
				break;

			default:
				url = "absparmois";
			}
		
		}
	
	List<Seance> liste = TestHibernate.listAbsencesEtudiant(id);
	

	//Pour un chainage vers page des IPM 
	request.setAttribute("listeAbs", liste);
	

	// Chainage.
	request.setAttribute("identifiant", id);
	request.setAttribute("Mois", action);
	request.getRequestDispatcher("AcceuilEtudiant").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
