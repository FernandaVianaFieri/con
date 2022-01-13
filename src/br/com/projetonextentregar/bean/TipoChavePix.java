package br.com.projetonextentregar.bean;

public enum TipoChavePix {
	
	CPF, EMAIL, TELEFONE, ALEATORIO;

	
	private int id;
	
	public void TipoChavePix(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
}

