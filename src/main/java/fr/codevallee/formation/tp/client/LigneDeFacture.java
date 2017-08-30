package fr.codevallee.formation.tp.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name = "ligne de Facture")
public class LigneDeFacture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_Ligne;
	
	@OneToOne
	private Article article;
	private int nombreArticle;
	//private Facture facture;

	double totalLigneFacture() {
		return nombreArticle * article.getPrixArticle();
	}

	/**
	 * 
	 */
	public LigneDeFacture() {
		// super();
	}

	/**
	 * @param article
	 * @param nombreArticle
	 * @param facture
	 */
	public LigneDeFacture(Article article, int nombreArticle) { //Facture facture) {
		super();
		this.article = article;
		this.nombreArticle = nombreArticle;
		//this.facture = facture;
	}

	//////////////////////////////////////////////////////////////////
	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article
	 *            the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * @return the nombreArticle
	 */
	public int getNombreArticle() {
		return nombreArticle;
	}

	/**
	 * @param nombre
	 *            the nombreArticle to set
	 */
	public void setNombreArticle(int nombre) {
		this.nombreArticle = nombre;
	}

	/**
	 * @return the facture
	 */
//	public Facture getFacture() {
//		return facture;
//	}
//
//	/**
//	 * @param facture the facture to set
//	 */
//	public void setFacture(Facture facture) {
//		this.facture = facture;
//	}

}
