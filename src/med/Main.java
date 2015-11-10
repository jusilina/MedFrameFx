package med;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import med.model.Category;
import med.model.PrescriptionDrug;
import med.model.Properties;
import med.model.Visit;
import med.view.AddDrugDialogController;
import med.view.RootController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

public class Main extends Application {
    Logger logger = Logger.getLogger(Main.class.getName());
    private Stage primaryStage;
    //    private BorderPane rootLayout;
    private Properties properties;
    private RootController controller;


    private Visit visit = new Visit();

    public Visit getVisit() {
        return visit;
    }

    public Visit getNewVisit() {
        visit = new Visit();
        return visit;
    }

//    public void setVisit(Visit visit) {
//        this.visit = visit;
//    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Medicine");
        this.primaryStage.getIcons().add(new Image("file:resources/nervnie_volokna.jpg"));
        loadPropertiesFromFile();

        initRootLayout();

        //    showVisitLayout();


//            try {
//                JAXBContext context = JAXBContext
//                        .newInstance(Properties.class);
//                Marshaller m = context.createMarshaller();
//                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//                Properties p = new Properties();
//                Category cat = new Category("test category");
//                cat.setDiagnosis("diagnose");
//                p.setCategories(new ArrayList<>());
//                p.getCategories().add(cat);
//
//                // Marshalling and saving XML to the file.
//                m.marshal(p, new File("test.xml"));
//
//            } catch (Exception e) { // catches ANY exception
//                e.printStackTrace();
//            }


    }

    /**
     * Shows the visit overview inside the root layout.
     */

//    private void showVisitLayout() {
//        try {
//            // Load person overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
//            AnchorPane personOverview = (AnchorPane) loader.load();
//
//            // Set person overview into the center of root layout.
//            rootLayout.setCenter(personOverview);
//
//            // Give the controller access to the main app.
//            VisitController controller = loader.getController();
//            controller.setMainApp(this);
//            controller.setVisit(visit);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
    private void initRootLayout() {

        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            controller = loader.getController();
            controller.setProperties(properties);
            controller.setMainApp(this);
            controller.setVisit(visit);


            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Try to load last opened person file.
//        File file = getVisitFilePath();
//        if (file != null) {
//            loadVisitDataFromFile(file);
//        }

    }


    /**
     * Returns the person file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     *
     * @return
     */
    public File getVisitFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setVisitFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("AddressApp");
        }
    }


    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Saves the current person data to the specified file.
     *
     * @param file
     */
    public void saveVisitDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(Visit.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshalling and saving XML to the file.
            m.marshal(visit, file);

            // Save the file path to the registry.
            setVisitFilePath(file);
        } catch (Exception e) { // catches ANY exception
            e.printStackTrace();
            logger.log(Level.ALL, e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Could not save data to file:\n" + file.getPath());
            alert.showAndWait();

        }

    }

    public void loadVisitDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(Visit.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            Visit visit = (Visit) um.unmarshal(file);
            controller.setVisit(visit);
            //  this.visit.clone(visit);
            // Save the file path to the registry.
            setVisitFilePath(file);

        } catch (Exception e) { // catches ANY exception
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Could not save data to file:\n" + file.getPath());
            alert.showAndWait();
        }
    }

    private void loadPropertiesFromFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Properties.class);
            Unmarshaller um = context.createUnmarshaller();
            properties = (Properties) um.unmarshal(new File("properties.xml"));
            System.out.println(properties.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean showAddDrugDialog(Category category) {
        try {
            logger.info("showAddDrugDialog for " + category.getName());
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/AddDrugsDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Добавить лекарство");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AddDrugDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCategory(category);
            controller.setDrugsList(visit.getDrugs());

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean showEditDrugDialog(Category category, PrescriptionDrug drug) {
        try {
            logger.info("showEditDrugDialog for " + drug.getName());
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/AddDrugsDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Изменить лекарство");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AddDrugDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCategory(category);
            controller.setDrug(drug);
            controller.setDrugsList(visit.getDrugs());

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
