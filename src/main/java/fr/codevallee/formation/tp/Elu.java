package fr.codevallee.formation.tp;

import java.util.Set;

import javax.persistence.*;


@Entity
public class Elu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50)
	private String nom;

	@ManyToMany
	private Set<Projet> projets;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
