package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Viajante implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idViajante;
	private String nomeViajante;
	private String documentoViajante;
	private Date dataNascimento;
	
	public Viajante() {}

	public Viajante(String nomeViajante, String documentoViajante, Date dataNascimento) {
		this.nomeViajante = nomeViajante;
		this.documentoViajante = documentoViajante;
		this.dataNascimento = dataNascimento;
	}

	public Viajante(Long idViajante, String nomeViajante, String documentoViajante, Date dataNascimento) {
		this(nomeViajante, documentoViajante, dataNascimento);
		this.idViajante = idViajante;
	}

	public Long getIdViajante() {
		return idViajante;
	}

	public void setIdViajante(Long idViajante) {
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Viajante)) return false;
		Viajante viajante = (Viajante) o;
		return Objects.equals(getIdViajante(), viajante.getIdViajante());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdViajante());
	}

	@Override
	public String toString() {
		return "Viajante{" +
				"idViajante=" + idViajante +
				", nomeViajante='" + nomeViajante + '\'' +
				", documentoViajante='" + documentoViajante + '\'' +
				", dataNascimento=" + dataNascimento +
				'}';
	}
}
