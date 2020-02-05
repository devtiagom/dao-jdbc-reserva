package dao;

import db.JDBCConnection;
import domain.Modalidade;
import domain.TipoPasseio;

public class DAOFactory {

    public static DAO<Modalidade> createModalidadeDAO() {
        return new ModalidadeDao(JDBCConnection.getConnection());
    }

    public static DAO<TipoPasseio> createTipoPasseioDAO() {
        return new TipoPasseioDAO(JDBCConnection.getConnection());
    }
}
