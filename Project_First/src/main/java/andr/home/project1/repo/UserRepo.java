package andr.home.project1.repo;

import andr.home.project1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    List<User> getUsersByAge(int age);

    Optional<User> findUserByFirstName(String name);

    @Query(value = "SELECT * FROM users WHERE age = ( SELECT MAX (age) FROM users)", nativeQuery = true)
    List<User> findByAgeWhereCountLettersMax();
}
