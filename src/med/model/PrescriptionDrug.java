package med.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Julia on 05.11.2015.
 */
public class PrescriptionDrug {
    private StringProperty dose;
    private StringProperty additionalInfo;
    private StringProperty name;

    public PrescriptionDrug() {
        dose = new SimpleStringProperty();
        additionalInfo = new SimpleStringProperty();
        name = new SimpleStringProperty();

    }

    public String getDose() {
        return (null != dose.get()) ? dose.get() : "";
    }

    public StringProperty doseProperty() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose.set(dose);
    }

    public String getAdditionalInfo() {
        return additionalInfo.get();
    }

    public StringProperty additionalInfoProperty() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo.set(additionalInfo);
    }

    public String getName() {
        return (null != name.get()) ? name.get() : "";
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
