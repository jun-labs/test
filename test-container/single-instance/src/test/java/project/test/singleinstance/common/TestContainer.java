package project.test.singleinstance.common;

import org.testcontainers.containers.MySQLContainer;

public final class TestContainer {

    private static MySQLContainer<?> mySQLContainer =
        new MySQLContainer<>("mysql:8.0.28");

    private TestContainer() {
        throw new AssertionError("올바른 방식으로 생성자를 호출해주세요.");
    }

    public static void start() {
        mySQLContainer.start();
    }

    public static void stop() {
        mySQLContainer.stop();
    }
}
