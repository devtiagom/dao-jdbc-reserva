package domain;

import java.io.Serializable;
import java.util.Objects;

public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idEstado;
    private String nomeEstado;
    private Pais pais;

    public Estado() {}

    public Estado(String nomeEstado, Pais pais) {
        this.nomeEstado = nomeEstado;
        this.pais = pais;
    }

    public Estado(Long idEstado, String nomeEstado, Pais pais) {
        this(nomeEstado, pais);
        this.idEstado = idEstado;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado)) return false;
        Estado estado = (Estado) o;
        return Objects.equals(getIdEstado(), estado.getIdEstado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEstado());
    }

    @Override
    public String toString() {
        return "Estado{" +
                "idEstado=" + idEstado +
                ", nomeEstado='" + nomeEstado + '\'' +
                ", pais=" + pais +
                '}';
    }
}
