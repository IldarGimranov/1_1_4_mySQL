package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static Transaction tx = null;

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        try (Session session = Util.getConnection().openSession()) {
            tx = session.beginTransaction();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS hiberUsers" +
                    " (id mediumint not null auto_increment, name VARCHAR(50), " +
                    "lastname VARCHAR(50), " +
                    "age tinyint, " +
                    "PRIMARY KEY (id))").executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void dropUsersTable() {
        try (Session session = Util.getConnection().openSession()) {
            tx = session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS hiberUsers").executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getConnection().openSession()) {
            tx = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getConnection().openSession()) {
            tx = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Session session = Util.getConnection().openSession()) {
            userList = session.createQuery("from User", User.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        System.out.println(userList);
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getConnection().openSession()) {
            tx = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
