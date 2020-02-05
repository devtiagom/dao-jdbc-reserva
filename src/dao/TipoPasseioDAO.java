package dao;

import db.DbException;
import db.DbIntegrityException;
import db.JDBCConnection;
import domain.Modalidade;
import domain.TipoPasseio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoPasseioDAO implements DAO<TipoPasseio> {

    private Connection conn;

    public TipoPasseioDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(TipoPasseio domain) {
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "INSERT INTO tipo_passeio (nome_passeio, descricao_passeio) VALUES (?, ?)";

        try {
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, domain.getNomePasseio());
            st.setString(2, domain.getDescricaoPasseio());

            int rowsAffected =  st.executeUpdate();
            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) domain.setIdTipoPasseio(rs.getLong(1));
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
    public TipoPasseio saveAndCheck(TipoPasseio domain) {
        this.save(domain);
        return this.findById(domain.getIdTipoPasseio());
    }

    @Override
    public void update(TipoPasseio domain) {
        PreparedStatement st = null;

        String sql = "UPDATE tipo_passeio " +
                "SET nome_passeio = ?, descricao_passeio = ? " +
                "WHERE id_tipo_passeio = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setString(1, domain.getNomePasseio());
            st.setString(2, domain.getDescricaoPasseio());
            st.setLong(3, domain.getIdTipoPasseio());
            st.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeStatement(st);
        }
    }

    @Override
    public TipoPasseio updateAndCheck(TipoPasseio domain) {
        this.update(domain);
        return this.findById(domain.getIdTipoPasseio());
    }

    @Override
    public void delete(TipoPasseio domain) {
        PreparedStatement st = null;

        String sql = "DELETE FROM tipo_passeio WHERE id_tipo_passeio = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setLong(1, domain.getIdTipoPasseio());
            st.execute();
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            JDBCConnection.closeStatement(st);
        }
    }

    @Override
    public TipoPasseio findById(Long domainId) {
        TipoPasseio tipoPasseio = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM tipo_passeio WHERE id_tipo_passeio = ?";

        try {
            st = this.conn.prepareStatement(sql);
            st.setLong(1, domainId);
            rs = st.executeQuery();

            if (rs.next()) {
                tipoPasseio = new TipoPasseio();
                tipoPasseio.setIdTipoPasseio(rs.getLong("id_tipo_passeio"));
                tipoPasseio.setNomePasseio(rs.getString("nome_passeio"));
                tipoPasseio.setDescricaoPasseio(rs.getString("descricao_passeio"));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeResultSet(rs);
            JDBCConnection.closeStatement(st);
        }

        return tipoPasseio;
    }

    @Override
    public List<TipoPasseio> findAll() {
        List<TipoPasseio> tiposPasseios = new ArrayList<>();
        TipoPasseio tipoPasseio = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM tipo_passeio";

        try {
            st = this.conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                tipoPasseio = new TipoPasseio();
                tipoPasseio.setIdTipoPasseio(rs.getLong("id_tipo_passeio"));
                tipoPasseio.setNomePasseio(rs.getString("nome_passeio"));
                tipoPasseio.setDescricaoPasseio(rs.getString("descricao_passeio"));
                tiposPasseios.add(tipoPasseio);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeResultSet(rs);
            JDBCConnection.closeStatement(st);
        }

        return tiposPasseios;
    }
}
