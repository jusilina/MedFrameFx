package med.view;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import med.Main;
import med.PropertyNames;
import med.model.Properties;
import med.model.Visit;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.dialog.Dialogs;

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



    private CheckComboBox<String> complaintCheckComboBox;

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
        if (!visit.getComplaintList().isEmpty()) {
            complaintCheckComboBox.getCheckModel().clearChecks();
            visit.getComplaintList().forEach(s ->  complaintCheckComboBox.getCheckModel().check(s));
        }

        selectedComplaintItems.addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getComplaintList().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getComplaintList().removeAll(changed.getRemoved());
            }
        });


        log.info("set visit");
    }

    @FXML
    private void initialize() {
        showVisitDetails();
        log.info("initialise RootController");

        complaintCheckComboBox = new CheckComboBox<String>();
        complaintPain.add(complaintCheckComboBox, 0, 0);

        jobComboBox.getItems().addAll(PropertyNames.WORKING, PropertyNames.NOT_WORKING, PropertyNames.PENSIONER, PropertyNames.CRIPPLE);
        stressComboBox.getItems().addAll(PropertyNames.EXERCISE_STRESS, PropertyNames.STATIC_LOAD);


        jobComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(PropertyNames.WORKING)) {
                professionGroup.setVisible(true);
            } else {
                professionGroup.setVisible(false);
            }
        });
        // and listen to the relevant events (e.g. when the selected indices or
        // selected items change).
//        checkComboBox.getCheckModel().getSelectedItems().addListener(new ListChangeListener<String>() {
//            public void onChanged(ListChangeListener.Change<? extends String> c) {
//                System.out.println(checkComboBox.getCheckModel().getSelectedItems());
//            }
//        });


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
        Dialogs.create()
                .title("AddressApp")
                .masthead("About")
                .message("Author: Marco Jakob\nWebsite: http://code.makery.ch")
                .showInformation();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    public void setProperties(Properties props) {
        this.properties = props;

        properties.getCategories().forEach(category -> categoryBox.getItems().add(category.getName()));
        properties.getComplaints().forEach(complaint -> complaintCheckComboBox.getItems().add(complaint));
    }
}

