package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "soorten")
public class Soort implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	@NotBlank
	private String naam;
	@OneToMany(mappedBy="soort")
	@OrderBy("naam")
	private Set<Bier> bieren;
	
	public Soort() {
	}
	
	public Soort(String naam) {
		this.naam = naam;
	}
	
	public Soort(long id, String naam) {
		this(naam);
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
	
	public Set<Bier> getBieren() {
		return Collections.unmodifiableSet(bieren);
	}
	
	public void addBier(Bier bier) {
		bieren.add(bier);
		if (bier.getSoort() != this) {
			bier.setSoort(this);
		}
	}
	
	public void removeBier(Bier bier) {
		bieren.remove(bier);
		if (bier.getSoort() == this) {
			bier.setSoort(null);
		}
	}
	
}
