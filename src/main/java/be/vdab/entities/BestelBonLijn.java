package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import be.vdab.valueobjects.BestelBonLijnPK;

@Entity
@Table(name = "bestelbonlijnen")
public class BestelBonLijn implements Serializable {
	private static final long serialVersionUID = 1L;
	int aantal;
		
	@EmbeddedId
	BestelBonLijnPK key;
		
	protected BestelBonLijn() {}
	
	public BestelBonLijn(int aantal, BestelBonLijnPK key) {
		setAantal(aantal);
		this.key = key;	
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public BestelBon getBestelBon() {
		return key.getBestelBon();
	}

	public void setBestelBon(BestelBon bestelBon) {
		this.key.setBestelBon(bestelBon);
	}

	public Bier getBier() {
		return key.getBier();
	}

	public void setBier(Bier bier) {
		this.key.setBier(bier);
	}
	
}
