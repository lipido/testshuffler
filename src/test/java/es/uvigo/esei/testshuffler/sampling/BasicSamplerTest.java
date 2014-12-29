package es.uvigo.esei.testshuffler.sampling;

import es.uvigo.esei.testshuffler.entities.QuestionsDB;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;

import static es.uvigo.esei.testshuffler.Utils.readFromXML;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by lipido on 12/29/14.
 */
public class BasicSamplerTest {

    @Test
    public void testEquals() throws JAXBException, SAXException {
        QuestionsDB db = readFromXML("src/test/resources/questionsdb.xml");

        QuestionsDB sample = new BasicSampler(db)
                .totalQuestions(db.getQuestions().size())
        .sample();

        assertEquals(sample, db);
    }

    @Test
    public void testShuffle() throws JAXBException, SAXException {
        QuestionsDB db = readFromXML("src/test/resources/questionsdb.xml");

        QuestionsDB sample = new BasicSampler(db)
                .totalQuestions(db.getQuestions().size())
                .shuffleAnswers()
        .sample();

        assertFalse(sample.equals(db));
    }
}
