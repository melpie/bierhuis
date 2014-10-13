package be.vdab.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import be.vdab.constraints.Postcode;

@Entity
@Table(name = "users")
public class User {

	@Id
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	private int enabled;
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
	@OneToMany(mappedBy="key.user")
	private Set<Authority> authorities;
	
	public User(){}

	public User(String username, String password, String naam, String straat, String huisnummer, Integer postcode, String gemeente) {
		this.username = username;
		this.password = password;
		this.enabled = 1;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
			
}
