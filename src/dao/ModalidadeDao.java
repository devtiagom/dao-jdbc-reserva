package dao;

import db.DbException;
import db.JDBCConnection;
import domain.Modalidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModalidadeDao implements DAO<Modalidade> {

    private Connection conn;

    public ModalidadeDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Modalidade domain) {
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "INSERT INTO modalidade (nome) VALUES (?)";

        try {
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, domain.getNome());

            int rowsAffected =  st.executeUpdate();
            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) domain.setIdModalidade(rs.getLong(1));
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
    public void update(Modalidade domain) {
        PreparedStatement st = null;

        String sql = "UPDATE modalidade SET nome = ? WHERE id_modalidade = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setString(1, domain.getNome());
            st.setLong(2, domain.getIdModalidade());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeStatement(st);
        }
    }

    @Override
    public void delete(Modalidade domain) {
        PreparedStatement st = null;

        String sql = "DELETE FROM modalidade WHERE id_modalidade = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setLong(1, domain.getIdModalidade());
            st.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeStatement(st);
        }
    }

    @Override
    public Modalidade findById(Long domainId) {
        Modalidade modalidade = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM modalidade WHERE id_modalidade = ?";

        try {
            st = this.conn.prepareStatement(sql);
            st.setLong(1, domainId);
            rs = st.executeQuery();

            if (rs.next()) {
                modalidade = new Modalidade();
                modalidade.setIdModalidade(rs.getLong("id_modalidade"));
                modalidade.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeResultSet(rs);
            JDBCConnection.closeStatement(st);
        }

        return modalidade;
    }

    @Override
    public List<Modalidade> findAll() {
        List<Modalidade> modalidades = new ArrayList<>();
        Modalidade modalidade = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM modalidade";

        try {
            st = this.conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                modalidade = new Modalidade();
                modalidade.setIdModalidade(rs.getLong("id_modalidade"));
                modalidade.setNome(rs.getString("nome"));
                modalidades.add(modalidade);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            JDBCConnection.closeResultSet(rs);
            JDBCConnection.closeStatement(st);
        }

        return modalidades;
    }
}
