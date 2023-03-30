package crtl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bd.bd;
import dao.TestHibernate;
import metier.Justificatif;
import metier.Users;

/**
 * Servlet implementation class AjouterJust
 */
@WebServlet("/CtrlAjouterJust")
@MultipartConfig(

	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10, // 10MB
	    maxRequestSize = 1024 * 1024 * 50
	)
public class CtrlAjouterJust extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private static final String UPLOAD_DIR = "uploads";
       
    
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	
		}
	

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		javax.servlet.http.HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		String nom= (String) session.getAttribute("nom");
	
		
		// 获取应用程序的真实路径
        String applicationPath = request.getServletContext().getRealPath("");
        // 将上传文件存储到指定的目录
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        File uploadFolder = new File(uploadFilePath);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdir();
        }
        // 获取上传的文件
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String filePath = UPLOAD_DIR + File.separator + fileName;

        // 将上传的文件保存到指定的目录
        InputStream inputStream = filePart.getInputStream();
        Files.copy(inputStream, Paths.get(uploadFilePath + File.separator + fileName),
                StandardCopyOption.REPLACE_EXISTING);
        
 

        try {
        	TestHibernate.createJustFromFile(id, filePath);
        	request.setAttribute("nom", nom);
        	request.setAttribute("msg_info", "Justificatif envoyé à la scolarité");
        	request.getRequestDispatcher("AcceuilEtudiant").forward(request,response);
    	
		} catch (Exception e) {
			e.printStackTrace();
		}


		
//		
//		File liste = request.getParameterValues("file");
//		
//		
//		
//
//		for (String s : liste) {
//			TestHibernate.createJustFromFile(id, s);
//		}
//		

		
		request.getRequestDispatcher("AcceuilEtudiant").forward(request,response);
	}

}
