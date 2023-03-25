package crtl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bd.bd;
import metier.Users;

/**
 * Servlet implementation class CtrlProfil
 */
@WebServlet("/CtrlProfil")
public class CtrlProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		try {
			Users user=bd.AfficherProfil(email);
			
			javax.servlet.http.HttpSession s = request.getSession();
			s.setAttribute("user", user);
			
			request.setAttribute("email",user.getIdentifiant());
			request.setAttribute("nom",user.getNom());
			request.setAttribute("prenom",user.getPrenom());
			request.setAttribute("sexe",user.getSexe());
			request.setAttribute("dateNaissance",user.getDateNaissance());
			request.setAttribute("mailSupplement",user.getMailSupplement());
			request.setAttribute("photo",user.getPhoto());
			
			request.getRequestDispatcher("Profil").forward(request, response);
		} catch (Exception e) {		
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
