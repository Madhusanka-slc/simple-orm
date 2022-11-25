package lk.ijse.dep9.orm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InitializeDBTest {

    @Test
    void initialize() {
        assertDoesNotThrow(()->{
            InitializeDB.initialize("dep9-orm");
        });

    }
}