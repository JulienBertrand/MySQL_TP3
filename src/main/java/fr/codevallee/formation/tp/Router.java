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

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// :
		// TP5 "Maires"

		get("/ajouter", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "ajouter.ftl");
		}, getFreeMarkerEngine());

		get("/resultat_ajouter", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String nomCommune = request.queryParams("nomcommune");
			String nomMaire = request.queryParams("nommaire");
			attributes.put("nomcommune", nomCommune);
			attributes.put("nommaire", nomMaire);
			// Maire maire = new Maire();
			// Maire maire2 = new Maire();
			// Maire maire3 = new Maire();
			// Maire maire4 = new Maire();
			// maire.setNom("Jean");
			// maire2.setNom("Jcques");
			// maire3.setNom("Paul");
			// maire4.setNom("Louis");

//			Elu elu = new Elu();
//			Elu elu2 = new Elu();
//			Elu elu3 = new Elu();
//			Elu elu4 = new Elu();
//			elu.setNom("Paul");
//			elu2.setNom("Kevin");
//			elu3.setNom("Luigi");
//			elu4.setNom("Han");

//			entityManager.getTransaction().begin();
//			// entityManager.persist(maire);
//			// entityManager.persist(maire2);
//			// entityManager.persist(maire3);
//			// entityManager.persist(maire4);
//			entityManager.persist(elu);
//			entityManager.persist(elu2);
//			entityManager.persist(elu3);
//			entityManager.persist(elu4);
//			entityManager.getTransaction().commit();

			
				Commune commune = new Commune();
				commune.setNom(nomCommune);

				Maire maire = new Maire();
				maire.setNom(nomMaire);

				maire.setCommune(commune);
				commune.setMaire(maire);
				entityManager.getTransaction().begin();
				entityManager.persist(maire);
				entityManager.persist(commune);
				entityManager.getTransaction().commit();

			
//			TypedQuery<Maire> query = entityManager.createQuery("from Maire", Maire.class);
//			query.getResultList();
//			attributes.put("objets", query.getResultList());
//			for (Maire m : query.getResultList()) {
//				System.out.println(m.getNom() + ";" + m.getCommune());
//			}

			return new ModelAndView(attributes, "/resultat_ajouter.ftl");

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
