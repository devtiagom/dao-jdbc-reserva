package domain;

import java.io.Serializable;
import java.util.Objects;

public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idPais;
    private String nomePais;

    public Pais() {}

    public Pais(String nomePais) {
        this.nomePais = nomePais;
    }

    public Pais(Long idPais, String nomePais) {
        this(nomePais);
        this.idPais = idPais;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais)) return false;
        Pais pais = (Pais) o;
        return Objects.equals(getIdPais(), pais.getIdPais());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPais());
    }

    @Override
    public String toString() {
        return "Pais{" +
                "idPais=" + idPais +
                ", nomePais='" + nomePais + '\'' +
                '}';
    }
}
