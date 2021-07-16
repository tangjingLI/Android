package com.example.homework1.album;

/**
 * @author ltj
 * @since 2021/7/14 20:24
 */

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    String databaseName = "h1_users";//数据库名
    String user = "root";//使用管理员账号启动
    String sql_pwd = "mysql";//数据库密码
    String URL = "jdbc:mysql://172.31.29.156:3306/" + databaseName + "?useSSL=false&serverTimezone=UTC";
    String DRIVER = "com.mysql.jdbc.Driver";


//    public static void main(String[] args) {
//        DBConnection myJDBC = new DBConnection();
//        myJDBC.connect();
//    }

    public boolean query(String email, String pwd) {
        Connection connection = null;
        Statement statement = null;
        try {
            //启动JDBC驱动
            Class.forName(DRIVER);
            //链接数据库
            connection = DriverManager.getConnection(URL, user, sql_pwd);
            //查询数据
            statement = connection.createStatement();
            //mysql语句
            String sql = "SELECT password FROM users where email= \'" + email + "\';";
            //查询数据
            Log.d("Debug", sql);
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.next() ||! resultSet.getString("password") .equals(pwd) )
                return false;
            // 完成后关闭
            resultSet.close();
            statement.close();
            connection.close();
            //下面是异常处理
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }

    public void insert(String name, String email, String pwd, int age, String gender, String address) {
        Connection connection = null;
        Statement statement = null;
        try {
            //启动JDBC驱动
            Class.forName(DRIVER);
            //链接数据库
            connection = DriverManager.getConnection(URL, user, sql_pwd);
            //查询数据
            statement = connection.createStatement();
            //mysql语句
            String sql = "insert into users(name,email,password,age,gender,address) values(\'" + name + "\',\'" + email + "\',\'" + pwd + "\'," + age + ",\'" + gender + "\',\'" + address + "\');";
            //查询数据
            Log.d("Debug", sql);
            int result = statement.executeUpdate(sql);
            // 完成后关闭
            statement.close();
            connection.close();
            //下面是异常处理
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}

