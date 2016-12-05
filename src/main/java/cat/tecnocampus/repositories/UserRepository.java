package cat.tecnocampus.repositories;

import cat.tecnocampus.domain.Station;
import cat.tecnocampus.domain.User;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by roure on 14/11/2016.
 */
@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int[] saveUsers(List<User> users) {
        return jdbcTemplate.batchUpdate("INSERT INTO user(username, name, second_name, email, password) values(?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        User user = users.get(i);
                        preparedStatement.setString(1, user.getUsername());
                        preparedStatement.setString(2, user.getName());
                        preparedStatement.setString(3, user.getSecondName());
                        preparedStatement.setString(4, user.getEmail());
                        preparedStatement.setString(5, user.getPassword());
                    }

                    @Override
                    public int getBatchSize() {
                        return users.size();
                    }
                });
    }

}
