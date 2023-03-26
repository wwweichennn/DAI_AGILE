package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import metier.Cours;
import metier.Enseignant;
import metier.Etudiant;
import metier.Justificatif;
import metier.Scolarite;
import metier.Seance;
import metier.Users;


/**
 * Hibernate.
 */
public class TestHibernate
{
	/**
	 * Constante.
	 */

	/*----- Format de date -----*/
	private static final SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final SimpleDateFormat DFDATE = new SimpleDateFormat("dd/MM/yyyy");


	/**
	 * Création, enregistrement et lecture d'objets.
	 */
	/*----- Création et enregistrement d'employés -----*/
	public static void createCours ()
		{
		/*----- Ouverture de la session -----*/
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
			{
			/*----- Ouverture d'une transaction -----*/
			Transaction t = session.beginTransaction();

			Cours c1=new Cours("DAI");
			Cours c2=new Cours("management agile");
			Cours c3=new Cours("big data");
			Cours c4=new Cours("application oriente service");
			Cours c5=new Cours("anglaise");
			Cours c6=new Cours("urbanisation et architecture d'entreprise");
			Cours c7=new Cours("innovation");
			Cours c8=new Cours("conception de site web");
			Cours c9=new Cours("base de donneés");
			Cours c10=new Cours("programmation");

			session.save(c1);
			session.save(c2);
			session.save(c3);
			session.save(c4);
			session.save(c5);
			session.save(c6);
			session.save(c7);
			session.save(c8);
			session.save(c9);
			session.save(c10);

			Users u1 =  session.get(Users.class, 1);
			Users u2 =  session.get(Users.class, 2);
			
			u1.ajouteCours(c6);
			u2.ajouteCours(c1);
			
			t.commit();
			session.close();
			}
		}

	public static void createUsers () throws ParseException
	{
	/*----- Ouverture de la session -----*/
	try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
		/*----- Ouverture d'une transaction -----*/
		Transaction t = session.beginTransaction();

		Enseignant u1=new Enseignant("weichen@gmail.com","1234","sun","weichen","Mme",DFDATE.parse("15/11/1998"),"aaa@qqq","aaaaaaaaaa","MF201");
		Enseignant u2=new Enseignant("zhibo@gmail.com","1234","xie","zhibo","M",DFDATE.parse("04/04/1998"),"aaa@qqq","aaaaaaaaaa","MF202");

		Etudiant u3=new Etudiant("marong@gmail.com","1234","Ma","rong","Mme",DFDATE.parse("15/11/1998"),"aaa@qqq","aaaaaaaaaa","IPM","FI");
		Etudiant u4=new Etudiant("jean@gmail.com","1234","Jean","martin","M",DFDATE.parse("04/04/1998"),"aaa@qqq","aaaaaaaaaa","IPM","FA");
		Etudiant u5=new Etudiant("thomas@gmail.com","1234","Thomas","Robert","M",DFDATE.parse("15/11/1998"),"aaa@qqq","aaaaaaaaaa","IPM","FI");
		Etudiant u6=new Etudiant("girard@gmail.com","1234","Girard","Marty","M",DFDATE.parse("04/04/1998"),"aaa@qqq","aaaaaaaaaa","IPM","FA");
		Etudiant u7=new Etudiant("vincent@gmail.com","1234","Vincent","Julien","M",DFDATE.parse("15/11/1998"),"aaa@qqq","aaaaaaaaaa","IPM","FI");
		Etudiant u8=new Etudiant("benoit@gmail.com","1234","Benoit","Jacob","M",DFDATE.parse("04/04/1998"),"aaa@qqq","aaaaaaaaaa","IPM","FA");

		Scolarite u9=new Scolarite("robin@gmail.com","1234","Robin","Adam","Mme",DFDATE.parse("15/11/1998"),"aaa@qqq","aaaaaaaaaa","ME001");
		Scolarite u10=new Scolarite("barbier@gmail.com","1234","Barbier","Antoine","M",DFDATE.parse("04/04/1998"),"aaa@qqq","aaaaaaaaaa","MF204");

		session.save(u1);
		session.save(u2);
		session.save(u3);
		session.save(u4);
		session.save(u5);
		session.save(u6);
		session.save(u7);
		session.save(u8);
		session.save(u9);
		session.save(u10);
	
		t.commit();
		session.close();
		}
	}
	public static void createSeance () throws ParseException
	{
	/*----- Ouverture de la session -----*/
	try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
		/*----- Ouverture d'une transaction -----*/
		Transaction t = session.beginTransaction();
		
		Users u1 =  session.get(Users.class, 1);
		Cours c1 =  session.get(Cours.class, 1);
		Users u2 =  session.get(Users.class, 2);
		Cours c2 =  session.get(Cours.class, 2);
		Cours c3 =  session.get(Cours.class, 3);
		Cours c4 =  session.get(Cours.class, 4);
		Cours c5 =  session.get(Cours.class, 5);
		
		Seance s1= new Seance("ME401",DFDATE.parse("23/03/2023"),270,DF.parse("23/03/2023 08:00"),"valide",u1,c4);
		Seance s2= new Seance("MF105",DFDATE.parse("24/03/2023"),180,DF.parse("24/03/2023 14:00"),"enregistrer",u1,c3);
		Seance s3= new Seance("ME310",DFDATE.parse("20/03/2023"),180,DF.parse("20/03/2023 14:00"),"novalide",u1,c2);
		
		Seance s4= new Seance("ME410",DFDATE.parse("21/03/2023"),90,DF.parse("21/03/2023 11:00"),"novalide",u1,c3);
		Seance s5= new Seance("MF103",DFDATE.parse("27/03/2023"),180,DF.parse("27/03/2023 14:00"),"novalide",u1,c3);
		Seance s6= new Seance("MC405",DFDATE.parse("28/03/2023"),180,DF.parse("28/03/2023 09:30"),"novalide",u1,c1);

		Seance s7= new Seance("ME403",DFDATE.parse("29/03/2023"),270,DF.parse("29/03/2023 08:00"),"novalide",u1,c5);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);
		session.save(s7);

		
		t.commit();
		session.close();
		
		}
	
	}
	public static void createParticipe () throws ParseException
	{
	/*----- Ouverture de la session -----*/
	try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
		/*----- Ouverture d'une transaction -----*/
		Transaction t = session.beginTransaction();
		
		Users u3 =  session.get(Users.class, 3);
		Users u4 =  session.get(Users.class, 4);
		Users u5 =  session.get(Users.class, 5);
		Users u6 =  session.get(Users.class, 6);
		Users u7 =  session.get(Users.class, 7);
		Users u8 =  session.get(Users.class, 8);

		
		Seance s1= session.get(Seance.class, 1);
		Seance s2= session.get(Seance.class, 2);
		Seance s3= session.get(Seance.class, 3);
		Seance s4= session.get(Seance.class, 4);
		Seance s5= session.get(Seance.class, 5);
		Seance s6= session.get(Seance.class, 6);
		Seance s7= session.get(Seance.class, 7);

		
		u3.participe(s1, "present");
		u4.participe(s1, "present");
		u5.participe(s1, "present");
		u6.participe(s1, "present");
		u7.participe(s1, "present");
		u8.participe(s1, "present");
		
		u3.participe(s2, "present");
		u4.participe(s2, "present");
		u5.participe(s2, "present");
		u6.participe(s2, "present");
		u7.participe(s2, "present");
		u8.participe(s2, "present");
		
		u3.participe(s3, "present");
		u4.participe(s3, "present");
		u5.participe(s3, "present");
		u6.participe(s3, "present");
		u7.participe(s3, "present");
		u8.participe(s3, "present");
		
		u3.participe(s4, "present");
		u4.participe(s4, "present");
		u5.participe(s4, "present");
		u6.participe(s4, "present");
		u7.participe(s4, "present");
		u8.participe(s4, "present");
		
		u3.participe(s5, "present");
		u4.participe(s5, "present");
		u5.participe(s5, "present");
		u6.participe(s5, "present");
		u7.participe(s5, "present");
		u8.participe(s5, "present");
		
		u3.participe(s6, "present");
		u4.participe(s6, "present");
		u5.participe(s6, "present");
		u6.participe(s6, "present");
		u7.participe(s6, "present");
		u8.participe(s6, "present");
		
		u3.participe(s7, "present");
		u4.participe(s7, "present");
		u5.participe(s7, "present");
		u6.participe(s7, "present");
		u7.participe(s7, "present");
		u8.participe(s7, "present");
		
		t.commit();
		session.close();
		
		}
	
	}
	public static void createDeposerJus () throws ParseException
	{
	/*----- Ouverture de la session -----*/
	try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
		/*----- Ouverture d'une transaction -----*/
		Transaction t = session.beginTransaction();
		
		Users u3 =  session.get(Users.class, 1);
	

		Justificatif j1=new Justificatif(false,"www",DFDATE.parse("04/01/2023"),DFDATE.parse("05/01/2023"),u3);

		u3.getJustificatifs().add(j1);
		session.save(j1);
		
		t.commit();
		session.close();
		
		}
	
	}

	public static List<Seance> loadSeancesDonner (int id) 
	{
	/*----- Ouverture de la session -----*/
	try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
		{
		/*----- Ouverture d'une transaction -----*/
		Transaction t = session.beginTransaction();
		
    	List<Seance> seances = new ArrayList<>();
    	
    	Query query = session.createQuery("from Seance s where s.CodeU = :id");
    	query.setParameter("id", id);
        if (!query.getResultList().isEmpty()) {
            	seances=query.list();
            	query.list().forEach(System.out::println);
            }
        return seances;

        } catch (Exception e) {
            e.printStackTrace();
        }
	return null;
        
	}

	/**
	 * Recupère et affiche les etudiants qui n'ont pas justifier leur presence
	 * @return 
	 */
	public static List loadEtuAbsNonJustifier() {
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			Transaction t = session.beginTransaction();

			//Liste des etudiants absence non justifier

			String  hql = "SELECT u FROM Etudiant u left join u.justificatifs as j where j.statut = 0 and parcours = 1" ;		//Requete pour recupérer les étudiants


			List queryResponse = session.createQuery(hql).list();

			System.out.println("taille de la reponse : "+ queryResponse.size());
			TestHibernate.lire1(queryResponse);

			t.commit();
			return queryResponse;
		}
	
	}
	/**
	 * Programme de test.
	 */
	public static void main(String[] args) throws ParseException
		{
		
		TestHibernate.createUsers();
		TestHibernate.createCours();
		TestHibernate.createSeance();
		TestHibernate.createParticipe();
		TestHibernate.createDeposerJus();
	
		//TestHibernate.loadSeancesDonner(1);
		}

	private static void affichage (List l)
	{
	System.out.println("-----");
	l.forEach(e -> {
		for (Object obj : (Object[])e)
			System.out.print(obj + " ");
		System.out.println();
	});
	System.out.println("-----");
	}

	/**Lecture d'une liste de tableau d'objets
	 * @param l
	 */
	public static void lire (List l) {
		for(int i = 0; i < l.size(); i++) {
			Object[] tab = (Object[])l.get(i);
			for( Object obj : tab) {
				System.out.println(obj + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Lecture cast des etudiants
	 * @param l
	 */
	public static void lire1(List l) {
		for (Object obj : l) {
			if (obj instanceof Etudiant) {
				Etudiant etudiant = (Etudiant) obj;
				System.out.println(etudiant);
			}
		}
	}

	
} /*----- Fin de la classe TestHibernate -----*/

