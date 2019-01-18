package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
    private StackPane mainStackPane;

    //    @FXML
//    private StackPane mainStackPane;
//    @Getter
//    private ClientPrim client;

    public void setView(GridPane gridPane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(gridPane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Image playI=new Image("icons/battery_icon.png");
//        ImageView iv1=new ImageView(playI);
//        iv1.setFitHeight(25);
//        iv1.setFitWidth(25);
//
//        button1.setGraphic(new ImageView(playI));
    }

    @FXML
    void onServiceRequestsMenuPosition() {
//        navigateTo(ViewPath.SERVICE_REQUEST_SCREEN);
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
//        loginScreenController.setMainScreenController(this);
//        loginScreenController.setLocalDatabase(this.localDatabase);
//        loginScreenController.setClient(this.client);

        serviceRequestScreenController.setMainScreenController(this);
        setView(gridPane);
    }

    public void onVehicleFileMenuPosition(){
        //        navigateTo(ViewPath.SERVICE_REQUEST_SCREEN);
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
//        loginScreenController.setMainScreenController(this);
//        loginScreenController.setLocalDatabase(this.localDatabase);
//        loginScreenController.setClient(this.client);

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
//        loginScreenController.setMainScreenController(this);
//        loginScreenController.setLocalDatabase(this.localDatabase);
//        loginScreenController.setClient(this.client);

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
//        loginScreenController.setMainScreenController(this);
//        loginScreenController.setLocalDatabase(this.localDatabase);
//        loginScreenController.setClient(this.client);

        controller.setMainScreenController(this);
        setView(gridPane);
    }

    @FXML
    void onBackToStart() {

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
//        loginScreenController.setMainScreenController(this);
//        loginScreenController.setLocalDatabase(this.localDatabase);
//        loginScreenController.setClient(this.client);

        controller.setMainScreenController(this);
        setView(gridPane);
    }

    @FXML
    void onMerchandiseOrdersMenuPosition() {
    }

//    public void setClient(ClientPrim client) {
//        this.client = client;
//    }
}
