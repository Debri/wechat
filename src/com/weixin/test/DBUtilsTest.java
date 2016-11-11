package com.weixin.test;

import com.weixin.util.DBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Liuqi
 * Date: 2016/11/8.
 */
public class DBUtilsTest {
    @Test
    public void testGetConnection() throws Exception {
        String sql = "select * from song where id=3";
        Connection connection=null;
        for (int i = 0; i < 5000; i++) {
            connection=DBUtils.getConnection();
            System.out.println(i+connection.toString());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeQuery();

            DBUtils.free(connection, statement, null);
            System.out.println(connection.toString());
        }

    }

    @Test
    public void testGetPreparedStatement() throws Exception {

    }

    @Test
    public void testFree() throws Exception {

    }

}