//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.28 at 11:24:42 PM CET 
//


package es.uvigo.esei.testshuffler.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for complexity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="complexity">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="low"/>
 *     &lt;enumeration value="low-medium"/>
 *     &lt;enumeration value="medium"/>
 *     &lt;enumeration value="medium-high"/>
 *     &lt;enumeration value="high"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "complexity")
@XmlEnum
public enum Complexity {

    @XmlEnumValue("low")
    LOW("low"),
    @XmlEnumValue("low-medium")
    LOW_MEDIUM("low-medium"),
    @XmlEnumValue("medium")
    MEDIUM("medium"),
    @XmlEnumValue("medium-high")
    MEDIUM_HIGH("medium-high"),
    @XmlEnumValue("high")
    HIGH("high");
    private final String value;

    Complexity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Complexity fromValue(String v) {
        for (Complexity c: Complexity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
