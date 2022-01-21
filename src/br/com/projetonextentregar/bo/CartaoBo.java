package br.com.projetonextentregar.bo;

import br.com.projetonextentregar.bean.Cliente;

public class CartaoBo {

	public double retornaLimite(Cliente cliente) {
		// COMUM, SUPER, PREMIUM;
		if (cliente.getTipocliente().name().equals("COMUM")) {
			return 1000.0;
		}
		else if (cliente.getTipocliente().name().equals("SUPER")) {
			return 2000.0;
		}
		else if (cliente.getTipocliente().name().equals("PREMIUM")) {
			return 3000.0;
			
		}
		
		return 1000.0;
	}

}
