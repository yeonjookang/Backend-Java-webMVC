package jwp.dao;

import core.jdbc.JdbcTemplate;
import jwp.model.Question;
import jwp.model.User;

import java.sql.SQLException;
import java.util.List;

public class QuestionDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public void insert(Question question) throws SQLException {
        String sql = "INSERT INTO QUESTIONS VALUES (?, ?, ?, ?,?,?)";

        //동작만 전달!
        jdbcTemplate.update(sql,pstmt -> {
            pstmt.setInt(1, question.getQuestionId());
            pstmt.setString(2,question.getWriter());
            pstmt.setString(3, question.getTitle());
            pstmt.setString(4, question.getContents());
            pstmt.setDate(5, question.getCreatedDate());
            pstmt.setInt(6, question.getCountOfAnswer());
        });
    }

    public List<Question> findAll() throws SQLException {
        // TODO 구현 필요함.
        String sql = "SELECT * FROM QUESTIONS";

        return jdbcTemplate.query(sql, rs->
                new Question(rs.getInt("questionId"), rs.getString("writer"), rs.getString("title"),
                        rs.getString("contents"),rs.getDate("createdDate"),rs.getInt("countOfAnswer"))
        );
    }
}
