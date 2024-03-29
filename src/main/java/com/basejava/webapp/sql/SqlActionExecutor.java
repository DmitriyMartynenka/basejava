package com.basejava.webapp.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface SqlActionExecutor<T> {
    T execute(PreparedStatement ps) throws SQLException;
}
