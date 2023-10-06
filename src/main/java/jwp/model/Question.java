package jwp.model;

import java.sql.Date;
import java.time.LocalDate;

public class Question {
    private Integer questionId;
    private String writer;
    private String title;
    private String contents;
    private Date createdDate;
    private Integer countOfAnswer;

    public Question(Integer questionId, String writer, String title, String contents, Date createdDate, Integer countOfAnswer) {
        this.questionId = questionId;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
        this.countOfAnswer = countOfAnswer;
    }
    public Question(String writer, String title, String contents, int countOfAnswer) {
        this.questionId = 0;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdDate = Date.valueOf(LocalDate.now());
        this.countOfAnswer = countOfAnswer;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Integer getCountOfAnswer() {
        return countOfAnswer;
    }
}
