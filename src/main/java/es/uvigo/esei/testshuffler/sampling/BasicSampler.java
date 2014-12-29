package es.uvigo.esei.testshuffler.sampling;

import es.uvigo.esei.testshuffler.entities.Answer;
import es.uvigo.esei.testshuffler.entities.Question;
import es.uvigo.esei.testshuffler.entities.QuestionsDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lipido on 12/29/14.
 */
public class BasicSampler implements QuestionsdbSampler{

    private QuestionsDB originaldb;
    private int totalQuestions = 10;
    private boolean shuffleAnswers;

    public BasicSampler(QuestionsDB originaldb) {
        this.originaldb = originaldb;
    }

    public BasicSampler totalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        return this;
    }

    public BasicSampler shuffleAnswers(){
        this.shuffleAnswers = true;
        return this;
    }

    @Override
    public QuestionsDB sample() {
        QuestionsDB sample = new QuestionsDB();

        int count = 0;
        for (Question question : originaldb.getQuestions()) {
            if (count == this.totalQuestions) break;
            if (this.shuffleAnswers) {
                Question shuffled = cloneQuestionNoAnswers(question);
                List<Answer> answers = new ArrayList<>();
                answers.addAll(question.getAnswers());
                Collections.shuffle(answers);

                answers.forEach(shuffled::addAnswer);

            } else {
                sample.addQuestion(question);
            }
        }

        return sample;
    }

    private Question cloneQuestionNoAnswers(Question q) {
        Question clone = new Question();
        clone.setQuestion(q.getQuestion());
        clone.setSubject(q.getSubject());
        return clone;
    }
}
