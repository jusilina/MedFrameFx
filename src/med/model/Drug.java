/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package med.model;

import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Julia
 */
public class Drug {
    String name;
    private List<String> mark;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "mark")
    public List<String> getMark() {
        return mark;
    }

    public void setMark(List<String> mark) {
        this.mark = mark;
    }


}
