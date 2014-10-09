package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="bieren")
public class Bier implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	@NotBlank
	private String naam;
	@NotNull
	@Min(0)
	@Digits(integer = 2, fraction = 2)
	private BigDecimal alcohol;
	@NotNull
	@Min(0)
	@Digits(integer = 3, fraction = 2)
	private BigDecimal prijs;
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "brouwerid")
	private Brouwer brouwer;
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "soortid")
	private Soort soort;
	@OneToMany(mappedBy="key.bier", fetch = FetchType.EAGER)
	@OrderBy("bestelbonId")
	private Set<BestelBonLijn> bestelBonLijnen;

	protected Bier() {
	}

	public Bier(String naam, BigDecimal alcohol, BigDecimal prijs) {
		this.naam = naam;
		this.alcohol = alcohol;
		this.prijs = prijs;
		bestelBonLijnen = new LinkedHashSet<BestelBonLijn>();
	}
	
	public Bier(String naam, BigDecimal alcohol, BigDecimal prijs, Set<BestelBonLijn> bestelBonLijnen) {
		this.naam = naam;
		this.alcohol = alcohol;
		this.prijs = prijs;
		for (BestelBonLijn b : bestelBonLijnen) { 
			addBestelBonLijn(b);
		}
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public BigDecimal getAlcohol() {
		return alcohol;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setAlcohol(BigDecimal alcohol) {
		this.alcohol = alcohol;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
		
	public Brouwer getBrouwer() {
		return brouwer;
	}

	public void setBrouwer(Brouwer brouwer) {
		if (this.brouwer != null && this.brouwer.getBieren().contains(this)) {
			this.brouwer.removeBier(this);
		}
		this.brouwer = brouwer;
		if (brouwer != null && ! brouwer.getBieren().contains(this)) {
			brouwer.addBier(this);
		}
	}
	
	public Soort getSoort() {
		return soort;
	}

	public void setSoort(Soort soort) {
		if (this.soort != null && this.soort.getBieren().contains(this)) {
			this.soort.removeBier(this);
		}
		this.soort = soort;
		if (soort != null && ! soort.getBieren().contains(this)) {
			soort.addBier(this);
		}
	}
	
	public Set<BestelBonLijn> getBestelBonLijnen() {
		return Collections.unmodifiableSet(bestelBonLijnen);
	}
	
	public void addBestelBonLijn(BestelBonLijn bestelBonLijn) {
		bestelBonLijnen.add(bestelBonLijn);
		if (bestelBonLijn.getBier() != this) {
			bestelBonLijn.setBier(this);
		}
	}
	
	public void removeBestelBonLijn(BestelBonLijn bestelBonLijn) {
		bestelBonLijnen.remove(bestelBonLijn);
		if (bestelBonLijn.getBier() == this) {
			bestelBonLijn.setBier(null);
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
		Bier other = (Bier) obj;
		if (id != other.id)
			return false;
		return true;
	}	
	
}
