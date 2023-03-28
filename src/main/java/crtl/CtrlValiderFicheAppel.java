package crtl;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.bd2;
import metier.Etudiant;

/**
 * Servlet implementation class CtrlEngFicheAppel
 */
@WebServlet("/CtrlValiderFicheAppel")
public class CtrlValiderFicheAppel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String[] studentIds = request.getParameterValues("students[]");
			String seanceId = request.getParameter("seance_id");
			try {
				String rs2 = bd2.updateStatusFicheAppel(seanceId);
				if (studentIds != null) {
					int i=0;
					for (String studentId : studentIds) {
						String rs = bd2.updateStatusEtu(studentId, seanceId);
						
						request.setAttribute("id"+i, studentId);
						i++;
					}
					request.setAttribute("nb", i);
					request.getRequestDispatcher("testValider").forward(request, response);
				}

			} catch (Exception ex) {
			
			}
		}
	}

