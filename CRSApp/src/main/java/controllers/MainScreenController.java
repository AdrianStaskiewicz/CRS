package controllers;

import context.ContextHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.WindowEvent;
import lombok.Getter;
import parameters.ViewPath;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    @FXML
    private MenuBar mainMenu;

    @FXML
    private Menu submenuModules;

    @FXML
    private Menu submenuServiceRequests;

    @FXML
    private MenuItem serviceRequestsMenuPosition;

    @FXML
    private Menu submenuFiles;

    @FXML
    private Menu submenuSystem;

    @FXML
    private Button startButton;

    @FXML
    private Button serviceRequestButton;

    @FXML
    private Button companyContext;
    @FXML
    private Button divisionContext;
    @FXML
    private Button employeeContext;

    @FXML
    private StackPane mainStackPane;

    private ContextHandler contextHandler;

    public void setView(GridPane gridPane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(gridPane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    void onServiceRequestsMenuPosition() {
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/ServiceRequestScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        loader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServiceRequestScreenController serviceRequestScreenController = innerLoader.getController();
//        set objects here

        serviceRequestScreenController.setMainScreenController(this);
        setView(gridPane);
    }

    public void onVehicleFileMenuPosition(){
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource(ViewPath.VEHICLE_FILES_SCREEN));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        loader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        VehicleFileScreenController controller = innerLoader.getController();
//        set objects here

        controller.setMainScreenController(this);
        setView(gridPane);
    }

    public void onCustomerFileMenuPosition(){
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource(ViewPath.CUSTOMER_FILES_SCREEN));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        loader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CustomerFileScreenController controller = innerLoader.getController();
        controller.setMainScreenController(this);
//        set objects here

        setView(gridPane);
    }

    @FXML
    public void onServiceRequestShortcut(){
        onServiceRequestsMenuPosition();
    }
    @FXML
    public void onCustomerFileShortcut(){
        onCustomerFileMenuPosition();
    }
    @FXML
    public void onVehicleFileShortcut(){
        onVehicleFileMenuPosition();
    }
    @FXML
    void onCustomerFilesMenuPosition() {
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource(ViewPath.CUSTOMER_FILES_SCREEN));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        loader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CustomerFileScreenController controller = innerLoader.getController();//TO DO
//        set objects here

        controller.setMainScreenController(this);
        setView(gridPane);
    }

    @FXML
    void onVehicleFilesMenuPosition() {
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/VehicleFileScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        loader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
       VehicleFileScreenController controller = innerLoader.getController();
//        set objects here

        controller.setMainScreenController(this);
        setView(gridPane);
    }

    @FXML
    void onBackToStart() {
        mainStackPane.getChildren().clear();
    }

    private void navigateTo(String viewPath){
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource(viewPath));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        loader.setResources(bundle);

        GridPane gridPane = null;
        try {
            gridPane = innerLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ServiceRequestScreenController controller = innerLoader.getController();
        //        set objects here

        controller.setMainScreenController(this);
        setView(gridPane);
    }

    @FXML
    void onMerchandiseOrdersMenuPosition() {
    }

    @FXML
    public void onLogOut() {
        this.mainStackPane.getParent().getScene();
        FXMLLoader innerLoader = new FXMLLoader();
        innerLoader.setLocation(this.getClass().getResource("/views/LoginScreen.fxml"));
//        ResourceBundle bundle = ResourceBundle.getBundle("gui.resources.lang");
//        innerLoader.setResources(bundle);

        try {
            Parent innerRoot = innerLoader.load();
            LoginScreenController controller = innerLoader.getController();
//        set objects here

            Scene scene=this.mainStackPane.getParent().getScene();
            controller.setScene(scene);
            scene.setRoot(innerRoot);
//            stage.setScene(scene);
//            stage.setMaximized(true);
//            stage.show();

//            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//                public void handle(WindowEvent we) {
//                    System.out.println("Stage is closing");
//                    checkConnection = Boolean.FALSE;
//                }
//            });


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setContextView(String context, String company, String employee){
        companyContext.setText(context);
        divisionContext.setText(company);
        employeeContext.setText(employee);
    }

}
