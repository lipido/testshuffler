package es.uvigo.esei.testshuffler.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Collections;
import java.util.List;

/**
 * Created by lipido on 12/26/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Question {
    private String question;
    private List<String> answers;
    private int correctAnswer;

    Question() {}

    public Question(String question, List<String> answers, int correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return Collections.unmodifiableList(answers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question1 = (Question) o;

        if (correctAnswer != question1.correctAnswer) return false;
        if (answers != null ? !answers.equals(question1.answers) : question1.answers != null) return false;
        if (question != null ? !question.equals(question1.question) : question1.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = question != null ? question.hashCode() : 0;
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        result = 31 * result + correctAnswer;
        return result;
    }
}
