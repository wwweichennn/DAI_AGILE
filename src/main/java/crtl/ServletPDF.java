package crtl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import bd.bd;
import bd.bd2;

/**
 * Servlet implementation class ServletPDF
 */
//@WebServlet("/ServletPDF/pdf")
public class ServletPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletPDF() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
        contentStream.newLineAtOffset(100, 700);
        contentStream.showText("Hello World");
        contentStream.endText();
        contentStream.close();

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"example.pdf\"");
        document.save(response.getOutputStream());
        document.close();
		
				
/*
		String URL = "jdbc:mysql://localhost:3307/db_22009886_2";
		String LOGIN = "22009886";
		String PWD = "V00WM2";
		Connection cx;

		String codeSeance = (String) request.getAttribute("codeSeance");

		try {
			cx = DriverManager.getConnection(URL, LOGIN, PWD);
			Statement statement = cx.createStatement();
			ArrayList<String> PDF = new ArrayList<String>();

			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			
			contentStream.beginText();
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
			contentStream.newLineAtOffset(50, 700);
			
			try {
				PDF = bd2.consulterEtuParticipe(codeSeance);
				for (int i = 0; i < PDF.size(); i++) {
					String nomprenom = bd2.consulterNom(Integer.parseInt(PDF.get(i)));
					String sql = "SELECT Status FROM Participer WHERE CodeU=? AND CodeSeance=? ";
					
					try (PreparedStatement st = cx.prepareStatement(sql)) {
						st.setString(1, PDF.get(i));
						st.setString(2, codeSeance);						
						try (ResultSet rs = st.executeQuery();) {
							while (rs.next()) {
								contentStream.showText("Name: " + nomprenom);
								contentStream.newLine();
								contentStream.showText("Status: " + rs.getString("Status"));
								contentStream.newLine();
							}							
						}
					}
				}
				contentStream.endText();
				contentStream.close();

				document.save("mydocument.pdf");
				
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=mydocument.pdf");
				
				OutputStream out = response.getOutputStream();
				document.save(System.out);
				document.close();
				out.flush();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
