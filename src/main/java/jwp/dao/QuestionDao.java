package jwp.dao;

import core.jdbc.JdbcTemplate;
import jwp.model.Question;
import jwp.model.User;

import java.sql.SQLException;
import java.util.List;

public class QuestionDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public List<Question> findAll() throws SQLException {
        // TODO 구현 필요함.
        String sql = "SELECT * FROM QUESTIONS";

        return jdbcTemplate.query(sql, rs->
                new Question(rs.getInt("questionId"), rs.getString("writer"), rs.getString("title"),
                        rs.getString("contents"),rs.getTimestamp("createdDate"),rs.getInt("countOfAnswer"))
        );
    }
}
