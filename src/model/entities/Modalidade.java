package model.entities;

import java.io.Serializable;

public class Modalidade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idModalidade;
	private String nome;
	
	public Modalidade() {}

	public Modalidade(Integer idModalidade, String nome) {
		this.idModalidade = idModalidade;
		this.nome = nome;
	}

	public Integer getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(Integer idModalidade) {
		this.idModalidade = idModalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idModalidade == null) ? 0 : idModalidade.hashCode());
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
		Modalidade other = (Modalidade) obj;
		if (idModalidade == null) {
			if (other.idModalidade != null)
				return false;
		} else if (!idModalidade.equals(other.idModalidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modalidade [idModalidade=" + idModalidade + ", nome=" + nome + "]";
	}
}
