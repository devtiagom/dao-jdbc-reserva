package domain;

import java.io.Serializable;
import java.util.Objects;

public class TipoPasseio implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idTipoPasseio;
	private String nomePasseio;
	private String descricaoPasseio;
	
	public TipoPasseio() {}

	public TipoPasseio(String nomePasseio, String descricaoPasseio) {
		this.nomePasseio = nomePasseio;
		this.descricaoPasseio = descricaoPasseio;
	}

	public TipoPasseio(Long idTipoPasseio, String nomePasseio, String descricaoPasseio) {
		this(nomePasseio, descricaoPasseio);
		this.idTipoPasseio = idTipoPasseio;
	}

	public Long getIdTipoPasseio() {
		return idTipoPasseio;
	}

	public void setIdTipoPasseio(Long idTipoPasseio) {
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TipoPasseio)) return false;
		TipoPasseio that = (TipoPasseio) o;
		return Objects.equals(getIdTipoPasseio(), that.getIdTipoPasseio());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdTipoPasseio());
	}

	@Override
	public String toString() {
		return "TipoPasseio{" +
				"idTipoPasseio=" + idTipoPasseio +
				", nomePasseio='" + nomePasseio + '\'' +
				", descricaoPasseio='" + descricaoPasseio + '\'' +
				'}';
	}
}
