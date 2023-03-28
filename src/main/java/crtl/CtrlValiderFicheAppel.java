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
import javax.servlet.http.Cookie;

import bd.bd2;
import metier.Etudiant;
import metier.Seance;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies) {
				
				if(cookie.getName().equals("studentid")) {
					
					
					String etu_id_value=cookie.getValue();
					String[] etu_id=etu_id_value.split(",");
					for(String s:etu_id) {
						System.out.println(s);
					}
				}
			}
			
		}
	
					
		request.getRequestDispatcher("testValider").forward(request, response);
			
		}
	}

