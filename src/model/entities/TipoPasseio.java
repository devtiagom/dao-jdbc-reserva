package model.entities;

import java.io.Serializable;

public class TipoPasseio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idTipoPasseio;
	private String nomePasseio;
	private String descricaoPasseio;
	
	public TipoPasseio() {}

	public TipoPasseio(Integer idTipoPasseio, String nomePasseio, String descricaoPasseio) {
		this.idTipoPasseio = idTipoPasseio;
		this.nomePasseio = nomePasseio;
		this.descricaoPasseio = descricaoPasseio;
	}

	public Integer getIdTipoPasseio() {
		return idTipoPasseio;
	}

	public void setIdTipoPasseio(Integer idTipoPasseio) {
		this.idTipoPasseio = idTipoPasseio;
	}

	public String getNomePasseio() {
		return nomePasseio;
	}

	public void setNomePasseio(String nomePasseio) {
		this.nomePasseio = nomePasseio;
	}

	public String getDescricaoPasseio() {
		return descricaoPasseio;
	}

	public void setDescricaoPasseio(String descricaoPasseio) {
		this.descricaoPasseio = descricaoPasseio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoPasseio == null) ? 0 : idTipoPasseio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPasseio other = (TipoPasseio) obj;
		if (idTipoPasseio == null) {
			if (other.idTipoPasseio != null)
				return false;
		} else if (!idTipoPasseio.equals(other.idTipoPasseio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoPasseio [idTipoPasseio=" + idTipoPasseio + ", nomePasseio=" + nomePasseio + ", descricaoPasseio="
				+ descricaoPasseio + "]";
	}
}
