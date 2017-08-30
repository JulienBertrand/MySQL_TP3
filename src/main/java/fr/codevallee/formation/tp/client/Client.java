package fr.codevallee.formation.tp.client;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")

public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nom;
	private String prenom;
	private int age;

	@ManyToOne // @OneToOne?
	private Adresse adresseDeFacturation;
	@ManyToOne // @OneToOne?
	private Adresse adresseDeLivraison;
	@OneToMany(mappedBy = "client")
	@Column(nullable = true)
	private Set<Facture> factures;

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param age
	 * @param adresseDeFacturation
	 * @param adresseDeLivraison
	 * @param factures
	 */
	public Client(String nom, String prenom, int age, Adresse adresseDeFacturation, Adresse adresseDeLivraison,
			Set<Facture> factures) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresseDeFacturation = adresseDeFacturation;
		this.adresseDeLivraison = adresseDeLivraison;
		this.factures = factures;
	}

	////////////////////////////////////////
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

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the adresseDeFacturation
	 */
	public Adresse getAdresseDeFacturation() {
		return adresseDeFacturation;
	}

	/**
	 * @param adresseDeFacturation
	 *            the adresseDeFacturation to set
	 */
	public void setAdresseDeFacturation(Adresse adresseDeFacturation) {
		this.adresseDeFacturation = adresseDeFacturation;
	}

	/**
	 * @return the adresseDeLivraison
	 */
	public Adresse getAdresseDeLivraison() {
		return adresseDeLivraison;
	}

	/**
	 * @param adresseDeLivraison
	 *            the adresseDeLivraison to set
	 */
	public void setAdresseDeLivraison(Adresse adresseDeLivraison) {
		this.adresseDeLivraison = adresseDeLivraison;
	}

	/**
	 * @return the factures
	 */
	public Set<Facture> getFactures() {
		return factures;
	}

	/**
	 * @param factures
	 *            the factures to set
	 */
	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}

}