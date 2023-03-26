package crtl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Etudiant;

/**
 * Servlet implementation class CtrlEngFicheAppel
 */
@WebServlet("/CtrlActionFicheAppel")
public class CtrlActionFicheAppel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type_action = request.getParameter("type_action");
		
		switch(type_action) {
		case "enregistrer":
			
			break;
		case "valider":
			
			
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		  String jsonString = reader.readLine();
		  JSONObject data = new JSONObject(jsonString);
		  String courseId = data.getString("course_id");
		  JSONArray studentsArray = data.getJSONArray("students");
		  List<Etudiant> students = new ArrayList<>();
		  for (int i = 0; i < studentsArray.length(); i++) {
		    JSONObject studentObject = studentsArray.getJSONObject(i);
		    String name = studentObject.getString("name");
		    String status = studentObject.getString("status");
		    students.add(new Etudiant(name, status));
		  }
	}

}
