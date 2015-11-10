package med.util;

import med.model.Categories;
import med.model.Category;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapAdapter extends XmlAdapter<Categories, Map<String, Category>> {

    @Override
    public Map<String, Category> unmarshal(Categories categories) throws Exception {
        System.out.println("unmarshal");

        Map<String, Category> map = new HashMap<String, Category>();
        for (Category cat : categories.category) {
            map.put(cat.getName(), cat);
        }
        return map;
    }

    @Override
    public Categories marshal(Map<String, Category> map) throws Exception {
        System.out.println("marshal");
        Categories categories = new Categories();
        Collection<Category> cat = map.values();
        categories.category = new ArrayList<>(cat);

        return categories;
    }
}
