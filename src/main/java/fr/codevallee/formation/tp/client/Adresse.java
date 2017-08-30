package fr.codevallee.formation.tp.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_Adresse;
	private int numeroDeRue;
	private String nomDeRue;
	private int codePostal;
	private String ville;
	
	
	
	public Adresse() {
		//super();
	}	

	
	/**
	 * @param numeroDeRue
	 * @param nomDeRue
	 * @param ville
	 */
	public Adresse(int numeroDeRue, String nomDeRue, int codePostal, String ville) {
		super();
		this.numeroDeRue = numeroDeRue;
		this.nomDeRue = nomDeRue;
		this.codePostal= codePostal;
		this.ville = ville;
	}


	/**
	 * @return the numeroDeRue
	 */
	public int getNumeroDeRue() {
		return numeroDeRue;
	}
	/**
	 * @param numeroDeRue the numeroDeRue to set
	 */
	public void setNumeroDeRue(int numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
	}
	/**
	 * @return the nomDeRue
	 */
	public String getNomDeRue() {
		return nomDeRue;
	}
	/**
	 * @param nomDeRue the nomDeRue to set
	 */
	public void setNomDeRue(String nomDeRue) {
		this.nomDeRue = nomDeRue;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}


	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

}
