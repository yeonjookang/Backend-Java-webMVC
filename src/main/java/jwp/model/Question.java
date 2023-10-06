package jwp.model;

import java.sql.Timestamp;

public class Question {
    private Integer questionId;
    private String writer;
    private String title;
    private String contents;
    private Timestamp createdDate;
    private Integer countOfAnswer;

    public Question(Integer questionId, String writer, String title, String contents, Timestamp createdDate, Integer countOfAnswer) {
        this.questionId = questionId;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Integer getCountOfAnswer() {
        return countOfAnswer;
    }
}
