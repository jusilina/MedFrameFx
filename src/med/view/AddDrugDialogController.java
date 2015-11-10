package med.view;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import med.model.Category;
import med.model.Drug;
import med.model.PrescriptionDrug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddDrugDialogController {

    @FXML
    private ChoiceBox nameChoiceBox;
    @FXML
    private ChoiceBox doseChoiceBox;
    @FXML
    private TextArea additionalInfoArea;


    private Stage dialogStage;
    private Category category;
    private ObservableList drugsList;
    private boolean okClicked = false;
    private PrescriptionDrug drug;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        if (null == drug) {
            setDrug(new PrescriptionDrug());
        }
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
//    public void setPerson(Person person) {
//        this.person = person;
//
//        firstNameField.setText(person.getFirstName());
//        lastNameField.setText(person.getLastName());
//
//        birthdayField.setValue(person.getBirthday());
//      //  birthdayField.setPromptText("dd.mm.yyyy");
//    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            //  drug.setName(nameChoiceBox.getValue().toString());
            if (drugsList.contains(drug)) {
                drugsList.remove(drug);
            }
            drugsList.add(drug);


            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

   /*     if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }


        if (birthdayField.getValue() == null || DateUtil.format(birthdayField.getValue()).length() == 0) {
            errorMessage += "No valid birthday!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        } */
        return true;

    }

    public void setCategory(Category category) {
        this.category = category;
        //   nameChoiceBox.getItems().addAll(category.getDrugs().)
        ArrayList<Drug> drugs = category.getDrugs();
        drugs.forEach(d -> {
            nameChoiceBox.getItems().addAll(d.getName());
        });
        nameChoiceBox.valueProperty().addListener((observable, oldValue, newValue) ->
        {
            doseChoiceBox.getItems().clear();
            drugs.forEach(d -> {
                if (d.getName().equals(newValue) && null != d.getMark()) {
                    doseChoiceBox.getItems().addAll(d.getMark());
                }
            });
        });
    }

    public void setDrug(PrescriptionDrug drug) {
        this.drug = drug;
        Bindings.bindBidirectional(nameChoiceBox.valueProperty(), drug.nameProperty());
        Bindings.bindBidirectional(doseChoiceBox.valueProperty(), drug.doseProperty());
        Bindings.bindBidirectional(additionalInfoArea.textProperty(), drug.additionalInfoProperty());
    }

    public void setDrugsList(ObservableList drugsList) {
        this.drugsList = drugsList;
    }
}
