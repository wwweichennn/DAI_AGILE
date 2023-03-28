package crtl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.bd2;
import metier.Etudiant;

/**
 * Servlet implementation class CtrlFicheAppel
 */
@WebServlet("/CtrlFicheAppel")
public class CtrlFicheAppel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String cours = request.getParameter("cours");
	    String date = request.getParameter("date");
	    request.setAttribute("cours", cours);
	    request.setAttribute("date", date);
		request.setAttribute("id_trans", id);
		try {
			ArrayList<Etudiant> listE=bd2.consulterListEtu(id);
			int i=0;
			for(Etudiant e:listE) {
				request.setAttribute("etudiant_id"+i, e.getCodeU());
				request.setAttribute("etudiant_nom"+i, e.getNom());
				request.setAttribute("etudiant_prenom"+i, e.getPrenom());
				request.setAttribute("etudiant_formation"+i, e.getFormation());
				i+=1;
			}
			request.setAttribute("nb_etudiant", i);
			request.getRequestDispatcher("ficheAppel").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
