package fr.codevallee.formation.tp;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

public class Router implements SparkApplication {

	public void init() {
		
		get("/modifier.modis", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "modifier.ftl");
		}, getFreeMarkerEngine());
		
		get("/ajouter.modis", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "modifier.ftl");
		}, getFreeMarkerEngine());
		
		get("/modifier.modis", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "modifier.ftl");
		}, getFreeMarkerEngine());
		
		
		
		
		

		get("/resultat.modis", (request, response) -> {
			String nom = request.queryParams("nom");
			String prenom = request.queryParams("prenom");
			String civilite = request.queryParams("civilite");
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("nom", nom);
			attributes.put("prenom", prenom);
			attributes.put("civilite", civilite);
			return new ModelAndView(attributes, "resultat.ftl");
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


/////////////////////////////////////////////////////////////////////////////////////////////////////////////::


//final Logger logger = LoggerFactory.getLogger(Router.class);
//
//get("/exemple1", (request, response) -> {
//
//	logger.debug("start");
//
//	Map<String, Object> attributes = new HashMap<>();
//
//	// Exemple 1 (à déplacer dans une classe statique !):
//	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
//	EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//	// J'ajoute un métier :
//	Demo metier = new Demo();
//	metier.setNom("exemple1");
//
//	entityManager.getTransaction().begin();
//	entityManager.persist(metier);
//	entityManager.getTransaction().commit();
//
//	TypedQuery<Demo> query = entityManager.createQuery("from Demo", Demo.class);
//	attributes.put("objets", query.getResultList());
//
//	entityManager.close();
//
//	return new ModelAndView(attributes, "home.ftl");
//}, getFreeMarkerEngine());
