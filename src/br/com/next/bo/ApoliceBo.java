package br.com.next.bo;

import java.util.Date;
import java.util.UUID;

import br.com.next.bean.Apolice;
import br.com.next.bean.Seguro;

public class ApoliceBo {
	// private String id;
//	private double valorApolice;
//	private String condicoes;
//	private Seguro seguro;

	public  static Apolice salvarApolice(Seguro seguro) {
		Date dataAtual = new Date();
		Date dataCarencia = new Date ();
		dataCarencia.setDate(dataCarencia.getDate()+15);
		Apolice apolice = new Apolice();
		apolice.setId(UUID.randomUUID().toString());
		apolice.setValorApolice(seguro.getValor());
		apolice.setCondicoes("O valor só poderá ser recuperado se o prazo de carência (15 dias) for cumprido.");
		apolice.setSeguro(seguro);
		apolice.setDataAssinatura(dataAtual);
		apolice.setDataCarencia(dataCarencia);
		
		return apolice;
	}

}

