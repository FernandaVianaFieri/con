package br.com.next.bo;

import java.util.*;

import br.com.next.bean.Compra;
import br.com.next.bean.Conta;

public class CartaoCredBo {
	
	
	
	public boolean compraCredito (double valorCompra, Conta conta) {
    double limite = conta.getCartaoCredito().getLimite();
    double fatura = conta.getCartaoCredito().getValorFatura();
    
    if (limite >= valorCompra) {
    	limite -= valorCompra;
    	conta.getCartaoCredito().setLimite(limite);
    	fatura+= valorCompra;
    	conta.getCartaoCredito().setValorFatura(fatura);
    	adicionaCompra (valorCompra, conta);
    	return true;
    }
    else {
    	return false;
    }
    }
    
    public void adicionaCompra (double valorCompra, Conta conta) {
    	Compra compra = new Compra( valorCompra, new Date());
    	conta.getCartaoCredito().getListCompra().add(compra);
    	
    }
}


