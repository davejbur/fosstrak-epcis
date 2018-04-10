package org.fosstrak.epcis.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ActionType.
 * </p>
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * </p>
 * 
 * <pre>
 * &lt;simpleType name="ActionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ADD"/&gt;
 *     &lt;enumeration value="OBSERVE"/&gt;
 *     &lt;enumeration value="DELETE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ActionType", namespace = "urn:epcglobal:epcis:xsd:1")
@XmlEnum
public enum ActionType {

    ADD, OBSERVE, DELETE;

    public String value() {
        return name();
    }

    public static ActionType fromValue(String v) {
        return valueOf(v);
    }

}
