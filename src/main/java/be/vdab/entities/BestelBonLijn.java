package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import be.vdab.entities.BestelBon;

@Entity
@Table(name = "bestelbonlijnen")
@IdClass(BestelBonLijnPK.class)
public class BestelBonLijn implements Serializable {
	private static final long serialVersionUID = 1L;
	int aantal;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name = "bestelbonid")
	private BestelBon bestelBon;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name = "bierid")
	private Bier bier;
		
	protected BestelBonLijn() {}
	
	public BestelBonLijn(int aantal, Bier bier, BestelBon bestelBon) {
		setAantal(aantal);
		setBestelBon(bestelBon);
		setBier(bier);		
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public BestelBon getBestelBon() {
		return bestelBon;
	}

	public void setBestelBon(BestelBon bestelBon) {
		if (this.bestelBon != null && this.bestelBon.getBestelBonLijnen().contains(this)) {
			this.bestelBon.removeBestelBonLijn(this);
		}
		this.bestelBon = bestelBon;
		if (bestelBon != null && ! bestelBon.getBestelBonLijnen().contains(this)) {
			bestelBon.addBestelBonLijn(this);
		}
	}

	public Bier getBier() {
		return bier;
	}

	public void setBier(Bier bier) {
		if (this.bier != null && this.bier.getBestelBonLijnen().contains(this)) {
			this.bier.removeBestelBonLijn(this);
		}
		this.bier = bier;
		if (bier != null && ! bier.getBestelBonLijnen().contains(this)) {
			bier.addBestelBonLijn(this);
		}
	}
	
}
