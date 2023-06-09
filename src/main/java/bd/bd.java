package bd;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.hibernate.engine.jdbc.BinaryStream;



import metier.Users;





public class bd {
	
	//Propriétés
	private static String URL= "jdbc:mysql://localhost:3307/db_22009886_2"; 
	private static String LOGIN= "22009886";
	private static String PWD= "V00WM2";
	
	private static Connection cx;
	
	
	//Methode de connextion a la bdd
	public static void connection() throws Exception{
		
		//Chargement du pilote
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			throw new Exception("Erreur BD.connexion() - Chargement du pilote - " + cnfe.getMessage());
		}
		try {
			cx=DriverManager.getConnection(URL,LOGIN,PWD);
		} catch (SQLException sqle) {
			throw new Exception ("Erreur BD.connexion() - Ouverture à la connexion - "+ sqle.getMessage());
		}
	}
	
	public static void uploadPhoto(Users user,String filePath) throws Exception{
	if(bd.cx==null) {
		bd.connection();}
				
		  String updateSQL = "UPDATE users SET Photo = ? WHERE identifiant = ?";
		  PreparedStatement statement = cx.prepareStatement(updateSQL);
		  		  
		  statement.setString(1, filePath);
		  statement.setString(2, user.getIdentifiant());
		  
		  statement.executeUpdate();

		// 关闭连接和语句对象
		  statement.close();
		  cx.close();  
}
	public static String TelechargerPhoto(Users user) throws Exception{
		if(bd.cx==null) {
			bd.connection();}
		String photo = "";			
	    String SQL = "SELECT photo FROM users WHERE identifiant = ?";
	    PreparedStatement statement = cx.prepareStatement(SQL);
			  		
		statement.setString(1,  user.getIdentifiant());
		  
		ResultSet rs = statement.executeQuery();

	    if (rs.next()) {
	        photo = rs.getString("photo");
	    }
			
	 // 关闭连接和语句对象
	    rs.close();
	    statement.close();
	    cx.close();  
	return photo;
	}
	public static Users AfficherProfil(String email) throws Exception {
		
		if(bd.cx==null) 
		bd.connection();
		
		String sql="SELECT * FROM users Where identifiant=?";
		Users user=null;
		
		try(PreparedStatement st = cx.prepareStatement(sql)) 
		{
			st.setString(1, email);
			try(ResultSet rs=st.executeQuery();){
				while(rs.next()) {
					user = new Users(email,null,rs.getString("nom"),rs.getString("prenom"),rs.getString("sexe"),rs.getDate("dateNaissance"),rs.getString("mailSupplement"),rs.getString("photo"));
				}
			}
		}
		catch(SQLException sqle) 
		{
			throw new Exception("bd.AfficherProfil() - Erreur a l'affiche du profil");		
		}	
		return user;	
	}
	
	
	public static PDDocument telechargerPDF(String codeSeance) throws Exception {
		
		if(bd.cx==null) 
		bd.connection();
		
		
		PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
        contentStream.newLineAtOffset(50, 700);
			
		ArrayList<String> PDF = new ArrayList<String>();
		PDF = bd2.consulterEtuParticipe(codeSeance);
		
		for(int i=0;i<PDF.size();i++) {
			String sql="SELECT Status FROM Participer WHERE CodeU=? AND CodeSeance=? ";		
				try(PreparedStatement st = cx.prepareStatement(sql)) 
				{
					st.setString(1, PDF.get(i));
					st.setString(2, codeSeance);
					
					String nomprenom = bd2.consulterNom(Integer.parseInt(PDF.get(i)));
						try(ResultSet rs=st.executeQuery();){
							while(rs.next()) {
								
				                contentStream.showText("Name: " + nomprenom);
				                contentStream.newLine();
				                contentStream.showText("Status: " + rs.getString("Status"));
				                contentStream.newLine();
				}
							contentStream.endText();
				            contentStream.close();
				            rs.close();
				            st.close();					        				            
			}
		}
		catch(SQLException sqle) 
		{
			throw new Exception("bd.telechargerPDF() - Erreur au telechargement pdf");		
		}	
		
		}
		return document;
	}
	
	
	

	

}//fin classe