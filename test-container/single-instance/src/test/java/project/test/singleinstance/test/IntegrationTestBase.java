package project.test.singleinstance.test;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;
import project.test.singleinstance.common.TestContainer;

@Testcontainers
@SpringBootTest
@ActiveProfiles("test")
public abstract class IntegrationTestBase {

    @Autowired
    private DataSource dataSource;

    @BeforeAll
    static void beforeAll() {
        TestContainer.start();
    }

    @AfterAll
    static void afterAll() {
        TestContainer.stop();
    }

    @BeforeEach
    void beforeEach() {
        executeSqlFile("script/schema.sql");
    }

    public void executeSqlFile(String filePath) {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new FileSystemResource(filePath));
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute SQL script", e);
        }
    }
}
