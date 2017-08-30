package fr.codevallee.formation.tp;

import static spark.Spark.get;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.codevallee.formation.tp.client.Adresse;
import fr.codevallee.formation.tp.client.Article;
import fr.codevallee.formation.tp.client.ArticleDescription;
import fr.codevallee.formation.tp.client.Client;
import fr.codevallee.formation.tp.client.Facture;
import fr.codevallee.formation.tp.client.LigneDeFacture;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

public class Router implements SparkApplication {

	public void init() {

		// Création des tables
		Map<String, Object> attributes = new HashMap<>();
		get("/afficher", (request, response) -> {
			// Map<String, Object> attributes = new HashMap<>();

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			
			// création d'une description
			ArticleDescription articleDescription1 = new ArticleDescription("trousse de crayons de couleur");
			ArticleDescription articleDescription2 = new ArticleDescription("ardoise margique");
			ArticleDescription articleDescription3 = new ArticleDescription("ciseau pour gaucher");
			ArticleDescription articleDescription4 = new ArticleDescription("equerre incassable");

			// Ajout dans la base
			entityManager.getTransaction().begin();
			entityManager.persist(articleDescription1);
			entityManager.persist(articleDescription2);
			entityManager.persist(articleDescription3);
			entityManager.persist(articleDescription4);
			entityManager.getTransaction().commit();

			// création d'un article
			Article article1 = new Article(25, articleDescription1, "Ref001");
			Article article2 = new Article(40, articleDescription2, "Ref002");
			Article article3 = new Article(8, articleDescription3, "Ref003");
			Article article4 = new Article(12, articleDescription4, "Ref004");

			entityManager.getTransaction().begin();
			entityManager.persist(article1);
			entityManager.persist(article2);
			entityManager.persist(article3);
			entityManager.persist(article4);
			entityManager.getTransaction().commit();

			Adresse adresseDeLivraison1 = new Adresse(12, "rue des pins", 63110, "Beaumont");
			Adresse adresseDeLivraison2 = new Adresse(2, "avenue de la république", 44000, "Nantes");
			Adresse adresseDeLivraison3 = new Adresse(445, "impasse des alizés", 95600, "Eaubonne");
			Adresse adresseDeLivraison4 = new Adresse(22, "route Nationale", 59000, "Lille");

			entityManager.getTransaction().begin();
			entityManager.persist(adresseDeLivraison1);
			entityManager.persist(adresseDeLivraison2);
			entityManager.persist(adresseDeLivraison3);
			entityManager.persist(adresseDeLivraison4);
			entityManager.getTransaction().commit();

			Adresse adresseDeFacturation1 = new Adresse(5, "route de l'église", 63000, "Clermont-Ferrand");
			Adresse adresseDeFacturation2 = new Adresse(2, "avenue de la république", 44000, "Nantes");
			Adresse adresseDeFacturation3 = new Adresse(445, "impasse des alizés", 95600, "Eaubonne");
			Adresse adresseDeFacturation4 = new Adresse(65, "rue de la soif", 59000, "Lille");

			entityManager.getTransaction().begin();
			entityManager.persist(adresseDeFacturation1);
			entityManager.persist(adresseDeFacturation2);
			entityManager.persist(adresseDeFacturation3);
			entityManager.persist(adresseDeFacturation4);
			entityManager.getTransaction().commit();

			Client client1 = new Client("Jean", "DelaFontaine", 21, adresseDeFacturation1, adresseDeLivraison1, null);
			Client client2 = new Client("Paul", "Goldorak", 12, adresseDeFacturation2, adresseDeLivraison2, null);
			Client client3 = new Client("Sonia", "Gpaletemps", 15, adresseDeFacturation3, adresseDeLivraison3, null);
			Client client4 = new Client("Michel", "Ratatouille", 56, adresseDeFacturation4, adresseDeLivraison4, null);

			entityManager.getTransaction().begin();
			entityManager.persist(client1);
			entityManager.persist(client2);
			entityManager.persist(client3);
			entityManager.persist(client4);
			entityManager.getTransaction().commit();

			LigneDeFacture ligneDeFacture1 = new LigneDeFacture(article1, 10);
			LigneDeFacture ligneDeFacture2 = new LigneDeFacture(article2, 13);
			LigneDeFacture ligneDeFacture3 = new LigneDeFacture(article3, 1);
			LigneDeFacture ligneDeFacture4 = new LigneDeFacture(article4, 5);

			entityManager.getTransaction().begin();

			Set<LigneDeFacture> lignesDeFacture1 = new HashSet<>();
			lignesDeFacture1.add(ligneDeFacture1);

			entityManager.persist(ligneDeFacture1);

			Set<LigneDeFacture> lignesDeFacture2 = new HashSet<>();
			lignesDeFacture2.add(ligneDeFacture2);
			entityManager.persist(ligneDeFacture2);

			Set<LigneDeFacture> lignesDeFacture3 = new HashSet<>();
			lignesDeFacture3.add(ligneDeFacture3);
			entityManager.persist(ligneDeFacture3);

			Set<LigneDeFacture> lignesDeFacture4 = new HashSet<>();
			lignesDeFacture4.add(ligneDeFacture4);
			entityManager.persist(ligneDeFacture4);

			entityManager.getTransaction().commit();

			Date date = new Date();
			Facture facture1 = new Facture(client1, lignesDeFacture1, date, Statut.PAYE);
			facture1.setLigneDeFactures(lignesDeFacture1);
			Facture facture2 = new Facture(client2, lignesDeFacture2, date, Statut.NON_PAYE);
			facture2.setLigneDeFactures(lignesDeFacture2);
			Facture facture3 = new Facture(client3, lignesDeFacture3, date, Statut.PAYE);
			facture3.setLigneDeFactures(lignesDeFacture3);
			Facture facture4 = new Facture(client4, lignesDeFacture4, date, Statut.PAYE);
			facture4.setLigneDeFactures(lignesDeFacture4);

			entityManager.getTransaction().begin();
			entityManager.persist(facture1);
			entityManager.persist(facture2);
			entityManager.persist(facture3);
			entityManager.persist(facture4);
			entityManager.getTransaction().commit();

			entityManager.getTransaction().begin();
			Set<Facture> tabFacture = new HashSet<Facture>();
			tabFacture.add(facture1);
			entityManager.persist(facture1);
			client1.setFactures(tabFacture);
			facture1.setClient(client1);

			Set<Facture> tabFacture2 = new HashSet<Facture>();
			tabFacture2.add(facture2);
			entityManager.persist(facture2);
			client2.setFactures(tabFacture2);
			facture2.setClient(client2);

			Set<Facture> tabFacture3 = new HashSet<Facture>();
			tabFacture3.add(facture3);
			entityManager.persist(facture3);
			client3.setFactures(tabFacture3);
			facture3.setClient(client3);

			Set<Facture> tabFacture4 = new HashSet<Facture>();
			tabFacture4.add(facture4);
			entityManager.persist(facture4);
			client4.setFactures(tabFacture4);
			facture4.setClient(client4);

			entityManager.getTransaction().commit();

			/////////////////////////////////////////////////////////////////////////////////

			// Affichages des clients
			System.out.println("voici la liste des clients" + "\n");
			afficheClient(entityManager, 17);
			afficheClient(entityManager, 18);
			afficheClient(entityManager, 19);
			afficheClient(entityManager, 20);

			// System.out.println(entityManager.find(Client.class, 18));
			//
			// System.out.println(entityManager.find(Client.class, 19));
			//
			// System.out.println(entityManager.find(Client.class, 20));
			//
			System.out.println("\n");

			// Affichage des Articles
			System.out.println("voici la liste des Articles" + "\n");
			afficherArticle(entityManager, 5);
			afficherArticle(entityManager, 6);
			afficherArticle(entityManager, 7);
			afficherArticle(entityManager, 8);

			// Affichage des descriptions d'articles
			System.out.println("voici la liste des descriptions d'articles" + "\n");
			afficherArticleDescription(entityManager, 1);
			afficherArticleDescription(entityManager, 2);
			afficherArticleDescription(entityManager, 3);
			afficherArticleDescription(entityManager, 4);

			return new ModelAndView(attributes, "home.ftl");
		}, getFreeMarkerEngine());

	}

	static void afficheClient(EntityManager entityManager, int i) {
		// TODO Auto-generated method stub

		System.out.println("Prénom= " + entityManager.find(Client.class, i).getPrenom() + "; Nom = "
				+ entityManager.find(Client.class, i).getNom() + "; age = "
				+ entityManager.find(Client.class, i).getAge() + " ans" + "\n" + " Adresse de Facturation = "
				+ entityManager.find(Client.class, i).getAdresseDeFacturation().getNumeroDeRue() + " "
				+ entityManager.find(Client.class, i).getAdresseDeFacturation().getNomDeRue() + " à "
				+ entityManager.find(Client.class, i).getAdresseDeFacturation().getCodePostal() + " "
				+ entityManager.find(Client.class, i).getAdresseDeFacturation().getVille() + "\n"
				+ " Adresse de Livraison = "
				+ entityManager.find(Client.class, i).getAdresseDeLivraison().getNumeroDeRue() + " "
				+ entityManager.find(Client.class, i).getAdresseDeLivraison().getNomDeRue() + " à "
				+ entityManager.find(Client.class, i).getAdresseDeLivraison().getCodePostal() + " "
				+ entityManager.find(Client.class, i).getAdresseDeLivraison().getVille());

	}

	static void afficherArticle(EntityManager entityManager, int i) {
		// TODO Auto-generated method stub
		System.out.println("description de l'article = " + entityManager.find(Article.class, i).getArticleDescription()
				+ "; prix de l'article = " + entityManager.find(Article.class, i).getPrixArticle() + " "
				+ "référence = " + entityManager.find(Article.class, i).getRefArticle());

	}

	static void afficherArticleDescription(EntityManager entityManager, int i) {
		// TODO Auto-generated method stub
		System.out.println("Description de l'article " + entityManager.find(ArticleDescription.class, i));
	}

	private FreeMarkerEngine getFreeMarkerEngine() {
		FreeMarkerEngine engine = new FreeMarkerEngine();
		Configuration configuration = new Configuration(new Version(2, 3, 23));
		configuration.setTemplateUpdateDelayMilliseconds(Long.MAX_VALUE);
		configuration.setClassForTemplateLoading(FreeMarkerEngine.class, "");
		engine.setConfiguration(configuration);
		return engine;
	}

}