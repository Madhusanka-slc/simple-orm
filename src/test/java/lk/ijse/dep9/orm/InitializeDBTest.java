package lk.ijse.dep9.orm;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class InitializeDBTest {

    @BeforeAll
    static void beforeAll() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Test
    void initialize() {
        assertDoesNotThrow(()->{
            InitializeDB.initialize(
                    "localhost",
                    "3306",
                    "dep9_orm","root","MYsql.123","lk.ijse.dep9.orm.entity");
        });

        assertDoesNotThrow(()->{
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dep9_orm", "root", "MYsql.123");
                connection.createStatement().execute("SELECT id,name,address FROM Customer");
                connection.createStatement().execute("SELECT code,description,qty,unitPrice FROM Item");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

    }
}