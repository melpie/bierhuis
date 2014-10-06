package be.vdab.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="bieren")
public class Bier {
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "brouwerid")
	private Brouwer brouwer;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "soortid")
	private Soort soort;

	public Bier() {
	}

	public Bier(String naam, BigDecimal alcohol, BigDecimal prijs) {
		this.naam = naam;
		this.alcohol = alcohol;
		this.prijs = prijs;
	}
	
	public Bier(long id, String naam, BigDecimal alcohol, BigDecimal prijs) {
		this(naam,alcohol,prijs);
		this.id = id;
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

}
