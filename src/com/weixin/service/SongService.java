package com.weixin.service;

import com.weixin.bean.Song;
import com.weixin.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liuqi
 * Date: 2016/11/6.
 */
public class SongService {


    public List<Song> masterFind() {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<Song> list = new ArrayList<Song>();
        String sql = "select * from song where status=1 or status=0 ORDER BY id DESC limit 60";
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Song song = new Song();
                song.setSong(resultSet.getString("song"));
                song.setDiangeren(resultSet.getString("diangeren"));
                song.setJiyu(resultSet.getString("jiyu"));
                //song.setNiming(resultSet.getInt("niming"));
                song.setStatus(resultSet.getInt("status"));
                song.setReceiver(resultSet.getString("receiver"));
                song.setTime(resultSet.getString("time"));
                song.setSinger(resultSet.getString("singer"));
                song.setId(resultSet.getInt("id"));
                list.add(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.free(connection, statement, resultSet);
        }

        return list;
    }

    public boolean addSong(Song song) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        int i = 0;
        String sql = "insert into song(song,singer,diangeren,receiver,jiyu,status,time) value (?,?,?,?,?,?,?)";
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql);
            //statement=DBUtils.getPreparedStatement(sql);
            statement.setString(1, song.getSong());
            statement.setString(2, song.getSinger());
            statement.setString(3, song.getDiangeren());
            statement.setString(4, song.getReceiver());
            statement.setString(5, song.getJiyu());
//            statement.setInt(6, song.getNiming());
            statement.setInt(6, 0);
            statement.setString(7, song.getTime());
            i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.free(connection, statement, null);
        }
        return i == 1 ? true : false;
    }

    /**
     * 管理员审核验证歌曲是否通过，通过  播放歌曲
     *
     * @param id
     * @return
     */
    public boolean doVerify(int id, int status) {

        String sql = "update song set status=1 where id=?";
        if (status == 2) {
            sql = "update song set status=2 where id=?";
        }
        int i = this.doUpdate(sql, id);
        return i == 1 ? true : false;
    }

    /**
     * 查询不同状态的点歌
     *
     * @param status
     * @return
     */
    public List<Song> selectSongByStatus(int status) {
        PreparedStatement statement = null;
        Connection connection = null;
        List<Song> list = new ArrayList<Song>();
        String sql = " select * from song where status = ?  order by id desc limit 40";
        ResultSet resultSet = null;
        try {
            connection = DBUtils.getConnection();
            System.out.println(sql);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, status);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Song song = new Song();
                song.setSong(resultSet.getString("song"));
                song.setDiangeren(resultSet.getString("diangeren"));
                song.setJiyu(resultSet.getString("jiyu"));
                song.setNiming(resultSet.getInt("niming"));
                song.setStatus(resultSet.getInt("status"));
                song.setReceiver(resultSet.getString("receiver"));
                song.setTime(resultSet.getString("time"));
                song.setSinger(resultSet.getString("singer"));
                song.setId(resultSet.getInt("id"));
                list.add(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.free(connection, statement, resultSet);
        }
        return list;
    }

    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    public boolean deleteById(int id) {
        String sql = "delete from song where id= ?";
        int i = this.doUpdate(sql, id);
        return i == 1 ? true : false;
    }

    public int doUpdate(String sql, int id) {
        int i = 0;
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.free(connection, statement, null);
        }
        return i;
    }
}
