package med.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Julia on 05.11.2015.
 */
public class Categories {
    @XmlElement(name = "category")
    public ArrayList<Category> category;

//    public List<Category> getCategory() {
//        return Collections.unmodifiableList(category);
//    }
//
//    public void addCategory(Category entry) {
//        category.add(entry);
//    }
}
