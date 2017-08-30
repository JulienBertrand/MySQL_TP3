package fr.codevallee.formation.tp.client;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.codevallee.formation.tp.Statut;

@Entity
@Table(name = "Facture")
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_Factures;
	@ManyToOne
	private Client client;
	@OneToMany 
	private Set<LigneDeFacture> ligneDeFactures;

	private Date date;

	private Statut statut; 

	double totalFacture() {
		double total = 0;
		for (LigneDeFacture ligneDeFacture : ligneDeFactures) {
			total = total + ligneDeFacture.totalLigneFacture();
		}
		return total;

	}

	// rajouter l'adresse de livraison??

	/**
	 * 
	 */
	public Facture() {
		super();
	}

	/**
	 * @param client
	 * @param ligneDeFactures
	 * @param date
	 * @param statut
	 */
	public Facture(Client client, Set<LigneDeFacture> ligneDeFactures, Date date, Statut statut) {
		super();
		this.client = client;
		this.ligneDeFactures = ligneDeFactures;
		this.date = Calendar.getInstance().getTime();
		this.statut = statut;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the ligneDeFactures
	 */
	public Set<LigneDeFacture> getLigneDeFactures() {
		return ligneDeFactures;
	}

	/**
	 * @param ligneDeFactures
	 *            the ligneDeFactures to set
	 */
	public void setLigneDeFactures(Set<LigneDeFacture> ligneDeFactures) {
		this.ligneDeFactures = ligneDeFactures;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = Calendar.getInstance().getTime();
	}

	/**
	 * @return the statut
	 */
	public Statut getStatut() {
		return statut;
	}

	/**
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	/**
	 * @return the total
	 */

}
