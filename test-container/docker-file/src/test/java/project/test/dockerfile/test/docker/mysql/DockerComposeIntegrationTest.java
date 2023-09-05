package project.test.dockerfile.test.docker.mysql;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import project.test.dockerfile.core.domain.user.entity.User;
import project.test.dockerfile.core.domain.user.repository.UserJpaRepository;
import project.test.dockerfile.test.IntegrationTestBase;

@DisplayName("[IntegrationTest] 도커 컴포즈를 활용한 테스트 컨테이너 구동 통합 테스트")
class DockerComposeIntegrationTest extends IntegrationTestBase {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    @DisplayName("사용자를 저장하면 PK가 Null이 아니다.")
    void user_save_test() {
        User newUser = userJpaRepository.save(new User("Jun"));

        assertNotNull(newUser.getId());
    }
}
