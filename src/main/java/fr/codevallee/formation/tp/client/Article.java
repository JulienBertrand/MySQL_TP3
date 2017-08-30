package fr.codevallee.formation.tp.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_Article;
	private double prixArticle;
	@OneToOne //@ManyToOne?
	private ArticleDescription articleDescription;
	private String refArticle;

	/**
	 * 
	 */
	public Article() {
		// super();
	}

	/**
	 * @param prixArticle
	 * @param articleDescription
	 * @param refArticle
	 */
	public Article(double prixArticle, ArticleDescription articleDescription, String refArticle) {
		super();
		this.prixArticle = prixArticle;
		this.articleDescription = articleDescription;
		this.refArticle = refArticle;
	}

	////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * @return the prixArticle
	 */
	public double getPrixArticle() {
		return prixArticle;
	}

	/**
	 * @param prixArticle
	 *            the prixArticle to set
	 */
	public void setPrixArticle(double prixArticle) {
		this.prixArticle = prixArticle;
	}

	/**
	 * @return the articleDescription
	 */
	public ArticleDescription getArticleDescription() {
		return articleDescription;
	}

	/**
	 * @param articleDescription
	 *            the articleDescription to set
	 */
	public void setArticleDescription(ArticleDescription articleDescription) {
		this.articleDescription = articleDescription;
	}

	/**
	 * @return the refArticle
	 */
	public String getRefArticle() {
		return refArticle;
	}

	/**
	 * @param refArticle
	 *            the refArticle to set
	 */
	public void setRefArticle(String refArticle) {
		this.refArticle = refArticle;
	}

}
