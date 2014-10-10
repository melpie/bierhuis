package be.vdab.valueobjects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BierAantal {

	@NotNull
	@Min(1)
	private Integer aantal;
	@Min(4)
	@Max(1542)
	private long bierId;
	
	public BierAantal() {}
	
	public BierAantal(int aantal, long bierId) {
		this.aantal = aantal;
		this.bierId = bierId;
	}

	public Integer getAantal() {
		return aantal;
	}

	public void setAantal(Integer aantal) {
		this.aantal = aantal;
	}

	public long getBierId() {
		return bierId;
	}

	public void setBierId(long bierId) {
		this.bierId = bierId;
	}
			
}
