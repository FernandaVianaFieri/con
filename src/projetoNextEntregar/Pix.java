package projetoNextEntregar;

public class Pix {

	int id;
	TipoChavePix tipoChave;	
	private String chave;
	private boolean ativo;
	public int getId() {
		return id;
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
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}