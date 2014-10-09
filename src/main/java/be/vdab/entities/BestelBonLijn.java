package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "bestelbonlijnen")
//@IdClass(BestelBonLijnPK.class)
public class BestelBonLijn implements Serializable {
	private static final long serialVersionUID = 1L;
	int aantal;
	
//	@Id
//	@ManyToOne(fetch = FetchType.LAZY,optional=false)
//	@JoinColumn(name = "bestelbonid")
//	private BestelBon bestelBon;
//	
//	@Id
//	@ManyToOne(fetch = FetchType.LAZY,optional=false)
//	@JoinColumn(name = "bierid")
//	private Bier bier;
	
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
