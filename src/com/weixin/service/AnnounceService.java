package com.weixin.service;

import com.weixin.bean.Announce;
import com.weixin.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Liuqi
 * Date: 2016/11/8.
 */
public class AnnounceService {

    /**
     * 发布 公告
     *
     * @param announce
     * @return
     */
    public boolean addAnnounce(Announce announce) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        int i = 0;
        String sql = "insert into announce(title,content) value (?,?)";
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, announce.getTitle());
            statement.setString(2, announce.getContent());
            i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.free(connection, statement, resultSet);
        }
        return i == 1 ? true : false;
    }

    public Announce findAnnounce() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        //查找最后一条公告
        String sql = "select * from announce order by id desc limit 1";
        Announce announce = new Announce();
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                announce.setId(resultSet.getInt("id"));
                announce.setTitle(resultSet.getString("title"));
                announce.setContent(resultSet.getString("content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.free(connection, statement, resultSet);
        }
        return announce;

    }
}
