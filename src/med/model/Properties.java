package med.model;

import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 08.10.2015.
 */
@XmlRootElement(name = "parameters")
public class Properties {
    private List<Category> categories;
    private List<String> complaints;
    private List<String> emotions;
    private List<String> disturbed_sleep;

    @XmlElement(name = "category")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @XmlElement(name = "complaint")
    public List<String> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<String> complaints) {
        this.complaints = complaints;
    }

    @XmlElement(name = "emotion")
    public List<String> getEmotions() {
        return emotions;
    }

    public void setEmotions(List<String> emotions) {
        this.emotions = emotions;
    }

    @XmlElement(name = "disturbed_sleep")
    public List<String> getDisturbed_sleep() {
        return disturbed_sleep;
    }

    public void setDisturbed_sleep(List<String> disturbed_sleep) {
        this.disturbed_sleep = disturbed_sleep;
    }
}
