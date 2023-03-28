package crtl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.bd2;
import metier.Seance;

/**
 * Servlet implementation class CtrlCourAnnee
 */
@WebServlet("/CtrlCourAnnee")
public class CtrlCoursAnnee extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*----- Lecture de la requête en UTF-8 -----*/
		request.setCharacterEncoding("UTF-8");

		/*----- Type de la réponse -----*/
		response.setContentType("application/xml;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try (PrintWriter out = response.getWriter())
			{
			/*----- Ecriture de la page XML -----*/
			out.println("<?xml version=\"1.0\"?>");
			out.println("<liste_cours>");
			
			/*----- Récupération des paramètres -----*/
			String id = request.getParameter("id");
			try {
				ArrayList<Seance> lSeances = bd2.consulterSeance(id);		
				for (Seance s : lSeances) {
									//out.println("<id>" + s.getIdSeance() + "</id>");
									out.println("<cours>" + s.getCours().getNomCours() + "</cours>");
									out.println("<date>" + s.getDateS() + "</date>");
					}
				}
				catch (Exception ex)
				{
				out.println("<cours>Erreur - " + ex.getMessage() + "</cours>");
				}

			out.println("</liste_cours>");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
