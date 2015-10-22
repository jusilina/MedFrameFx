package med.view;

import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import med.Main;
import med.PropertyNames;
import med.model.Properties;
import med.model.Visit;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.CheckModel;

import java.io.File;
import java.util.logging.Logger;

public class RootController {
    private static Logger log = Logger.getLogger(RootController.class.getName());

    // Reference to the main application
    private Main mainApp;
    private Properties properties;

    private Visit visit;

    @FXML
    private TextField name;
    @FXML
    private DatePicker date;
    @FXML
    private TextArea complaint;
    @FXML
    private GridPane complaintPain;
    @FXML
    private ChoiceBox categoryBox;
    @FXML
    private ComboBox jobComboBox;
    @FXML
    private ComboBox stressComboBox;
    @FXML
    private TextField professionField;
    @FXML
    private Group professionGroup;
    @FXML
    private TextArea anamnesisArea;
    @FXML
    private ComboBox consciousBox;
    @FXML
    private TextField consciousText;
    @FXML
    private TextField epiText;
    @FXML
    private ComboBox emotionMainBox;
    @FXML
    private ComboBox dreamComboBox;
    @FXML
    private GridPane emotionPain;
    @FXML
    private GridPane dreamPain;
    @FXML
    private ComboBox sensitivityMainBox;
    @FXML
    private GridPane sensitivityPain;
    @FXML
    private GridPane cranicalNervePain;
    @FXML
    private ComboBox nervousTensionMainBox;
    @FXML
    private GridPane nervousTensionPain;
    @FXML
    private ComboBox upperLimbsBox;
    @FXML
    private ComboBox downLimbsBox;
    @FXML
    private RadioButton d_e_s_U;
    @FXML
    private RadioButton d_m_s_U;
    @FXML
    private RadioButton d_l_s_U;
    @FXML
    private RadioButton d_e_s_D;
    @FXML
    private RadioButton d_m_s_D;
    @FXML
    private RadioButton d_l_s_D;


    private CheckComboBox<String> complaintCheckComboBox;
    private CheckComboBox<String> emotionCheckComboBox;
    private CheckComboBox<String> dreamCheckComboBox;
    private CheckComboBox<String> cranicalNerveBox;
    private CheckComboBox<String> sensitivityDisbalanceBox;
    private CheckComboBox<String> nervousTensionBox;

    public RootController() {
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
        //TODO add binding
        date.setValue(visit.getDate());

        Bindings.bindBidirectional(name.textProperty(), visit.nameProperty());
        Bindings.bindBidirectional(complaint.textProperty(), visit.complaintProperty());
        Bindings.bindBidirectional(jobComboBox.valueProperty(), visit.socialAnamnesisProperty());
        Bindings.bindBidirectional(stressComboBox.valueProperty(), visit.stressProperty());
        Bindings.bindBidirectional(professionField.textProperty(), visit.professionProperty());

        Bindings.bindBidirectional(anamnesisArea.textProperty(), visit.anamnesisProperty());
        Bindings.bindBidirectional(consciousText.textProperty(), visit.consciousAddProperty());
        Bindings.bindBidirectional(epiText.textProperty(), visit.epilepticProperty());
        Bindings.bindBidirectional(consciousBox.valueProperty(), visit.consciousProperty());

        Bindings.bindBidirectional(categoryBox.valueProperty(), visit.categoryProperty());

        /**
         * Select items in complaint list. Add listener to populate visit.complaintList with selected items
         */
        ObservableList<String> selectedComplaintItems = complaintCheckComboBox.getCheckModel().getCheckedItems();
        complaintCheckComboBox.getCheckModel().clearChecks();
        if (!visit.getComplaintList().isEmpty()) {
            visit.getComplaintList().forEach(s -> complaintCheckComboBox.getCheckModel().check(s));
        }

        selectedComplaintItems.addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getComplaintList().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getComplaintList().removeAll(changed.getRemoved());
            }
        });


        emotionCheckComboBox.getCheckModel().clearChecks();
        if (!visit.getEmotion().isEmpty()) {
            emotionMainBox.getSelectionModel().select(PropertyNames.DISTURBED);
            visit.getEmotion().forEach(s -> emotionCheckComboBox.getCheckModel().check(s));
        } else {
            emotionMainBox.getSelectionModel().select(PropertyNames.NORM);
        }

        ObservableList<String> selectedEmotionItems = emotionCheckComboBox.getCheckModel().getCheckedItems();
        selectedEmotionItems.addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getEmotion().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getEmotion().removeAll(changed.getRemoved());
            }
        });

        dreamCheckComboBox.getCheckModel().clearChecks();
        if (!visit.getDream().isEmpty()) {
            dreamComboBox.getSelectionModel().select(PropertyNames.DISTURBED);
            visit.getDream().forEach(s -> dreamCheckComboBox.getCheckModel().check(s));
        } else {
            dreamComboBox.getSelectionModel().select(PropertyNames.NORM);
        }

        ObservableList<String> selectedDreamItems = dreamCheckComboBox.getCheckModel().getCheckedItems();
        selectedDreamItems.addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getDream().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getDream().removeAll(changed.getRemoved());
            }
        });


        CheckModel sensitivityDisbalanceBoxCheckModel = sensitivityDisbalanceBox.getCheckModel();
        sensitivityDisbalanceBoxCheckModel.clearChecks();
        if (!visit.getSensitivity().isEmpty()) {
            sensitivityMainBox.getSelectionModel().select(PropertyNames.DISTURBED);
            visit.getSensitivity().forEach(s -> sensitivityDisbalanceBoxCheckModel.check(s));
        } else {
            sensitivityMainBox.getSelectionModel().select(PropertyNames.NORM);
        }

        sensitivityDisbalanceBoxCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getSensitivity().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getSensitivity().removeAll(changed.getRemoved());
            }
        });

        cranicalNerveBox.getCheckModel().clearChecks();
        if (!visit.getCranicalNerve().isEmpty()) {
            visit.getCranicalNerve().forEach(s -> cranicalNerveBox.getCheckModel().check(s));
        }

        cranicalNerveBox.getCheckModel().getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getCranicalNerve().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getCranicalNerve().removeAll(changed.getRemoved());
            }
        });


        CheckModel neCheckModel = nervousTensionBox.getCheckModel();
        neCheckModel.clearChecks();
        if (!visit.getNervousTension().isEmpty()) {
            nervousTensionMainBox.getSelectionModel().select(PropertyNames.THESE_IS);
            visit.getNervousTension().forEach(s -> neCheckModel.check(s));
        } else {
            nervousTensionMainBox.getSelectionModel().select(PropertyNames.NO);
        }

        neCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getNervousTension().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getNervousTension().removeAll(changed.getRemoved());
            }
        });

        Bindings.bindBidirectional(upperLimbsBox.valueProperty(), visit.upperLimbReflexesProperty());
        Bindings.bindBidirectional(downLimbsBox.valueProperty(), visit.downLimbReflexesProperty());

        ToggleGroup upperDSLimbsGroup = new ToggleGroup();
        ToggleGroup downDSLimbsGroup = new ToggleGroup();

        upperDSLimbsGroup.getToggles().addAll(d_e_s_U, d_l_s_U, d_m_s_U);
        downDSLimbsGroup.getToggles().addAll(d_e_s_D, d_l_s_D, d_m_s_D);

        upperDSLimbsGroup.selectedToggleProperty().addListener(observable -> {
                    if (null != upperDSLimbsGroup.getSelectedToggle())
                        visit.setUpperDSLimb(upperDSLimbsGroup.getSelectedToggle().getUserData().toString());
                }
        );

        downDSLimbsGroup.selectedToggleProperty().addListener(observable -> {
                    if (null != downDSLimbsGroup.getSelectedToggle())
                        visit.setLowerDSLimb(downDSLimbsGroup.getSelectedToggle().getUserData().toString());
                }
        );

        String upperDSLimb = visit.getUpperDSLimb();
        upperDSLimbsGroup.getToggles().forEach(toggle -> {
            if (toggle.getUserData().equals(upperDSLimb)) {
                upperDSLimbsGroup.selectToggle(toggle);
            }
        });

        String downDSLimb = visit.getLowerDSLimb();
        downDSLimbsGroup.getToggles().forEach(toggle -> {
            if (toggle.getUserData().equals(downDSLimb)) {
                downDSLimbsGroup.selectToggle(toggle);
            }
        });


        log.info("set visit");
    }

    @FXML
    private void initialize() {
        showVisitDetails();
        log.info("initialise RootController");

        complaintCheckComboBox = new CheckComboBox<>();
        complaintPain.add(complaintCheckComboBox, 0, 0);

        emotionCheckComboBox = new CheckComboBox<>();
        emotionPain.add(emotionCheckComboBox, 0, 0);

        dreamCheckComboBox = new CheckComboBox<>();
        dreamPain.add(dreamCheckComboBox, 0, 0);


        jobComboBox.getItems().addAll(PropertyNames.WORKING, PropertyNames.NOT_WORKING, PropertyNames.PENSIONER, PropertyNames.CRIPPLE);
        stressComboBox.getItems().addAll(PropertyNames.EXERCISE_STRESS, PropertyNames.STATIC_LOAD);


        jobComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(PropertyNames.WORKING)) {
                professionGroup.setVisible(true);
            } else {
                professionGroup.setVisible(false);
            }
        });

        consciousBox.getItems().addAll(PropertyNames.CONSCIOUS_CLEAR, PropertyNames.CONSCIOUS_OBNUBILATION);
        emotionMainBox.getItems().addAll(PropertyNames.NORM, PropertyNames.DISTURBED);
        dreamComboBox.getItems().addAll(PropertyNames.NORM, PropertyNames.DISTURBED);

        emotionMainBox.valueProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue.equals(PropertyNames.NORM)) {
                        emotionPain.setVisible(false);
                        emotionCheckComboBox.getCheckModel().clearChecks();
                    } else {
                        emotionPain.setVisible(true);
                    }
                }
        );

        dreamComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue.equals(PropertyNames.NORM)) {
                        dreamPain.setVisible(false);
                        dreamCheckComboBox.getCheckModel().clearChecks();
                    } else {
                        dreamPain.setVisible(true);
                    }
                }
        );

        cranicalNerveBox = new CheckComboBox<>();
        cranicalNervePain.add(cranicalNerveBox, 0, 0);

        sensitivityDisbalanceBox = new CheckComboBox<>();
        sensitivityPain.add(sensitivityDisbalanceBox, 0, 0);
        sensitivityMainBox.getItems().addAll(PropertyNames.NORM, PropertyNames.DISTURBED);

        sensitivityMainBox.valueProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue.equals(PropertyNames.NORM)) {
                        sensitivityPain.setVisible(false);
                        sensitivityDisbalanceBox.getCheckModel().clearChecks();
                    } else {
                        sensitivityPain.setVisible(true);
                    }
                }
        );

        nervousTensionBox = new CheckComboBox<>();
        nervousTensionPain.add(nervousTensionBox, 0, 0);
        nervousTensionMainBox.getItems().addAll(PropertyNames.NO, PropertyNames.THESE_IS);
        nervousTensionMainBox.valueProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue.equals(PropertyNames.NO)) {
                        nervousTensionPain.setVisible(false);
                        nervousTensionBox.getCheckModel().clearChecks();
                    } else {
                        nervousTensionPain.setVisible(true);
                    }
                }
        );


        d_e_s_U.setUserData("D=S");
        d_e_s_U.setSelected(true);
        d_l_s_U.setUserData("D<S");
        d_m_s_U.setUserData("D>S");

        d_e_s_D.setUserData("D=S");
        d_e_s_D.setSelected(true);
        d_l_s_D.setUserData("D<S");
        d_m_s_D.setUserData("D>S");
        setDefaultValue();
    }


    private void setDefaultValue() {
        emotionMainBox.getSelectionModel().select(PropertyNames.NORM);
        dreamComboBox.getSelectionModel().select(PropertyNames.NORM);
        sensitivityMainBox.getSelectionModel().select(PropertyNames.NORM);
        nervousTensionMainBox.getSelectionModel().select(PropertyNames.NO);
    }

    private void showVisitDetails() {
        if (visit != null) {
            //     name.setText(visit.getName());
            date.setValue(visit.getDate());
            //       complaint.setText(visit.getComplaint());
        } else {

        }
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleNew() {
        mainApp.getVisit().clear();
        mainApp.setVisitFilePath(null);
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadVisitDataFromFile(file);
        }
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {
        fillVisit();
        File personFile = mainApp.getVisitFilePath();
        if (personFile != null) {
            mainApp.saveVisitDataToFile(personFile);
        } else {
            handleSaveAs();
        }
    }

    private void fillVisit() {
        if (isInputValid()) {
            //    visit.setName(name.getText());
            visit.setDate(date.getValue());
            //     visit.setComplaint(complaint.getText());
        }
    }

    private boolean isInputValid() {
        return true;
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        fillVisit();
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            //TODO
            mainApp.saveVisitDataToFile(file);
        }
    }

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.showAndWait();

    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        mainApp.setVisitFilePath(null);
        System.exit(0);
    }

    public void setProperties(Properties props) {
        this.properties = props;

        properties.getCategories().forEach(category -> categoryBox.getItems().add(category.getName()));
        properties.getComplaints().forEach(complaint -> complaintCheckComboBox.getItems().add(complaint));

        properties.getEmotions().forEach(emotion -> emotionCheckComboBox.getItems().add(emotion));
        properties.getDisturbed_sleep().forEach(s -> dreamCheckComboBox.getItems().add(s));

        properties.getCranicalNerve().forEach(nerve -> cranicalNerveBox.getItems().add(nerve));
        properties.getSensitivityDisbalance().forEach(sens -> sensitivityDisbalanceBox.getItems().add(sens));

        properties.getNervousTension().forEach(tension -> nervousTensionBox.getItems().add(tension));

        upperLimbsBox.getItems().addAll(properties.getLimbReflexes());
        downLimbsBox.getItems().addAll(properties.getLimbReflexes());
    }
}

