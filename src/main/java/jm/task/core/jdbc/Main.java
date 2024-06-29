package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//import static jm.task.core.jdbc.dao.UserDaoHibernateImpl.sessionFactory;

//import static jm.task.core.jdbc.util.Util.getConnect;

public class Main {
//    private static final User user1 = new User("Sasha", "Alexandrov", (byte) 13);
//    private static final User user2 = new User("Pasha", "Petrov", (byte) 3);
//    private static final User user3 = new User("Misha", "Ksandrov", (byte) 21);
//    private static final User user4 = new User("Dasha", "Ivanova", (byte) 55);
//
//    public static void main(String[] args) {
//        Util.getConnect();
//
//        UserService userService = new UserServiceImpl();
//
//        userService.createUsersTable();
//
//        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
//        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
//        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
//        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
//        List<User> users = userService.getAllUsers();
//        for (User user : users) {
//            System.out.println("User с именем — " + user.getName() + " добавлен в базу данных");
//        }
//        userService.removeUserById(1);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();// реализуйте алгоритм здесь
//    }
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        userService.createUsersTable();
        userService.saveUser("Sasha", "Alexandrov", (byte) 13);
        //System.out.println("User c имненем '" + userService.getAllUsers().get(0).getName() + "' добавлен в базу данных");
        userService.saveUser("Pasha", "Petrov", (byte) 3);
        //System.out.println("User c имненем '" + userService.getAllUsers().get(0).getName() + "' добавлен в базу данных");
        userService.saveUser("Misha", "Ksandrov", (byte) 21);
        //System.out.println("User c имненем '" + userService.getAllUsers().get(0).getName() + "' добавлен в базу данных");
        userService.saveUser("Dasha", "Ivanova", (byte) 55);
        //System.out.println("User c имненем '" + userService.getAllUsers().get(0).getName() + "' добавлен в базу данных");
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();


    }

}

