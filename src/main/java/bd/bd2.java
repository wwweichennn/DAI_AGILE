package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import dao.SeanceDonner;
import metier.Cours;
import metier.Etudiant;
import metier.Seance;
import metier.Users;

public class bd2 {

	// Propriétés
	private static String URL = "jdbc:mysql://localhost:3307/db_22009886_2";
	private static String LOGIN = "22009886";
	private static String PWD = "V00WM2";

	private static Connection cx;

	// Methode de connextion a la bdd
	public static void connection() throws Exception {

		// Chargement du pilote
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			throw new Exception("Erreur BD.connexion() - Chargement du pilote - " + cnfe.getMessage());
		}
		try {
			cx = DriverManager.getConnection(URL, LOGIN, PWD);
		} catch (SQLException sqle) {
			throw new Exception("Erreur BD.connexion() - Ouverture à la connexion - " + sqle.getMessage());
		}
	}

	public static int checkLogin(String email, String password) throws Exception {

		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}
		int id = 0;
		/*----- Requête SQL -----*/
		String sql = "SELECT CodeU FROM users WHERE identifiant = ? AND motDePasse = ?";

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setString(1, email);
			st.setString(2, password);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				rs.next();
				id = rs.getInt("CodeU");
				return id;
			}
		} catch (SQLException ex) {
		}
		return id;

	}

	public static String consulterType(int code) throws Exception {
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}
		String type = "notype";
		/*----- Requête SQL -----*/
		String sql = "SELECT typeU FROM users WHERE CodeU = ?";

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setInt(1, code);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				rs.next();
				type = rs.getString("typeU");
				return type;
			}
		} catch (SQLException ex) {
		}
		return type;

	}

	public static String consulterNom(int code) throws Exception {
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}
		String nom = "no";
		String prenom = "no";
		/*----- Requête SQL -----*/
		String sql = "SELECT nom, prenom FROM users WHERE CodeU = ?";

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setInt(1, code);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				rs.next();
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				return nom + " " + prenom;
			}
		} catch (SQLException ex) {
		}
		return nom + " " + prenom;

	}

	public static ArrayList<Seance> consulterSeance(String code) throws Exception {
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}

		/*----- Requête SQL -----*/
		String sql = "SELECT * FROM Seance WHERE Seance.CodeU = ?";
		ArrayList<Seance> seance = new ArrayList<>();

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setString(1, code);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				while (rs.next()) {
					Seance newseance = new Seance(rs.getString("SalleSeance"), rs.getDate("DateSeance"),
							rs.getInt("DureeSeance"), rs.getTime("HeureDebut"), rs.getString("StatutFicheAppel"),
							new Users(), new Cours(consulterCoursNom(rs.getInt("CodeC"))));
					newseance.setIdSeance(consulterSeanceID(code, rs.getInt("CodeC"), rs.getString("SalleSeance"),
							rs.getDate("DateSeance"), rs.getTime("HeureDebut")));
					seance.add(newseance);
				}
			}
		} catch (SQLException ex) {
		}
		return seance;
	}

	public static int consulterSeanceID(String code, int codeC, String salle, Date date, Time hdebut) throws Exception {
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}

		/*----- Requête SQL -----*/
		String sql = "SELECT CodeSeance FROM Seance WHERE Seance.CodeU = ? AND Seance.CodeC= ? AND Seance.SalleSeance= ?  AND Seance.DateSeance= ? AND Seance.HeureDebut= ? ";

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setString(1, code);
			st.setInt(2, codeC);
			st.setString(3, salle);
			st.setDate(4, date);
			st.setTime(5, hdebut);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				rs.next();
				return rs.getInt("CodeSeance");
			}
		} catch (SQLException ex) {
		}
		return 0;
	}

	public static String consulterCoursNom(int code) throws Exception {
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}

		/*----- Requête SQL -----*/
		String sql = "SELECT nomCours FROM Cours WHERE Cours.CodeC = ?";

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setInt(1, code);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				rs.next();
				return rs.getString("nomCours");
			}
		} catch (SQLException ex) {
		}
		return "";
	}

	public static ArrayList<String> consulterEtuParticipe(String codeSeance) throws Exception {
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}

		/*----- Requête SQL -----*/
		String sql = "SELECT CodeU FROM Participer WHERE Participer.CodeSeance = ?";
		ArrayList<String> codeEtus = new ArrayList<String>();

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setString(1, codeSeance);
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				while (rs.next()) {
					codeEtus.add(Integer.toString(rs.getInt("CodeU")));
				}
				return codeEtus;
			}
		} catch (SQLException ex) {
		}
		return null;
	}

	public static ArrayList<Etudiant> consulterListEtu(String codeSeance) throws Exception {

		if (bd2.cx == null)
			bd2.connection();

		String sql = "SELECT * FROM users Where typeU=? AND CodeU=?";
		Etudiant e = null;
		ArrayList<Etudiant> listEtu=new ArrayList<Etudiant>();
		
		try (PreparedStatement st = cx.prepareStatement(sql)) {
			st.setString(1, "Etudiant");
			for (String code : bd2.consulterEtuParticipe(codeSeance)) {
				st.setString(2, code);
				try (ResultSet rs = st.executeQuery();) {
					while (rs.next()) {
						e = new Etudiant(null, null, rs.getString("nom"), rs.getString("prenom"), null,null,  null, rs.getString("photo"),rs.getString("parcours"),rs.getString("formation"));
						e.setCodeU(bd2.consulterEtuID(rs.getString("nom"), rs.getString("prenom")));
						listEtu.add(e);
					}
				}
			}

		} catch (SQLException sqle) {
			throw new Exception("bd.AfficherProfil() - Erreur a l'affiche du profil");
		}
		return listEtu;
	}
	
	public static int consulterEtuID(String nom, String prenom) throws Exception {
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}

		/*----- Requête SQL -----*/
		String sql = "SELECT CodeU FROM users WHERE users.nom = ? AND users.prenom= ? ";

		/*----- Ouverture de l'espace de requête -----*/
		try (PreparedStatement st = bd2.cx.prepareStatement(sql)) {
			st.setString(1,nom);
			st.setString(2,prenom);
		
			/*----- Exécution de la requête -----*/
			try (ResultSet rs = st.executeQuery()) {
				/*----- Lecture du contenu du ResultSet -----*/
				rs.next();
				return rs.getInt("CodeU");
			}
		} catch (SQLException ex) {
		}
		return 0;
	}
	
	public static String updateStatusEtu (String CodeU,String CodeS) throws Exception
	{
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}
	/*----- Requête SQL -----*/
	String sql = "UPDATE Participer SET Status = 'absence' WHERE CodeU = ? AND CodeSeance = ? ;";

	/*----- Ouverture de l'espace de requête -----*/
	try (PreparedStatement st = bd2.cx.prepareStatement(sql))
		{
		/*----- Exécution de la requête -----*/
		st.setString(1, CodeU);
		st.setString(2, CodeS);
		return st.executeUpdate() + " ";
		}
	catch (SQLException ex)
		{
		throw new SQLException("Exception bd2.updateStatusEtu() : Problème SQL - " + ex.getMessage());
		}
	}
	
	
	public static String updateStatusFicheAppel (String CodeS) throws Exception
	{
		/*----- Création éventuelle de la connexion à la base de données -----*/
		if (bd2.cx == null) {
			bd2.connection();
		}
	/*----- Requête SQL -----*/
	String sql = "UPDATE Seance SET StatutFicheAppel = 'valide' WHERE CodeSeance = ? ;";

	/*----- Ouverture de l'espace de requête -----*/
	try (PreparedStatement st = bd2.cx.prepareStatement(sql))
		{
		/*----- Exécution de la requête -----*/
		st.setString(1, CodeS);
		return st.executeUpdate() + " ";
		}
	catch (SQLException ex)
		{
		throw new SQLException("Exception bd2.updateStatusEtu() : Problème SQL - " + ex.getMessage());
		}
	}


	public static void main(String[] args) throws Exception {

		for (String s : bd2.consulterEtuParticipe("1")) {
			System.out.println(s);
		}
		for (Etudiant s : bd2.consulterListEtu("1")) {
			System.out.println(s);
		}


	}

}// fin classe