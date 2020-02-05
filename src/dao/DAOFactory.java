package dao;

import db.JDBCConnection;
import domain.Modalidade;

public class DAOFactory {

    public static DAO<Modalidade> createModalidadeDAO() {
        return new ModalidadeDao(JDBCConnection.getConnection());
    }
}
