package com.jailux.limitsservice.bean;

public class Limite {
	private int minimo;
	private int maximo;
	
	protected Limite() {
		super();
	}

	public Limite(int minimo, int maximo) {
		super();
		this.minimo = minimo;
		this.maximo = maximo;
	}
	
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	
}
