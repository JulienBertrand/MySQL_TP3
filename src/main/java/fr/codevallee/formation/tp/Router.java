package fr.codevallee.formation.tp;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.codevallee.formation.tp.modele.Demo;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

public class Router implements SparkApplication {

	public void init() {

		// Affichage de la table
		get("/afficher", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			TypedQuery<Demo> query = entityManager.createQuery("from Demo", Demo.class);

			// System.out.println(query.getResultList());
			for (Demo i : query.getResultList()) {
				System.out.println(i.getNom());
			}
			attributes.put("objets", query.getResultList());

			return new ModelAndView(attributes, "home.ftl");
		}, getFreeMarkerEngine());

		// Ajouter une ligne
		get("/ajouter", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "ajouter.ftl");
		}, getFreeMarkerEngine());

		get("/resultat_ajouter", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String nom = request.queryParams("nom");
			String prenom = request.queryParams("prenom");
			String civilite = request.queryParams("civilite");

			attributes.put("nom", nom);
			attributes.put("prenom", prenom);
			attributes.put("civilite", civilite);

			Demo demoModifier = new Demo();
			demoModifier.setCivilite(civilite);
			demoModifier.setNom(nom);
			demoModifier.setPrenom(prenom);

			entityManager.getTransaction().begin();
			entityManager.persist(demoModifier);
			entityManager.getTransaction().commit();
			// entityManager.close();

			return new ModelAndView(attributes, "resultat_ajouter.ftl");

		}, getFreeMarkerEngine());

		// Suppression d'une ligne

		get("/supprimer", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			TypedQuery<Demo> query = entityManager.createQuery("from Demo", Demo.class);

			// System.out.println(query.getResultList());
			for (Demo i : query.getResultList()) {
				System.out.println(i.getNom());
			}
			attributes.put("objets", query.getResultList());

			return new ModelAndView(attributes, "supprimer.ftl");
		}, getFreeMarkerEngine());

		get("/resultat_supprimer", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			Demo demoUser = entityManager.find(Demo.class, Integer.parseInt(request.params(":id")));

			attributes.put("utilisateur", demoUser);

			entityManager.getTransaction().begin();
			entityManager.remove(demoUser);
			entityManager.getTransaction().commit();
			// entityManager.close();

			return new ModelAndView(attributes, "resultat_supprimer.ftl");

		}, getFreeMarkerEngine());
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////:		
//TP5 "Maires"
		
		
		get("/Maire", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Maire maire = new Maire();

			return new ModelAndView(attributes, "resultat_supprimer.ftl");

		}, getFreeMarkerEngine());
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

///////////////////////////////////////////////////////////////////////////////////////////////////////////// ::

// final Logger logger = LoggerFactory.getLogger(Router.class);
//
// get("/exemple1", (request, response) -> {
//
// logger.debug("start");
//
// Map<String, Object> attributes = new HashMap<>();
//
// // Exemple 1 (à déplacer dans une classe statique !):
// EntityManagerFactory entityManagerFactory =
// Persistence.createEntityManagerFactory("formation");
// EntityManager entityManager = entityManagerFactory.createEntityManager();
//
// // J'ajoute un métier :
// Demo metier = new Demo();
// metier.setNom("exemple1");
//
// entityManager.getTransaction().begin();
// entityManager.persist(metier);
// entityManager.getTransaction().commit();
//
// TypedQuery<Demo> query = entityManager.createQuery("from Demo", Demo.class);
// attributes.put("objets", query.getResultList());
//
// entityManager.close();
//
// return new ModelAndView(attributes, "home.ftl");
// }, getFreeMarkerEngine());
