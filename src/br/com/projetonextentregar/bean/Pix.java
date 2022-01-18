package br.com.projetonextentregar.bean;

import java.util.Date;

public class Pix {

	int id;
	TipoChavePix tipoChave;		
	private String conteudoChave;
		private boolean ativo;
	private Date dataCadastro;
	public int getId() {
		return id;
		
				
	}
	
	public boolean ativarChave(TipoChavePix tipoChave, String conteudoChave, boolean isAtivado) {
		this.tipoChave = tipoChave;
		this.conteudoChave = conteudoChave;
		this.ativo = isAtivado;
		return true;
		}
	public void setId(int id) {
		this.id = id;
	}
	public TipoChavePix getTipoChave() {
		return tipoChave;
	}
	public void setTipoChave(TipoChavePix tipoChave) {
		this.tipoChave = tipoChave;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getConteudoChave() {
		return conteudoChave;
	}
	public void setConteudoChave(String conteudoChave) {
		this.conteudoChave = conteudoChave;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	

}