package dao;

import db.DbException;
import db.DbIntegrityException;
import db.JDBCConnection;
import domain.Modalidade;
import domain.Pais;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO implements DAO<Pais> {

    private Connection conn;

    public PaisDAO(Connection conn) { this.conn = conn; }

    @Override
    public void save(Pais domain) {
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "INSERT INTO pais (nome_pais) VALUES (?)";

        try {
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, domain.getNomePais());

            int rowsAffected =  st.executeUpdate();
            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) domain.setIdPais(rs.getLong(1));
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
    public Pais saveAndCheck(Pais domain) {
        this.save(domain);
        return this.findById(domain.getIdPais());
    }

    @Override
    public void update(Pais domain) {
        PreparedStatement st = null;

        String sql = "UPDATE pais SET nome_pais = ? WHERE id_pais = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setString(1, domain.getNomePais());
            st.setLong(2, domain.getIdPais());
            st.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeStatement(st);
        }
    }

    @Override
    public Pais updateAndCheck(Pais domain) {
        this.update(domain);
        return this.findById(domain.getIdPais());
    }

    @Override
    public void delete(Pais domain) {
        PreparedStatement st = null;

        String sql = "DELETE FROM pais WHERE id_pais = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setLong(1, domain.getIdPais());
            st.execute();
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            JDBCConnection.closeStatement(st);
        }
    }

    @Override
    public Pais findById(Long domainId) {
        Pais pais = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM pais WHERE id_pais = ?";

        try {
            st = this.conn.prepareStatement(sql);
            st.setLong(1, domainId);
            rs = st.executeQuery();

            if (rs.next()) {
                pais = new Pais();
                pais.setIdPais(rs.getLong("id_pais"));
                pais.setNomePais(rs.getString("nome_pais"));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeResultSet(rs);
            JDBCConnection.closeStatement(st);
        }

        return pais;
    }

    @Override
    public List<Pais> findAll() {
        List<Pais> paises = new ArrayList<>();
        Pais pais = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM pais";

        try {
            st = this.conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                pais = new Pais();
                pais.setIdPais(rs.getLong("id_pais"));
                pais.setNomePais(rs.getString("nome_pais"));
                paises.add(pais);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeResultSet(rs);
            JDBCConnection.closeStatement(st);
        }

        return paises;
    }
}
