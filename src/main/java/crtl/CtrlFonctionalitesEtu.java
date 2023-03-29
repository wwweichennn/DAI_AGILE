package crtl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TestHibernate;
import metier.Seance;


/**
 * Servlet implementation class CtrlUpdateEtu
 */
@WebServlet("/CtrlFonctionalitesEtu")
public class CtrlFonctionalitesEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
//       
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
//
//	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	javax.servlet.http.HttpSession session = request.getSession();
	
	String id = session.getAttribute("id").toString();
	//int id = (int) request.getAttribute("id");
	String action = request.getParameter("type_Fonct");
	String url;
	





	if (action ==  null)
		url = "AcceuilEtudiant";
	else
		{
	

		switch (action)
			{
			case "abs":
				url = "absparmois";
				break;

			case "absmois":
				url = "CalMois";
				break;
		

			default:
				url = "AcceuilEtudiant";
			}
		
		}
	
	List<Seance> liste = TestHibernate.listAbsencesEtudiant(id);
	

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
		doPost(request, response);
	}

}
