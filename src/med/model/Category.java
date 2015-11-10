package med.model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Julia
 */

public class Category
{

    String name;
    @XmlElement(name = "diagnosis")
    String diagnosis;
    @XmlElement(name = "drug")
    ArrayList<Drug> drugs = new ArrayList<>();

    @XmlAttribute
    public String getName()
    {
        return name;
    }

    public String getDiagnosis()
    {
        return diagnosis;
    }

//    public void setDiagnosis(String diagnosis) {
//        this.diagnosis = diagnosis;
//    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Category()
    {
        name = new String();
        diagnosis = new String();
    }


    public ArrayList<Drug> getDrugs()
    {
        return drugs;
    }

    //  public void setDrugs(ArrayList drugs)
//    {
//        this.drugs = drugs;
//    }
    
    public void addDrug(Drug drug)
    {
        // drugs.put(drug.name, drug);
    }


//    public void addDiagnosis(String diagnosis)
//    {
//        this.diagnosis = diagnosis;
//    }
    
}
