package test;

import org.apache.commons.dbutils.DbUtils;
import org.junit.Test;
import utils.JdbcUtils;

import java.sql.Connection;

import static org.junit.Assert.*;

public class JdbcUtilsTest {

    @Test
    public void getConnection() {
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
    }
}