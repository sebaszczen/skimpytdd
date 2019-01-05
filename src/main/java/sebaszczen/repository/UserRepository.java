package sebaszczen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebaszczen.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findByName(String name);
}
