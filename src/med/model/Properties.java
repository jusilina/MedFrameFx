package med.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parameters")
public class Properties {
    private List<Category> categories;
    private List<String> complaints;
    private List<String> emotions;
    private List<String> disturbed_sleep;
    private List<String> cranicalNerve;
    private List<String> sensitivityDisbalance;
    private List<String> nervousTension;
    private List<String> limbReflexes;
    private List<String> pReflexesHand;
    private List<String> pReflexesLeg;

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

    @XmlElement(name = "cranicalNerve")
    public List<String> getCranicalNerve() {
        return cranicalNerve;
    }

    public void setCranicalNerve(List<String> cranicalNerve) {
        this.cranicalNerve = cranicalNerve;
    }

    @XmlElement(name = "sensitivityDisbalance")
    public List<String> getSensitivityDisbalance() {
        return sensitivityDisbalance;
    }

    public void setSensitivityDisbalance(List<String> sensitivityDisbalance) {
        this.sensitivityDisbalance = sensitivityDisbalance;
    }

    @XmlElement(name = "nervousTension")
    public List<String> getNervousTension() {
        return nervousTension;
    }

    public void setNervousTension(List<String> nervousTension) {
        this.nervousTension = nervousTension;
    }

    @XmlElement(name = "limbReflexes")
    public List<String> getLimbReflexes() {
        return limbReflexes;
    }

    public void setLimbReflexes(List<String> limbReflexes) {
        this.limbReflexes = limbReflexes;
    }

    @XmlElement(name = "pReflexesHand")
    public List<String> getpReflexesHand() {
        return pReflexesHand;
    }

    public void setpReflexesHand(List<String> pReflexesHand) {
        this.pReflexesHand = pReflexesHand;
    }

    @XmlElement(name = "pReflexesLeg")
    public List<String> getpReflexesLeg() {
        return pReflexesLeg;
    }

    public void setpReflexesLeg(List<String> pReflexesLeg) {
        this.pReflexesLeg = pReflexesLeg;
    }
}
