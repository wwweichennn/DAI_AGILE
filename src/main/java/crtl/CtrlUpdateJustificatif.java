package crtl;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dao.TestHibernate;

/**
 * CtrlUpdateJustificatif
 */
@WebServlet("/CtrlUpdateJustificatif")
public class CtrlUpdateJustificatif extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer les paramètres checker et les mettre dans une session
		String [] idChecked = request.getParameterValues("justifId");

		HttpSession session = request.getSession(true);

		session.setAttribute("idChecked", idChecked);

		//Vérifier si nul
		String erreur="";
		String info ="";
		if(idChecked == null) {
			erreur = "Vous n'avez pas coché de case";

			//Chainage vers la page de vérification
			request.setAttribute("msg_erreur", erreur);
			request.getRequestDispatcher("Scolarite/VerifJustificatif.jsp").forward(request, response);
		}
		else {
			try {
				//Si tous se passe bien : modification
				for (String just : idChecked) {
					int idJ = Integer.parseInt(just);
					TestHibernate.updateJustificatif(idJ, true);
				}

				//Si OK
				info = "Justificatif validé";
				request.setAttribute("msg_conf", info);
				request.getRequestDispatcher("Scolaraite/AcceuilScolarite.jsp").forward(request, response);

			} //Si KO
			catch(Exception ex) {
				//Chainage vers Supprimer + message d'erreur
				info= "erreur de modification";
				request.setAttribute("msg_erreur", ex.getMessage());
				request.getRequestDispatcher("Scolarite/VerifJustificatif.jsp").forward(request, response);
			}
		}		
	}

	/**
	 * doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
