package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Util {
//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
//    private static final String CON_URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static SessionFactory sessionFactory;

    //public static void main(String[] args) {
    public static SessionFactory getConnect() {
        //        Connection conn = null;
//        try {
//            Class.forName(DRIVER);
//            conn = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
//            Statement stmt = conn.createStatement();
//            conn.setAutoCommit(false);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        return conn;
        if (sessionFactory == null) {
        try {
            Configuration configuration = new Configuration();

            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydbtest");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "root");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

            settings.put(Environment.SHOW_SQL, "true");

            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            settings.put(Environment.HBM2DDL_AUTO, "create-drop");

            configuration.setProperties(settings);

            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            System.out.println("ok");

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.out.println("ne ok");
            e.printStackTrace();
        }
    }
        return sessionFactory;
    }// реализуйте настройку соеденения с БД
}
