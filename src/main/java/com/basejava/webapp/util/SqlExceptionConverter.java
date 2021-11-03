package com.basejava.webapp.util;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.StorageException;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;

public class SqlExceptionConverter {
    public static StorageException convertSqlException(SQLException exception) {
        if(exception instanceof PSQLException) {
            if(exception.getSQLState().equals("23505")) {
                return new ExistStorageException(null);
            }
        }
        return new StorageException(exception);
    }
}
