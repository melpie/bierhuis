package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import be.vdab.constraints.Postcode;

@Entity
@Table(name = "bestelbonnen")
public class BestelBon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String naam;
	private String straat;
	private String huisNr;
	@NotNull
	@Postcode
	private Integer postcode;
	private String gemeente;
	@OneToMany(mappedBy="bestelBon", fetch = FetchType.EAGER)
	@OrderBy("bierId")
	private Set<BestelBonLijn> bestelBonLijnen;
	
	protected BestelBon() {}
	
	public BestelBon(String naam, String straat, String huisNr, Integer postCode, String gemeente, Set<BestelBonLijn> bestelBonLijnen) {
		setNaam(naam);
		setStraat(straat);
		setHuisNr(huisNr);
		setPostcode(postCode);
		setGemeente(gemeente);
		for (BestelBonLijn b : bestelBonLijnen) { 
			addBestelBonLijn(b);
		}
	}
	
	public BestelBon(String naam, String straat, String huisNr, Integer postCode, String gemeente) {
		setNaam(naam);
		setStraat(straat);
		setHuisNr(huisNr);
		setPostcode(postCode);
		setGemeente(gemeente);
		bestelBonLijnen = new LinkedHashSet<BestelBonLijn>();
	}
	
	
	public long getId() {
		return id;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public String getStraat() {
		return straat;
	}
	
	public void setStraat(String straat) {
		this.straat = straat;
	}
	
	public String getHuisNr() {
		return huisNr;
	}
	
	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}
	
	public Integer getPostcode() {
		return postcode;
	}
	
	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}
	
	public String getGemeente() {
		return gemeente;
	}
	
	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
		
	public Set<BestelBonLijn> getBestelBonLijnen() {
		return Collections.unmodifiableSet(bestelBonLijnen);
	}
	
	public void addBestelBonLijn(BestelBonLijn bestelBonLijn) {
		bestelBonLijnen.add(bestelBonLijn);
		if (bestelBonLijn.getBestelBon() != this) {
			bestelBonLijn.setBestelBon(this);
		}
	}
	
	public void removeBestelBonLijn(BestelBonLijn bestelBonLijn) {
		bestelBonLijnen.remove(bestelBonLijn);
		if (bestelBonLijn.getBestelBon() == this) {
			bestelBonLijn.setBestelBon(null);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BestelBon other = (BestelBon) obj;
		if (id != other.id)
			return false;
		return true;
	}	

}
