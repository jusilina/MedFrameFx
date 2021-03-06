package med.model;

import med.util.MapAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "parameters")
public class Properties {
    @XmlElement
    @XmlJavaTypeAdapter(MapAdapter.class)
    private Map<String, Category> categories;
    private List<String> complaints;
    private List<String> emotions;
    private List<String> disturbed_sleep;
    private List<String> cranicalNerve;
    private List<String> sensitivityDisbalance;
    private List<String> nervousTension;
    private List<String> limbReflexes;
    private List<String> pReflexesHand;
    private List<String> pReflexesLeg;
    private List<String> aReflexes;
    private List<String> muscleTones;
    private List<String> motions;
    private List<String> romberg;
    private List<String> coordinationTest;
    private List<String> nervousSystem;
    private List<String> pelvicOrganProblems;
    private List<String> recommendations;
    private List<String> therapy;

    // @XmlElement(name = "category")

    public Map<String, Category> getCategories() {
        return categories;
    }

//    public void setCategories(Map<String,Category> categories) {
//        this.categories = categories;
//    }

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

    @XmlElement(name = "aReflexes")
    public List<String> getaReflexes() {
        return aReflexes;
    }

    public void setaReflexes(List<String> aReflexes) {
        this.aReflexes = aReflexes;
    }

    @XmlElement(name = "muscleTone")
    public List<String> getMuscleTones() {
        return muscleTones;
    }

    public void setMuscleTones(List<String> muscleTones) {
        this.muscleTones = muscleTones;
    }

    @XmlElement(name = "motion")
    public List<String> getMotions() {
        return motions;
    }

    public void setMotions(List<String> motions) {
        this.motions = motions;
    }

    @XmlElement(name = "rombergManeuver")
    public List<String> getRomberg() {
        return romberg;
    }

    public void setRomberg(List<String> romberg) {
        this.romberg = romberg;
    }

    @XmlElement(name = "coordinationTest")
    public List<String> getCoordinationTest() {
        return coordinationTest;
    }

    public void setCoordinationTest(List<String> coordinationTest) {
        this.coordinationTest = coordinationTest;
    }

    @XmlElement(name = "nervousSystem")
    public List<String> getNervousSystem() {
        return nervousSystem;
    }

    public void setNervousSystem(List<String> nervousSystem) {
        this.nervousSystem = nervousSystem;
    }

    @XmlElement(name = "pelvicOrgan")
    public List<String> getPelvicOrganProblems() {
        return pelvicOrganProblems;
    }

    public void setPelvicOrganProblems(List<String> pelvicOrganProblems) {
        this.pelvicOrganProblems = pelvicOrganProblems;
    }

    @XmlElement(name = "recommendation")
    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }

    @XmlElement(name = "therapy")
    public List<String> getTherapy() {
        return therapy;
    }

    public void setTherapy(List<String> therapy) {
        this.therapy = therapy;
    }
}
