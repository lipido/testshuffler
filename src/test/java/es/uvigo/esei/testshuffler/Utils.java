package es.uvigo.esei.testshuffler;

import es.uvigo.esei.testshuffler.entities.QuestionsDB;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * Created by lipido on 12/29/14.
 */
public class Utils {
    public static QuestionsDB readFromXML(File xmlFile) throws SAXException, JAXBException {

        final SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/XML/XMLSchema/v1.1");
        final Schema schema = schemaFactory.newSchema(new File("src/main/resources/questionsdb.xsd"));

        final JAXBContext context = JAXBContext.newInstance(QuestionsDB.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(schema);
        unmarshaller.setEventHandler(new ValidationEventCollector());

        return (QuestionsDB) unmarshaller.unmarshal(xmlFile);
    }

    public static QuestionsDB readFromXML(String path) throws JAXBException, SAXException {
        return readFromXML(new File(path));
    }
}
