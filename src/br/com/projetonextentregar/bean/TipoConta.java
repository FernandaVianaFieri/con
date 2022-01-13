	package br.com.projetonextentregar.bean;
	
	public enum TipoConta {
		
	POUPANCA, CORRENTE;
		
	 private int id;
		
		public void TipoConta(int id) {
			this.id = id;
		}
		public int getId() {
			return this.id;
	
		}
	}
