package be.vdab.web;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import be.vdab.entities.Bier;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class WinkelwagenImpl implements Winkelwagen, Serializable {
	private static final long serialVersionUID = 1L;
	private Map<Bier, Integer> bierenInMandje;

	public WinkelwagenImpl() {
		bierenInMandje = new LinkedHashMap<Bier,Integer>();
	}

	public Map<Bier, Integer> getBierenInMandje() {
		return bierenInMandje;
	}
	
	public void addBier(Bier bier, int aantal) {
		bierenInMandje.put(bier, aantal);
	}	
	
	public void removeBieren() {
		bierenInMandje.clear();
	}
	
}
