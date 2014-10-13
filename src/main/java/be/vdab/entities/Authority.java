package be.vdab.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import be.vdab.valueobjects.AuthorityPK;

@Entity
@Table(name="authorities")
public class Authority {
	
	@EmbeddedId
	AuthorityPK key;
	
	public Authority() {
	}

	public Authority(AuthorityPK key) {
		this.key = key;
	}

	public String getAuthority() {
		return key.getAuthority();
	}

	public void setAuthority(String authority) {
		this.key.setAuthority(authority);
	}

	public User getUser() {
		return key.getUser();
	}

	public void setUser(User user) {
		this.key.setUser(user);
	}
	
}
