package com.star.people.mapper.handler;

import com.star.people.enums.ArticleStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zuhai.jiang on 2015/12/23.
 */
public class StatusHandler implements TypeHandler<ArticleStatus> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, ArticleStatus articleStatus, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, String.valueOf(articleStatus.getValue()));
    }

    @Override
    public ArticleStatus getResult(ResultSet resultSet, String s) throws SQLException {
        Integer val = resultSet.getInt(s);
        if (val == null) {return null;}
        return ArticleStatus.valueOf(val);
    }

    @Override
    public ArticleStatus getResult(ResultSet resultSet, int i) throws SQLException {
        Integer val = resultSet.getInt(i);
        if (val == null) {return null;}
        return ArticleStatus.valueOf(val);
    }

    @Override
    public ArticleStatus getResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer val = callableStatement.getInt(i);
        return ArticleStatus.valueOf(val);
    }
}
