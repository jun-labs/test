package project.test.dockerfile.common;

import java.io.File;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;

public final class TestContainer {

    @Container
    private static final DockerComposeContainer<?> composeContainer;

    static {
        composeContainer = new DockerComposeContainer<>(
            new File("src/test/resources/docker-compose.yaml"));
    }

    private TestContainer() {
        throw new AssertionError("올바른 방식으로 생성자를 호출해주세요.");
    }

    public static void start() {
        composeContainer.start();
    }

    public static void stop() {
        composeContainer.stop();
    }
}
