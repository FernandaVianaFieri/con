package br.com.projetonextentregar.bo;

import java.util.UUID;

import br.com.projetonextentregar.bean.Apolice;
import br.com.projetonextentregar.bean.Seguro;

public class ApoliceBo {
	// private String id;
//	private double valorApolice;
//	private String condicoes;
//	private Seguro seguro;

	public  static Apolice salvarApolice(Seguro seguro) {
		Apolice apolice = new Apolice();
		apolice.setId(UUID.randomUUID().toString());
		apolice.setValorApolice(seguro.getValor());
		apolice.setCondicoes("O valor só poderá ser recuperado se o prazo de carência (15 dias) for cumprido.");
		apolice.setSeguro(seguro);

		return apolice;
	}

}
