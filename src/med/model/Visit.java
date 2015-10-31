package med.model;


import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import med.PropertyNames;
import med.util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "visit")
public class Visit implements PropertyNames {

    private StringProperty name;
    private ObjectProperty<LocalDate> date;
    private StringProperty complaint;
    private ObservableList<String> complaintList = FXCollections.observableArrayList();
    private StringProperty socialAnamnesis;
    private StringProperty profession;
    private StringProperty stress;
    private StringProperty anamnesis;
    private StringProperty conscious;
    private StringProperty consciousAdd;
    private StringProperty epileptic;
    private StringProperty category;
    private ObservableList<String> emotion = FXCollections.observableArrayList();
    private ObservableList<String> dream = FXCollections.observableArrayList();
    private ObservableList<String> cranicalNerve;
    private ObservableList<String> sensitivity;
    private ObservableList<String> nervousTension;
    private StringProperty upperLimbReflexes;
    private StringProperty downLimbReflexes;
    private StringProperty upperDSLimb;
    private StringProperty lowerDSLimb;
    private ObservableList<String> pReflexesHand;
    private ObservableList<String> pReflexesLeg;
    private ObservableList<String> aReflexes;
    private StringProperty diagnosis;
    private StringProperty gait;
    private ObservableList<String> motion;
    private StringProperty motionType;
    private ObservableList<String> muscle;

    public Visit() {
        initialise();
    }

    private void initialise() {
        this.name = new SimpleStringProperty();
        this.complaint = new SimpleStringProperty();
        this.date = new SimpleObjectProperty<>(LocalDate.now());

        socialAnamnesis = new SimpleStringProperty();
        profession = new SimpleStringProperty();
        stress = new SimpleStringProperty();
        anamnesis = new SimpleStringProperty();
        conscious = new SimpleStringProperty();
        consciousAdd = new SimpleStringProperty();
        epileptic = new SimpleStringProperty(NEG);

        category = new SimpleStringProperty();
        cranicalNerve = FXCollections.observableArrayList();
        sensitivity = FXCollections.observableArrayList();
        nervousTension = FXCollections.observableArrayList();
        upperLimbReflexes = new SimpleStringProperty();
        downLimbReflexes = new SimpleStringProperty();
        upperDSLimb = new SimpleStringProperty();
        lowerDSLimb = new SimpleStringProperty();
        pReflexesHand = FXCollections.observableArrayList();
        pReflexesLeg = FXCollections.observableArrayList();
        aReflexes = FXCollections.observableArrayList();
        diagnosis = new SimpleStringProperty();
        category = new SimpleStringProperty();
        gait = new SimpleStringProperty(N);
        motion = FXCollections.observableArrayList();
        muscle = FXCollections.observableArrayList();
        motionType = new SimpleStringProperty();
    }


    public String getName() {
        return name.get();
    }

    public StringProperty
    nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty getLocalDateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public String getComplaint() {
        return complaint.get();
    }

    public StringProperty complaintProperty() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint.set(complaint);
    }

    public ObservableList<String> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(ObservableList<String> complaintList) {
        this.complaintList = complaintList;
    }

    public String getSocialAnamnesis() {
        return socialAnamnesis.get();
    }

    public StringProperty socialAnamnesisProperty() {
        return socialAnamnesis;
    }

    public void setSocialAnamnesis(String socialAnamnesis) {
        this.socialAnamnesis.set(socialAnamnesis);
    }

    public String getProfession() {
        return profession.get();
    }

    public StringProperty professionProperty() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession.set(profession);
    }

    public String getStress() {
        return stress.get();
    }

    public StringProperty stressProperty() {
        return stress;
    }

    public void setStress(String stress) {
        this.stress.set(stress);
    }

    public String getAnamnesis() {
        return anamnesis.get();
    }

    public StringProperty anamnesisProperty() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis.set(anamnesis);
    }

    public String getConscious() {
        return conscious.get();
    }

    public StringProperty consciousProperty() {
        return conscious;
    }

    public void setConscious(String conscious) {
        this.conscious.set(conscious);
    }

    public String getConsciousAdd() {
        return consciousAdd.get();
    }

    public StringProperty consciousAddProperty() {
        return consciousAdd;
    }

    public void setConsciousAdd(String consciousAdd) {
        this.consciousAdd.set(consciousAdd);
    }

    public String getEpileptic() {
        return epileptic.get();
    }

    public StringProperty epilepticProperty() {
        return epileptic;
    }

    public void setEpileptic(String epileptic) {
        this.epileptic.set(epileptic);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public ObservableList<String> getEmotion() {
        return emotion;
    }

    public void setEmotion(ObservableList<String> emotion) {
        this.emotion = emotion;
    }

    public ObservableList<String> getDream() {
        return dream;
    }

    public void setDream(ObservableList<String> dream) {
        this.dream = dream;
    }

    public ObservableList<String> getCranicalNerve() {
        return cranicalNerve;
    }

    public void setCranicalNerve(ObservableList<String> cranicalNerve) {
        this.cranicalNerve = cranicalNerve;
    }

    public ObservableList<String> getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(ObservableList<String> sensitivity) {
        this.sensitivity = sensitivity;
    }

    public ObservableList<String> getNervousTension() {
        return nervousTension;
    }

    public void setNervousTension(ObservableList<String> nervousTension) {
        this.nervousTension = nervousTension;
    }

    public String getUpperLimbReflexes() {
        return upperLimbReflexes.get();
    }

    public StringProperty upperLimbReflexesProperty() {
        return upperLimbReflexes;
    }

    public void setUpperLimbReflexes(String upperLimbReflexes) {
        this.upperLimbReflexes.set(upperLimbReflexes);
    }

    public String getDownLimbReflexes() {
        return downLimbReflexes.get();
    }

    public StringProperty downLimbReflexesProperty() {
        return downLimbReflexes;
    }

    public void setDownLimbReflexes(String downLimbReflexes) {
        this.downLimbReflexes.set(downLimbReflexes);
    }

    public String getUpperDSLimb() {
        return upperDSLimb.get();
    }

    public StringProperty upperDSLimbProperty() {
        return upperDSLimb;
    }

    public void setUpperDSLimb(String upperDSLimb) {
        this.upperDSLimb.set(upperDSLimb);
    }

    public String getLowerDSLimb() {
        return lowerDSLimb.get();
    }

    public StringProperty lowerDSLimbProperty() {
        return lowerDSLimb;
    }

    public void setLowerDSLimb(String lowerDSLimb) {
        this.lowerDSLimb.set(lowerDSLimb);
    }

    public ObservableList<String> getpReflexesHand() {
        return pReflexesHand;
    }

    public void setpReflexesHand(ObservableList<String> pReflexesHand) {
        this.pReflexesHand = pReflexesHand;
    }

    public ObservableList<String> getpReflexesLeg() {
        return pReflexesLeg;
    }

    public void setpReflexesLeg(ObservableList<String> pReflexesLeg) {
        this.pReflexesLeg = pReflexesLeg;
    }

    public ObservableList<String> getaReflexes() {
        return aReflexes;
    }

    public void setaReflexes(ObservableList<String> aReflexes) {
        this.aReflexes = aReflexes;
    }

    public String getDiagnosis() {
        return diagnosis.get();
    }

    public StringProperty diagnosisProperty() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis.set(diagnosis);
    }

    public String getGait() {
        return gait.get();
    }

    public StringProperty gaitProperty() {
        return gait;
    }

    public void setGait(String gait) {
        this.gait.set(gait);
    }

    public ObservableList<String> getMotion() {
        return motion;
    }

    public void setMotion(ObservableList<String> motion) {
        this.motion = motion;
    }

    public String getMotionType() {
        return motionType.get();
    }

    public StringProperty motionTypeProperty() {
        return motionType;
    }

    public void setMotionType(String motionType) {
        this.motionType.set(motionType);
    }

    public ObservableList<String> getMuscle() {
        return muscle;
    }

    public void setMuscle(ObservableList<String> muscle) {
        this.muscle = muscle;
    }

    public void clear() {
        initialise();
    }


    public void clone(Visit visit) {
        setName(visit.getName());
        setDate(visit.getDate());
        setComplaint(visit.getComplaint());
        setProfession(visit.getProfession());
        setSocialAnamnesis(visit.getSocialAnamnesis());
        setStress(visit.getStress());
        setComplaintList(visit.getComplaintList());
        setAnamnesis(visit.getAnamnesis());
        setConscious(visit.getConscious());
        setConsciousAdd(visit.getConsciousAdd());
        setEpileptic(visit.getEpileptic());
        setCategory(visit.getCategory());


    }
}
