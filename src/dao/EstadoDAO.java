package dao;

import db.DbException;
import db.DbIntegrityException;
import db.JDBCConnection;
import domain.Estado;
import domain.Pais;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstadoDAO implements DAO<Estado> {

    private Connection conn;

    public EstadoDAO(Connection conn) { this.conn = conn; }

    @Override
    public void save(Estado domain) {
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "INSERT INTO estado (nome_estado, id_pais) VALUES (?, ?)";

        try {
            st = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, domain.getNomeEstado());
            st.setLong(2, domain.getPais().getIdPais());

            int rowsAffected =  st.executeUpdate();
            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) domain.setIdEstado(rs.getLong(1));
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeResultSet(rs);
            JDBCConnection.closeStatement(st);
        }
    }

    @Override
    public Estado saveAndCheck(Estado domain) {
        this.save(domain);
        return this.findById(domain.getIdEstado());
    }

    @Override
    public void update(Estado domain) {
        PreparedStatement st = null;

        String sql = "UPDATE estado " +
                "SET nome_estado = ?, id_pais = ? " +
                "WHERE id_estado = ?";

        try {
            st = this.conn.prepareStatement(sql);
            st.setString(1, domain.getNomeEstado());
            st.setLong(2, domain.getPais().getIdPais());
            st.setLong(3, domain.getIdEstado());
            st.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeStatement(st);
        }
    }

    @Override
    public Estado updateAndCheck(Estado domain) {
        this.update(domain);
        return this.findById(domain.getIdEstado());
    }

    @Override
    public void delete(Estado domain) {
        PreparedStatement st = null;

        String sql = "DELETE FROM estado WHERE id_estado = ?";

        try {
            st = this.conn.prepareStatement(sql);
            st.setLong(1, domain.getIdEstado());
            st.execute();
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            JDBCConnection.closeStatement(st);
        }
    }

    @Override
    public Estado findById(Long domainId) {
        Estado estado = null;
        Pais pais = null;

        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "SELECT e.*, p.nome_pais " +
                "FROM estado AS e INNER JOIN pais AS p " +
                "ON e.id_pais = p.id_pais " +
                "WHERE e.id_estado = ?";

        try {
            st = this.conn.prepareStatement(sql);
            st.setLong(1, domainId);
            rs = st.executeQuery();

            if (rs.next()) {
                pais = new Pais();
                pais.setIdPais(rs.getLong("id_pais"));
                pais.setNomePais(rs.getString("nome_pais"));

                estado = new Estado();
                estado.setIdEstado(rs.getLong("id_estado"));
                estado.setNomeEstado(rs.getString("nome_estado"));
                estado.setPais(pais);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeResultSet(rs);
            JDBCConnection.closeStatement(st);
        }

        return estado;
    }

    @Override
    public List<Estado> findAll() {
        Estado estado = null;
        Pais pais = null;
        List<Estado> estados = new ArrayList<>();
        Map<Long, Pais> paisMap = new HashMap<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "SELECT e.*, p.nome_pais " +
                "FROM estado AS e INNER JOIN pais AS p " +
                "ON e.id_pais = p.id_pais " +
                "ORDER BY e.nome_estado";

        try {
            st = this.conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                long idPais = rs.getLong("id_pais");
                pais = paisMap.get(idPais);

                if (pais == null) {
                    pais = new Pais();
                    pais.setIdPais(idPais);
                    pais.setNomePais(rs.getString("nome_pais"));

                    paisMap.put(idPais, pais);
                }

                estado = new Estado();
                estado.setIdEstado(rs.getLong("id_estado"));
                estado.setNomeEstado(rs.getString("nome_estado"));
                estado.setPais(pais);

                estados.add(estado);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeResultSet(rs);
            JDBCConnection.closeStatement(st);
        }

        return estados;
    }
}
