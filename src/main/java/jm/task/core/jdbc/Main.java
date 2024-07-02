package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import static jm.task.core.jdbc.util.Util.closeConnection;

public class Main {

    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        userService.createUsersTable();
        userService.saveUser("Sasha", "Alexandrov", (byte) 13);
        System.out.println("User c имненем '" + userService.getAllUsers().get(0).getName() + "' добавлен в базу данных");
        userService.saveUser("Pasha", "Petrov", (byte) 3);
        System.out.println("User c имненем '" + userService.getAllUsers().get(0).getName() + "' добавлен в базу данных");
        userService.saveUser("Misha", "Ksandrov", (byte) 21);
        System.out.println("User c имненем '" + userService.getAllUsers().get(0).getName() + "' добавлен в базу данных");
        userService.saveUser("Dasha", "Ivanova", (byte) 55);
        System.out.println("User c имненем '" + userService.getAllUsers().get(0).getName() + "' добавлен в базу данных");
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        closeConnection();
    }
}

