package dao.impl;

import dao.UserDao;
import pojo.User;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    /**
     * 注册请求
     * @param user
     * @return
     */
    @Override
    public int regist(User user) {

        Connection conn=null;
        PreparedStatement ps=null;
        int row=0;
        try {
            //创建数据库连接
            conn= JdbcUtils.getConnection();
            //准备sql语句
            String sql="insert into tb_user(id,username,password,phone) values(null,?,?,?)";
            // 准备PreparedStatement
            ps=conn.prepareStatement(sql);

            ps.setObject(1,user.getUsername());
            ps.setObject(2,user.getPassword());
            ps.setObject(3,user.getPhone());

            //执行
            row = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return row;
    }

    @Override
    public User queryUserByUsernamePassword(String name, String pwd) {
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet resultSet =null;
        try {
            conn = JdbcUtils.getConnection();
            String sql="select id,username,password,phone from tb_user where username=? and password=?";
            ps=conn.prepareStatement(sql) ;
            ps.setString(1,name);
            ps.setString(2,pwd);
            resultSet = ps.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String phone = resultSet.getString(4);
                //将从数据库拿到的数据封装到一个User对象
                User user = new User(id, username, password, phone);
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    @Override
    public User queryUserByUsername(String name) {
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet resultSet =null;
        try {
            conn = JdbcUtils.getConnection();
            String sql="select id,username,password,phone from tb_user where username=?";
            ps=conn.prepareStatement(sql) ;
            ps.setString(1,name);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String phone = resultSet.getString(4);
                //将从数据库拿到的数据封装到一个User对象
                User user = new User(id, username, password, phone);
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
