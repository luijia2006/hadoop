package com.qdedu.spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author xpleaf
 * @date 2019/7/13 4:06 PM
 */
public class SampleSparkJdbcServer {

    public static void main(String[] args) throws Exception {
        Class.forName("org.apache.hive.jdbc.HiveDriver");

        Connection connection = DriverManager.getConnection("jdbc:hive2://172.16.1.66:10000");
        Statement statement = connection.createStatement();
        String sql = "select * from person";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(String.format("id: %s, name: %s", id, name));
        }
    }

}