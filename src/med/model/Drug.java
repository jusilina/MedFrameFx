/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package med.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julia
 */
public class Drug
{
    String name;
    List mark = new ArrayList();
    public Drug()
    {} 

    public Drug(String drugName)
    {
//        this();
        this.name = drugName;
        
    
    }
        

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List getMark()
    {
        return mark;
    }

    public void setMark(List mark)
    {
        this.mark = mark;
    }
    

    
    
     
}
