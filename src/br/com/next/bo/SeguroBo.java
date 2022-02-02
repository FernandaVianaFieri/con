package br.com.next.bo;

import java.util.HashMap;
import java.util.UUID;

import br.com.next.bean.Seguro;
import br.com.next.bean.TipoSeguro;

public class SeguroBo {

	public HashMap<TipoSeguro, Seguro> popularSeguros() {
		
		// Seguro Morte
		HashMap<TipoSeguro, Seguro> retorno = new HashMap();
		Seguro seguroMorte = new Seguro();
		seguroMorte.setValor(36.00);
		seguroMorte.setNome("Morte");
		seguroMorte.setId(UUID.randomUUID().toString());
		String regrasMorte = "Indenização por despesas médico-hospitalares, ou por perda parcial ou total do funcionamento dos membros ou órgãos;"+
				"\nReembolso de custos em diagnóstico de doenças graves, como infarto, acidente vascular cerebral e câncer"+
				"\nAssistência funeral + para você e a sua família."+ "\nO valor do seguro individual é de R$36,00 ao ano.\n";
		seguroMorte.setRegras(regrasMorte);
		
        // seguro invalidez
		Seguro seguroInvalidez = new Seguro();
		seguroInvalidez.setValor(26.00);
		seguroInvalidez.setNome("Invalidez");
		seguroInvalidez.setId(UUID.randomUUID().toString());
		String regrasInvalidez = "Invalidez parcial: ocorre quando há uma perda parcial das funções. Por exemplo, uma pessoa que sofre um acidente e perda a visão em um só dos olhos." +
				"\nInvalidez total: ocorre quando há uma perda total das funções. Intuitivamente, um bom exemplo seria o caso onde a pessoa sofre um acidente e perde a visão em ambos os olhos." +
				"\nO valor do seguro individual é de R$26,00 ao ano.";
		seguroInvalidez.setRegras(regrasInvalidez);

		// seguro Desemprego
		Seguro seguroDesemprego = new Seguro();
		seguroDesemprego.setValor(16.00);
		seguroDesemprego.setNome("Desemprego");
		seguroDesemprego.setId(UUID.randomUUID().toString());
		String regrasDesemprego = "Necessário trabalhar com registro CLT, com o tempo mínimo de estabilidade de 12 meses."+
				"Válido apenas para desligamento involuntários e sem justa causa." + "Não é valido em caso de demissão em massa (10% ou mais de demissões simultâneas) ou falência/encerramento das atividades."
						+ "O valor do seguro individual é de R$16,00 ao ano.";
				
		seguroDesemprego.setRegras(regrasDesemprego);

		retorno.put(TipoSeguro.MORTE, seguroMorte);
		retorno.put(TipoSeguro.INVALIDEZ, seguroInvalidez);
		retorno.put(TipoSeguro.DESEMPREGO, seguroDesemprego);

		return retorno;

	}

}
