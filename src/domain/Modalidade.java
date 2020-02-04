package domain;

import java.io.Serializable;
import java.util.Objects;

public class Modalidade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idModalidade;
	private String nome;
	
	public Modalidade() {}

	public Modalidade(String nome) {
		this.nome = nome;
	}

	public Modalidade(Long idModalidade, String nome) {
		this(nome);
		this.idModalidade = idModalidade;
	}

	public Long getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(Long idModalidade) {
		this.idModalidade = idModalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Modalidade)) return false;
		Modalidade that = (Modalidade) o;
		return Objects.equals(getIdModalidade(), that.getIdModalidade());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdModalidade());
	}

	@Override
	public String toString() {
		return "Modalidade{" +
				"idModalidade=" + idModalidade +
				", nome='" + nome + '\'' +
				'}';
	}
}
