package dao.impl;

import com.example.demo.entity.User;
import dao.BaseDao;
import dao.UserDao;
import org.intellij.lang.annotations.Language;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDaoImpl extends BaseDao<User>  implements UserDao {


    public static final String SELECT_LOGIN_PASSWORD = "SELECT password FROM phone_book  WHERE last_name = ?";
    private static  UserDaoImpl instance = new UserDaoImpl();
    private  UserDaoImpl() {

    }
    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean authenticate(String login, String password) {
        try {

            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://localhost:5432/java_task1";
        Properties prop = new Properties();
        prop.put("user", "postgres");
        prop.put("password", "220073dsi");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        prop.put("useSSL", "true");
        prop.put("useJDBCCompliantTimezoneShift", "true");
        prop.put("useLegacyDatetimeCode", "false");
        prop.put("serverTimezone", "UTC");
        prop.put("serverSsCert", "classpath:server.crt");

        boolean match = false;

        try (Connection connection = DriverManager.getConnection(url, prop);
             PreparedStatement statement = connection.prepareStatement(SELECT_LOGIN_PASSWORD )) {
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            String passFromDB ;

            if (resultSet.next()) {
                passFromDB = resultSet.getString(1);
                match = password.equals(passFromDB);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return match;
    }
}

