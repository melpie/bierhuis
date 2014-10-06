package be.vdab.entities;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import be.vdab.constraints.Postcode;

@Entity
@Table(name = "brouwers")
public class Brouwer {
	@Id
	@GeneratedValue
	private long id;
	@NotBlank
	private String naam;
	@NotBlank
	private String straat;
	@NotBlank
	private String huisNr;
	@NotNull
	@Postcode
	private Integer postcode;
	@NotBlank
	private String gemeente;
	@NotNull
	@Min(0)
	@Digits(integer = 10, fraction = 0)
	private BigDecimal omzet;
	@OneToMany(mappedBy="brouwer")
	@OrderBy("naam")
	private Set<Bier> bieren;

	public Brouwer() {
	}

	public Brouwer(String naam, String straat, String huisNr, Integer postcode, String gemeente, BigDecimal omzet) {
		this.naam = naam;
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
		this.omzet = omzet;
	}

	public Brouwer(long id, String naam, String straat, String huisNr, Integer postcode, String gemeente, BigDecimal omzet) {
		this(naam, straat, huisNr, postcode, gemeente, omzet);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BigDecimal getOmzet() {
		return omzet;
	}

	public void setOmzet(BigDecimal omzet) {
		this.omzet = omzet;
	}
	
	public Set<Bier> getBieren() {
		return Collections.unmodifiableSet(bieren);
	}
	
	public void addBier(Bier bier) {
		bieren.add(bier);
		if (bier.getBrouwer() != this) {
			bier.setBrouwer(this);
		}
	}
	
	public void removeBier(Bier bier) {
		bieren.remove(bier);
		if (bier.getBrouwer() == this) {
			bier.setBrouwer(null);
		}
	}
	
}
