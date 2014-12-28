package es.uvigo.esei.testshuffler.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lipido on 12/28/14.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionsDatabase {
    private List<Question> questions = new LinkedList<>();

    public void addQuestion(Question q) {
        this.questions.add(q);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionsDatabase that = (QuestionsDatabase) o;

        if (questions != null ? !questions.equals(that.questions) : that.questions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return questions != null ? questions.hashCode() : 0;
    }
}
