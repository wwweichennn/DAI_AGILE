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
	String mois = null;
	





	if (action ==  null)
		url = "AcceuilEtudiant";
	else
		{
	

		switch (action)
			{
		
			case "Janvier":
				url = "AbscencesDuMoi";
				mois="01";
				break;
			case "Fevrier":
				url = "AbscencesDuMoi";
				mois="02";
				break;
			case "Mars":
				url = "AbscencesDuMoi";
				mois="03";
				break;
			case "Avril":
				url = "AbscencesDuMoi";
				mois="04";
				break;
			case "Mai":
				url = "AbscencesDuMoi";
				mois="05";
				break;
			case "Juin":
				url = "AbscencesDuMoi";
				mois="06";
				break;
			case "Septembre":
				url = "AbscencesDuMoi";
				mois="09";
				break;
			case "Octobre":
				url = "AbscencesDuMoi";
				mois="10";
				break;
			case "Novembre":
				url = "AbscencesDuMoi";
				mois="11";
				break;
			case "Decembre":
				url = "AbscencesDuMoi";
				mois="12";
				break;

			default:
				url = "AbscencesDuMoi";
			}
		
		}
	
	List<Seance> liste = TestHibernate.listAbsencesEtudiantMois(id,mois);
	

	//Pour un chainage vers page des IPM 
	request.setAttribute("listeAbs", liste);
	

	// Chainage.
	request.setAttribute("identifiant", id);
	request.setAttribute("Mois", action);
	request.getRequestDispatcher(url).forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
