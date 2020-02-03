package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Viajante implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idViajante;
	private String nomeViajante;
	private String documentoViajante;
	private Date dataNascimento;
	
	public Viajante() {}

	public Viajante(Integer idViajante, String nomeViajante, String documentoViajante, Date dataNascimento) {
		this.idViajante = idViajante;
		this.nomeViajante = nomeViajante;
		this.documentoViajante = documentoViajante;
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdViajante() {
		return idViajante;
	}

	public void setIdViajante(Integer idViajante) {
		this.idViajante = idViajante;
	}

	public String getNomeViajante() {
		return nomeViajante;
	}

	public void setNomeViajante(String nomeViajante) {
		this.nomeViajante = nomeViajante;
	}

	public String getDocumentoViajante() {
		return documentoViajante;
	}

	public void setDocumentoViajante(String documentoViajante) {
		this.documentoViajante = documentoViajante;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idViajante == null) ? 0 : idViajante.hashCode());
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
		Viajante other = (Viajante) obj;
		if (idViajante == null) {
			if (other.idViajante != null)
				return false;
		} else if (!idViajante.equals(other.idViajante))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Viajante [idViajante=" + idViajante + ", nomeViajante=" + nomeViajante + ", documentoViajante="
				+ documentoViajante + ", dataNascimento=" + dataNascimento + "]";
	}
}
