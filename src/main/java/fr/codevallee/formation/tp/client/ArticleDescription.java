package fr.codevallee.formation.tp.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ArticleDescription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_ArticleDesc;
	

	private String descriptionTexte;

	/**
	 * 
	 */
	public ArticleDescription() {
		// super();
	}

	/**
	 * @param descriptionTexte
	 */
	public ArticleDescription(String descriptionTexte) {
		// super();
		this.descriptionTexte = descriptionTexte;
	}

	/**
	 * @return the descriptionTexte
	 */
	public String getDescriptionTexte() {
		return descriptionTexte;
	}

	/**
	 * @param descriptionTexte
	 *            the descriptionTexte to set
	 */
	public void setDescriptionTexte(String descriptionTexte) {
		this.descriptionTexte = descriptionTexte;
	}

	/**
	 * @return
	 * @see java.lang.String#toString()
	 */
	public String toString() {
		return descriptionTexte.toString();
	}

	
}
