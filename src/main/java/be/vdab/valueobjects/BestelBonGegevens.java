package be.vdab.valueobjects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import be.vdab.constraints.Postcode;

public class BestelBonGegevens {

	@NotBlank
	private String naam;
	@NotBlank
	private String straat;
	@NotBlank
	private String huisnummer;
	@NotNull
	@Postcode
	private Integer postcode;
	@NotBlank
	private String gemeente;
	
	public BestelBonGegevens(){}

	public BestelBonGegevens(String naam, String straat, String huisnummer, Integer postcode, String gemeente) {
		this.naam = naam;
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.postcode = postcode;
		this.gemeente = gemeente;
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

	public String getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(String huisnummer) {
		this.huisnummer = huisnummer;
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
		
}
