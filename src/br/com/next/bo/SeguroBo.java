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
		String regrasMorte = "Indeniza��o por despesas m�dico-hospitalares, ou por perda parcial ou total do funcionamento dos membros ou �rg�os;"+
				"\nReembolso de custos em diagn�stico de doen�as graves, como infarto, acidente vascular cerebral e c�ncer"+
				"\nAssist�ncia funeral + para voc� e a sua fam�lia."+ "\nO valor do seguro individual � de R$36,00 ao ano.\n";
		seguroMorte.setRegras(regrasMorte);
		
        // seguro invalidez
		Seguro seguroInvalidez = new Seguro();
		seguroInvalidez.setValor(26.00);
		seguroInvalidez.setNome("Invalidez");
		seguroInvalidez.setId(UUID.randomUUID().toString());
		String regrasInvalidez = "Invalidez parcial: ocorre quando h� uma perda parcial das fun��es. Por exemplo, uma pessoa que sofre um acidente e perda a vis�o em um s� dos olhos." +
				"\nInvalidez total: ocorre quando h� uma perda total das fun��es. Intuitivamente, um bom exemplo seria o caso onde a pessoa sofre um acidente e perde a vis�o em ambos os olhos." +
				"\nO valor do seguro individual � de R$26,00 ao ano.";
		seguroInvalidez.setRegras(regrasInvalidez);

		// seguro Desemprego
		Seguro seguroDesemprego = new Seguro();
		seguroDesemprego.setValor(16.00);
		seguroDesemprego.setNome("Desemprego");
		seguroDesemprego.setId(UUID.randomUUID().toString());
		String regrasDesemprego = "Necess�rio trabalhar com registro CLT, com o tempo m�nimo de estabilidade de 12 meses."+
				"V�lido apenas para desligamento involunt�rios e sem justa causa." + "N�o � valido em caso de demiss�o em massa (10% ou mais de demiss�es simult�neas) ou fal�ncia/encerramento das atividades."
						+ "O valor do seguro individual � de R$16,00 ao ano.";
				
		seguroDesemprego.setRegras(regrasDesemprego);

		retorno.put(TipoSeguro.MORTE, seguroMorte);
		retorno.put(TipoSeguro.INVALIDEZ, seguroInvalidez);
		retorno.put(TipoSeguro.DESEMPREGO, seguroDesemprego);

		return retorno;

	}

}
