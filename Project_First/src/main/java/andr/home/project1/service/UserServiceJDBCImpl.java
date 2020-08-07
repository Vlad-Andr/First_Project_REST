package andr.home.project1.service;

import andr.home.project1.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class UserServiceJDBCImpl implements UserService {

    @Value("${User.createUser}")
    private String saveQuery;
    @Value("${User.getAllUsers}")
    private String allUsersQuery;
    @Value("${User.getUsersByAge}")
    private String usersByAgeQuery;
    @Value("${User.deleteUser}")
    private String deleteQuery;
    @Value("${User.updateUser}")
    private String updateQuery;
    @Value("${User.getUserById}")
    private String getUserByIdQuery;

    private JdbcTemplate jdbcTemplate;

    public UserServiceJDBCImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void addNewUser(User user) {
        jdbcTemplate.update(saveQuery,user.getUserId(),user.getFirstName(),user.getLastName(),user.getAge());
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(allUsersQuery, new UserMapper());
    }

    @Override
    public void deleteUser(Long id) {
        jdbcTemplate.update(deleteQuery,id);
    }

    @Override
    public void updateUser(Long id, User user) {
        jdbcTemplate.update(updateQuery,user.getUserId(),user.getFirstName(),user.getLastName(),user.getAge(),id);
    }

    @Override
    public List<User> allUsersByAge(int age) {
        return jdbcTemplate.query(usersByAgeQuery,new UserMapper(),age);
    }

    @Override
    public List<User> getUserById(Long id) {
        return jdbcTemplate.query(getUserByIdQuery,new UserMapper(), id);
    }
}
