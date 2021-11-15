package com.basejava.webapp.sql;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.util.SqlExceptionConverter;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    private final ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void execute(String sqlQuery) {
        execute(sqlQuery, (SqlActionExecutor<Object>) PreparedStatement::execute);
    }

    public <T> T execute(String sqlQuery, SqlActionExecutor<T> executor) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sqlQuery)) {
            return executor.execute(ps);
        } catch (SQLException e) {
            throw SqlExceptionConverter.convertSqlException(e);
        }
    }

    public <T> T transactionalExecute(SqlTransaction<T> executor) {
        try {
            Connection conn = connectionFactory.getConnection();
            try {
                conn.setAutoCommit(false);
                T result = executor.execute(conn);
                conn.commit();
                return result;
            } catch (SQLException exception) {
                conn.rollback();
                throw SqlExceptionConverter.convertSqlException(exception);
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }
}