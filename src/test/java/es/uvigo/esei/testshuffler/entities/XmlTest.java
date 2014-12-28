package es.uvigo.esei.testshuffler.entities;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.*;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created by lipido on 12/28/14.
 */
public class XmlTest {

    @Test
    public void marshallUnmarshalTest() throws JAXBException, SAXException {
        QuestionsDB db = new QuestionsDB();
        Question question;
        Answer answer;

        // question 1
        question = new Question();
        question.setQuestion("What is your favourite fruit?");
        question.setSubject("Food preferences");

        answer = new Answer();
        answer.setValue("Apple");
        answer.setCorrect(false);
        question.addAnswer(answer);
        answer = new Answer();
        answer.setValue("Banana");
        answer.setCorrect(false);
        question.addAnswer(answer);
        answer = new Answer();
        answer.setValue("Orange");
        answer.setCorrect(true);
        question.addAnswer(answer);
        answer = new Answer();
        answer.setValue("Strawberry");
        answer.setCorrect(false);
        question.addAnswer(answer);

        db.addQuestion(question);

        // question 2
        question = new Question();
        question.setQuestion("What is your favourite computer manufacturer?");
        question.setSubject("Computer Manufacturers");

        answer = new Answer();
        answer.setValue("Apple");
        answer.setCorrect(true);
        question.addAnswer(answer);
        answer = new Answer();
        answer.setValue("Dell");
        answer.setCorrect(false);
        question.addAnswer(answer);
        answer = new Answer();
        answer.setValue("Acer");
        answer.setCorrect(true);
        question.addAnswer(answer);
        answer = new Answer();
        answer.setValue("Hewlett-packard");
        answer.setCorrect(false);
        question.addAnswer(answer);

        db.addQuestion(question);


        Marshaller marshaller = JAXBContext.newInstance(QuestionsDB.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshaller.marshal(db, baos);


        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/XML/XMLSchema/v1.1");
        final Schema schema = schemaFactory.newSchema(new File("src/main/resources/questionsdb.xsd"));
        Unmarshaller unmarshaller = JAXBContext.newInstance(QuestionsDB.class).createUnmarshaller();
        unmarshaller.setSchema(schema);

        QuestionsDB dbUnmarshalled = (QuestionsDB) unmarshaller.unmarshal(new ByteArrayInputStream(baos.toByteArray()));

        assertEquals(db, dbUnmarshalled);

    }


    @Test(expected=UnmarshalException.class)
    public void testXmlInput() throws JAXBException, SAXException {
        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/XML/XMLSchema/v1.1");
        final Schema schema = schemaFactory.newSchema(new File("src/main/resources/questionsdb.xsd"));

        final JAXBContext context = JAXBContext.newInstance(QuestionsDB.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(schema);
        unmarshaller.setEventHandler(new ValidationEventCollector());

        System.out.println(unmarshaller.unmarshal(new File("src/test/resources/questionsdb.xml")));
        System.out.println(unmarshaller.unmarshal(new File("src/test/resources/questionsdb.bad.xml")));
    }
}
