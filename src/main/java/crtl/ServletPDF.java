package crtl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import bd.bd;

/**
 * Servlet implementation class ServletPDF
 */
@WebServlet("/ServletPDF")
public class ServletPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletPDF() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			
			bd.telechargerPDF();
			document.close();
			
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=your_file.pdf");
			
			
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
