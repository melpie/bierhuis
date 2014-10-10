package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import be.vdab.entities.BestelBon;
import be.vdab.entities.Bier;

@Embeddable
public class BestelBonLijnPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name = "bestelbonid")
	private BestelBon bestelBon;
	
	@ManyToOne(fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name = "bierid")
	private Bier bier;
	
	public BestelBonLijnPK() {
		
	}

	public BestelBonLijnPK(BestelBon bestelBon, Bier bier) {
		this.bestelBon = bestelBon;
		this.bier = bier;
	}

	public BestelBon getBestelBon() {
		return bestelBon;
	}

	public void setBestelBon(BestelBon bestelBon) {
		this.bestelBon = bestelBon;
	}

	public Bier getBier() {
		return bier;
	}

	public void setBier(Bier bier) {
		this.bier = bier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bestelBon == null) ? 0 : bestelBon.hashCode());
		result = prime * result + ((bier == null) ? 0 : bier.hashCode());
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
		BestelBonLijnPK other = (BestelBonLijnPK) obj;
		if (bestelBon == null) {
			if (other.bestelBon != null)
				return false;
		} else if (!bestelBon.equals(other.bestelBon))
			return false;
		if (bier == null) {
			if (other.bier != null)
				return false;
		} else if (!bier.equals(other.bier))
			return false;
		return true;
	}
			
}
