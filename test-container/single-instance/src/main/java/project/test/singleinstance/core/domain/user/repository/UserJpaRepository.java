package project.test.singleinstance.core.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.test.singleinstance.core.domain.user.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

}
