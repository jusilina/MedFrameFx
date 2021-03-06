package med.view;

import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;
import javafx.util.Callback;
import med.Main;
import med.PropertyNames;
import med.model.PrescriptionDrug;
import med.model.Properties;
import med.model.Visit;
import med.util.FilePrinter;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.CheckModel;

import java.awt.print.*;
import java.io.File;
import java.time.LocalDate;
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
    @FXML
    private HBox pReflexesBox;
    @FXML
    private ToggleButton pReflexesButton;
    @FXML
    private GridPane pReflexesLegPane;
    @FXML
    private GridPane pReflexesHandPane;
    @FXML
    private TextArea diagnosisTextArea;
    @FXML
    private GridPane aReflexesPane;
    @FXML
    private ComboBox gaitBox;
    @FXML
    private RadioButton motionTypeActiveRadioButton;
    @FXML
    private RadioButton motionTypePassiveRadioButton;
    @FXML
    private GridPane motionPane;
    @FXML
    private GridPane musclePane;
    @FXML
    private RadioButton s_l_n_coord;
    @FXML
    private RadioButton s_m_n_coord;
    @FXML
    private RadioButton s_e_n_coord;
    @FXML
    private RadioButton d_l_s_coord;
    @FXML
    private RadioButton d_m_s_coord;
    @FXML
    private RadioButton d_e_s_coord;
    @FXML
    private ToggleButton coordinationButton;
    @FXML
    private GridPane coordinationPane;
    @FXML
    private VBox coordinationVBox;
    @FXML
    private GridPane rombergPane;
    @FXML
    private GridPane nervousSystemPane;
    @FXML
    private GridPane pelvicOrganPane;
    @FXML
    private TextField pelvicOrganField;
    @FXML
    private GridPane recommendationPane;
    @FXML
    private TextArea recommendationArea;
    @FXML
    private GridPane therapyPane;
    @FXML
    private ListView drugsListView;
    @FXML
    private Button addDrugButton;
    @FXML
    private Button editDrugButton;
    @FXML
    private ToggleButton workCapacityButton;
    @FXML
    private DatePicker workCapacityToDatePicker;
    @FXML
    private DatePicker workCapacityFromDatePicker;
    @FXML
    private DatePicker appearanceDatePicker;
    @FXML
    private HBox workCapacityHBox;


    private CheckComboBox<String> complaintCheckComboBox;
    private CheckComboBox<String> emotionCheckComboBox;
    private CheckComboBox<String> dreamCheckComboBox;
    private CheckComboBox<String> cranicalNerveBox;
    private CheckComboBox<String> sensitivityDisbalanceBox;
    private CheckComboBox<String> nervousTensionBox;
    private CheckComboBox<String> pReflexesHandBox;
    private CheckComboBox<String> pReflexesLegBox;
    private CheckComboBox<String> aReflexesBox;
    private CheckComboBox<String> motionBox;
    private CheckComboBox<String> muscleBox;
    private CheckComboBox<String> rombergBox;
    private CheckComboBox<String> coordinationTestBox;
    private CheckComboBox<String> nervousSystemBox;
    private CheckComboBox<String> pelvicOrganBox;
    private CheckComboBox<String> recommendationBox;
    private CheckComboBox<String> therapyBox;

    private PrescriptionDrug selectedDrug;

    public RootController() {
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
        //TODO add binding
        //  date.setValue(visit.getDate());
        Bindings.bindBidirectional(date.valueProperty(), visit.getLocalDateProperty());

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
        Bindings.bindBidirectional(diagnosisTextArea.textProperty(), visit.diagnosisProperty());

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

        CheckModel prhCheckModel = pReflexesHandBox.getCheckModel();
        prhCheckModel.clearChecks();
        if (!visit.getpReflexesHand().isEmpty()) {
            pReflexesButton.setSelected(true);
            visit.getpReflexesHand().forEach(s -> prhCheckModel.check(s));
        } else if (visit.getpReflexesLeg().isEmpty()) {
            pReflexesButton.setSelected(false);
        }

        prhCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getpReflexesHand().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getpReflexesHand().removeAll(changed.getRemoved());
            }
        });

        CheckModel prlCheckModel = pReflexesLegBox.getCheckModel();
        prlCheckModel.clearChecks();
        if (!visit.getpReflexesLeg().isEmpty()) {
            pReflexesButton.setSelected(true);
            visit.getpReflexesLeg().forEach(s -> prlCheckModel.check(s));
        } else if (visit.getpReflexesHand().isEmpty()) {
            pReflexesButton.setSelected(false);
        }

        prlCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getpReflexesLeg().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getpReflexesLeg().removeAll(changed.getRemoved());
            }
        });

        CheckModel aCheckModel = aReflexesBox.getCheckModel();
        aCheckModel.clearChecks();
        if (!visit.getaReflexes().isEmpty()) {
            visit.getaReflexes().forEach(s -> aCheckModel.check(s));
        }

        aCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getaReflexes().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getaReflexes().removeAll(changed.getRemoved());
            }
        });

        Bindings.bindBidirectional(gaitBox.valueProperty(), visit.gaitProperty());

        ToggleGroup motionTypeGroup = new ToggleGroup();
        motionTypeGroup.getToggles().addAll(motionTypeActiveRadioButton, motionTypePassiveRadioButton);

        motionTypeGroup.selectedToggleProperty().addListener(observable -> {
                    if (null != motionTypeGroup.getSelectedToggle())
                        visit.setMotionType(motionTypeGroup.getSelectedToggle().getUserData().toString());
                }
        );
        String motionTypeString = visit.getMotionType();
        motionTypeGroup.getToggles().forEach(toggle -> {
            if (toggle.getUserData().equals(motionTypeString)) {
                motionTypeGroup.selectToggle(toggle);
            }
        });

        CheckModel moCheckModel = motionBox.getCheckModel();
        moCheckModel.clearChecks();
        if (!visit.getMotion().isEmpty()) {
            visit.getMotion().forEach(s -> moCheckModel.check(s));
        }

        moCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getMotion().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getMotion().removeAll(changed.getRemoved());
            }
        });

        CheckModel muCheckModel = muscleBox.getCheckModel();
        muCheckModel.clearChecks();
        if (!visit.getMuscle().isEmpty()) {
            visit.getMuscle().forEach(s -> muCheckModel.check(s));
        }

        muCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getMuscle().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getMuscle().removeAll(changed.getRemoved());
            }
        });


        ToggleGroup dsCoordinationGroup = new ToggleGroup();
        ToggleGroup snCoordinationGroup = new ToggleGroup();

        dsCoordinationGroup.getToggles().addAll(d_e_s_coord, d_l_s_coord, d_m_s_coord);
        snCoordinationGroup.getToggles().addAll(s_e_n_coord, s_l_n_coord, s_m_n_coord);

        dsCoordinationGroup.selectedToggleProperty().addListener(observable -> {
                    if (null != dsCoordinationGroup.getSelectedToggle())
                        visit.setDsCoordination(dsCoordinationGroup.getSelectedToggle().getUserData().toString());
                }
        );

        snCoordinationGroup.selectedToggleProperty().addListener(observable -> {
                    if (null != snCoordinationGroup.getSelectedToggle())
                        visit.setSnCoordination(snCoordinationGroup.getSelectedToggle().getUserData().toString());
                }
        );

        String dsCoord = visit.getDsCoordination();
        dsCoordinationGroup.getToggles().forEach(toggle -> {
            if (toggle.getUserData().equals(dsCoord)) {
                dsCoordinationGroup.selectToggle(toggle);
            }
        });

        String snCoord = visit.getSnCoordination();
        snCoordinationGroup.getToggles().forEach(toggle -> {
            if (toggle.getUserData().equals(snCoord)) {
                snCoordinationGroup.selectToggle(toggle);
            }
        });

        CheckModel roCheckModel = rombergBox.getCheckModel();
        roCheckModel.clearChecks();
        if (!visit.getRomberg().isEmpty()) {
            coordinationButton.setSelected(true);
            visit.getRomberg().forEach(s -> roCheckModel.check(s));
        } else if (visit.getCoordinationTest().isEmpty()) {
            coordinationButton.setSelected(false);
        }

        roCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getRomberg().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getRomberg().removeAll(changed.getRemoved());
            }
        });

        CheckModel coCheckModel = coordinationTestBox.getCheckModel();
        coCheckModel.clearChecks();
        if (!visit.getCoordinationTest().isEmpty()) {
            coordinationButton.setSelected(true);
            visit.getCoordinationTest().forEach(s -> coCheckModel.check(s));
        } else if (visit.getRomberg().isEmpty()) {
            coordinationButton.setSelected(false);
        }

        coCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getCoordinationTest().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getCoordinationTest().removeAll(changed.getRemoved());
            }
        });

        CheckModel nerSysCheckModel = nervousSystemBox.getCheckModel();
        nerSysCheckModel.clearChecks();
        if (!visit.getNervousSystem().isEmpty()) {
            visit.getNervousSystem().forEach(s -> nerSysCheckModel.check(s));
        }

        nerSysCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getNervousSystem().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getNervousSystem().removeAll(changed.getRemoved());
            }
        });

        CheckModel peCheckModel = pelvicOrganBox.getCheckModel();
        peCheckModel.clearChecks();
        if (!visit.getPelvicOrganList().isEmpty()) {
            visit.getPelvicOrganList().forEach(s -> peCheckModel.check(s));
        }

        peCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getPelvicOrganList().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getPelvicOrganList().removeAll(changed.getRemoved());
            }
        });

        Bindings.bindBidirectional(pelvicOrganField.textProperty(), visit.pelvicOrganProperty());
        Bindings.bindBidirectional(recommendationArea.textProperty(), visit.recommendationsAddProperty());

        CheckModel reCheckModel = recommendationBox.getCheckModel();
        reCheckModel.clearChecks();
        if (!visit.getRecommendations().isEmpty()) {
            visit.getRecommendations().forEach(s -> reCheckModel.check(s));
        }

        reCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getRecommendations().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getRecommendations().removeAll(changed.getRemoved());
            }
        });

        CheckModel thCheckModel = therapyBox.getCheckModel();
        thCheckModel.clearChecks();
        if (!visit.getTherapy().isEmpty()) {
            visit.getTherapy().forEach(s -> thCheckModel.check(s));
        }

        thCheckModel.getCheckedItems().addListener((ListChangeListener) changed -> {
            while (changed.next()) {
                if (changed.wasAdded()) visit.getTherapy().addAll(changed.getAddedSubList());
                else if (changed.wasRemoved()) visit.getTherapy().removeAll(changed.getRemoved());
            }
        });
        //TODO
        Bindings.bindContentBidirectional(drugsListView.getItems(), visit.getDrugs());
        Bindings.bindBidirectional(workCapacityFromDatePicker.valueProperty(), visit.workCapacityFromDateProperty());
        Bindings.bindBidirectional(workCapacityToDatePicker.valueProperty(), visit.workCapacityToDateProperty());
        Bindings.bindBidirectional(appearanceDatePicker.valueProperty(), visit.appearanceDateProperty());


        log.info("set visit");
    }

    @FXML
    private void initialize() {
        //showVisitDetails();
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
                professionField.clear();
                stressComboBox.getSelectionModel().clearSelection();
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

        pReflexesButton.setSelected(false);
        pReflexesBox.setVisible(false);
        pReflexesButton.setText(PropertyNames.NO);
        pReflexesButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            log.info("pReflexesButton listener: " + newValue);
            if (newValue) {
                pReflexesButton.setText(PropertyNames.THESE_IS);
                pReflexesBox.setVisible(true);
            } else {
                pReflexesButton.setText(PropertyNames.NO);
                pReflexesBox.setVisible(false);
                pReflexesLegBox.getCheckModel().clearChecks();
                pReflexesHandBox.getCheckModel().clearChecks();
            }
        });
        // pReflexesBox.

        pReflexesHandBox = new CheckComboBox<>();
        pReflexesHandPane.add(pReflexesHandBox, 0, 0);

        pReflexesLegBox = new CheckComboBox<>();
        pReflexesLegPane.add(pReflexesLegBox, 0, 0);

        aReflexesBox = new CheckComboBox<>();
        aReflexesPane.add(aReflexesBox, 0, 0);


        categoryBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            diagnosisTextArea.setText(properties.getCategories().get(newValue).getDiagnosis());
            visit.getDrugs().clear();
            editDrugButton.setVisible(false);
            // properties.getCategories().forEach(category -> {
            //if (category.getName().equals(newValue)) {
            //   diagnosisTextArea.setText(category.getDiagnosis());

            // }
            //   });
        });

        motionBox = new CheckComboBox<>();
        motionPane.add(motionBox, 0, 0);
        muscleBox = new CheckComboBox<>();
        musclePane.add(muscleBox, 0, 0);

        gaitBox.getItems().addAll(PropertyNames.N, PropertyNames.ANTALGIC);
        motionTypeActiveRadioButton.setUserData(PropertyNames.ACTIVE);
        motionTypePassiveRadioButton.setUserData(PropertyNames.PASSIVE);

        rombergBox = new CheckComboBox<>();
        rombergPane.add(rombergBox, 0, 0);
        coordinationTestBox = new CheckComboBox<>();
        coordinationPane.add(coordinationTestBox, 0, 0);

        coordinationButton.setSelected(false);
        coordinationVBox.setVisible(false);
        coordinationVBox.setManaged(false);
        coordinationButton.setText(PropertyNames.NORM);
        coordinationButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            log.info("coordinationButton listener: " + newValue);
            if (newValue) {
                coordinationButton.setText(PropertyNames.DISTURBED);
                coordinationVBox.setVisible(true);
                coordinationVBox.setManaged(true);
            } else {
                coordinationButton.setText(PropertyNames.NORM);
                coordinationVBox.setVisible(false);
                coordinationVBox.setManaged(false);
                rombergBox.getCheckModel().clearChecks();
                coordinationTestBox.getCheckModel().clearChecks();
            }
        });

        s_e_n_coord.setUserData("S=N");
        s_l_n_coord.setUserData("S<N");
        s_m_n_coord.setUserData("S>N");
        d_e_s_coord.setUserData("D=S");
        d_l_s_coord.setUserData("D<S");
        d_m_s_coord.setUserData("D>S");

        nervousSystemBox = new CheckComboBox<>();
        nervousSystemPane.add(nervousSystemBox, 0, 0);

        pelvicOrganBox = new CheckComboBox<>();
        pelvicOrganPane.add(pelvicOrganBox, 0, 0);

        recommendationBox = new CheckComboBox<>();
        recommendationPane.add(recommendationBox, 0, 0);

        therapyBox = new CheckComboBox<>();
        therapyPane.add(therapyBox, 0, 0);

        drugsListView.setCellFactory(new Callback<ListView<PrescriptionDrug>, ListCell<PrescriptionDrug>>() {
            @Override
            public ListCell<PrescriptionDrug> call(ListView<PrescriptionDrug> p) {
                ListCell<PrescriptionDrug> cell = new ListCell<PrescriptionDrug>() {
                    @Override
                    protected void updateItem(PrescriptionDrug drug, boolean bln) {
                        super.updateItem(drug, bln);
                        if (drug != null) {
                            setText(drug.getName() + ":" + drug.getDose());
                        }
                    }
                };
                return cell;
            }
        });

        editDrugButton.setVisible(false);
        drugsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) {
                selectedDrug = (PrescriptionDrug) newValue;
                editDrugButton.setVisible(true);
            }
        });


        workCapacityButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            log.info("workCapacityButton listener: " + newValue);
            if (newValue) {
                workCapacityButton.setText(PropertyNames.UNABLE_TO_WORK);
                workCapacityHBox.setVisible(true);
                workCapacityHBox.setManaged(true);
            } else {
                workCapacityButton.setText(PropertyNames.ABLE_TO_WORK);
                workCapacityHBox.setVisible(false);
                workCapacityHBox.setManaged(false);
                workCapacityToDatePicker.setValue(LocalDate.now());
                workCapacityFromDatePicker.setValue(LocalDate.now());
            }
        });
        workCapacityButton.setSelected(false);
        workCapacityButton.setText(PropertyNames.ABLE_TO_WORK);
        workCapacityHBox.setVisible(false);
        workCapacityHBox.setManaged(false);
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
        setVisit(mainApp.getNewVisit());
        //  mainApp.getVisit().clear();
        setDefaultValue();
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
        //fillVisit();
        File personFile = mainApp.getVisitFilePath();
        if (personFile != null) {
            mainApp.saveVisitDataToFile(personFile);
        } else {
            handleSaveAs();
        }
    }

    private void fillVisit() {
        if (isInputValid()) {
            visit.setDate(date.getValue());
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
        //fillVisit();
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
        try {
            categoryBox.getItems().addAll(properties.getCategories().keySet());
            //  properties.getCategories()..forEach(category -> categoryBox.getItems().add(category.getName()));
            properties.getComplaints().forEach(complaint -> complaintCheckComboBox.getItems().add(complaint));

            properties.getEmotions().forEach(emotion -> emotionCheckComboBox.getItems().add(emotion));
            properties.getDisturbed_sleep().forEach(s -> dreamCheckComboBox.getItems().add(s));

            properties.getCranicalNerve().forEach(nerve -> cranicalNerveBox.getItems().add(nerve));
            properties.getSensitivityDisbalance().forEach(sens -> sensitivityDisbalanceBox.getItems().add(sens));

            properties.getNervousTension().forEach(tension -> nervousTensionBox.getItems().add(tension));

            upperLimbsBox.getItems().addAll(properties.getLimbReflexes());
            downLimbsBox.getItems().addAll(properties.getLimbReflexes());

            pReflexesHandBox.getItems().addAll(properties.getpReflexesHand());
            pReflexesLegBox.getItems().addAll(properties.getpReflexesLeg());

            aReflexesBox.getItems().addAll(properties.getaReflexes());

            motionBox.getItems().addAll(properties.getMotions());
            muscleBox.getItems().addAll(properties.getMuscleTones());

            rombergBox.getItems().addAll(properties.getRomberg());
            coordinationTestBox.getItems().addAll(properties.getCoordinationTest());

            nervousSystemBox.getItems().addAll(properties.getNervousSystem());
            pelvicOrganBox.getItems().addAll(properties.getPelvicOrganProblems());

            recommendationBox.getItems().addAll(properties.getRecommendations());
            therapyBox.getItems().addAll(properties.getTherapy());
        } catch (Exception e) {
            // log.finest(e.getStackTrace().toString());
            e.printStackTrace();
        }
    }

    @FXML
    private void handlePrint() {
        log.info("Printing....");
        PrinterJob job = PrinterJob.getPrinterJob();

        PageFormat pf = job.pageDialog(job.defaultPage());
        job.setPrintable(new FilePrinter(visit), pf);

        //Call print dialog
        boolean doPrint = job.printDialog();

        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
                log.finer(e.getStackTrace().toString());
            }
        }
    }

    @FXML
    public void handleAddDrug() {
        String category = visit.getCategory();
        if (null != category && !category.isEmpty())
            mainApp.showAddDrugDialog(properties.getCategories().get(category));
        else {
            log.finer("category is empty");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Внимание");
            alert.setContentText("Невозможно добавить лекарство. Категория не выбрана\n");
            alert.showAndWait();
        }

    }

    @FXML
    public void handleEditDrug() {
        String category = visit.getCategory();
        if (null != selectedDrug && null != category && !category.isEmpty())
            mainApp.showEditDrugDialog(properties.getCategories().get(category), selectedDrug);
        else {
            log.finer("category is empty");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Внимание");
            alert.setContentText("Редактируемое лекарство не выбрано");
            alert.showAndWait();
        }
        // drugsListView.getCellFactory().         log.info("handleEditDrug finished");
    }
}

