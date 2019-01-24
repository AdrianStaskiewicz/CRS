package controllers;

import dtos.ServiceRequestDto;
import dtos.VehicleFileRowModelDto;
import entities.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import parameters.ViewPath;
import repositories.CustomerFileRepository;
import repositories.ServiceRequestRepository;
import repositories.VehicleFileRepository;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class VehicleFileScreenController extends AbstractScreenController implements Initializable {

    @FXML
    private Label breadcrumbLabel;

    @FXML
    private AnchorPane notificationBackground;
    @FXML
    private Label notificationMessage;

    @FXML
    private TableView<VehicleFileRowModelDto> vehicleFileDataTable;
    @FXML
    private TableColumn<VehicleFileRowModelDto, String> vin;
    @FXML
    private TableColumn<VehicleFileRowModelDto, String> registrationNumber;
    @FXML
    private TableColumn<VehicleFileRowModelDto, String> brand;
    @FXML
    private TableColumn<VehicleFileRowModelDto, String> model;
    @FXML
    private TableColumn<VehicleFileRowModelDto, Customer> owner;
    @FXML
    private TableColumn<VehicleFileRowModelDto, Customer> coowner;
    @FXML
    private TableColumn<VehicleFileRowModelDto, Date> expiredDate;

    @FXML
    private Button addPositionButton;
    @FXML
    private Button modifyPositionButton;
    @FXML
    private Button deletePositionButton;
    @FXML
    private MenuButton printDocumentButton;

    @FXML
    void onAddPositionButton() {
        navigateTo(ViewPath.VEHICLE_ADD_EDIT_SCREEN);
    }

    @FXML
    void onDeletePositionButton() {
//TODO
//        Customer customer = new Customer();
//        customer.setId(customerFileDataTable.getSelectionModel().getSelectedItem().getId());
//        CustomerFileRepository customerFileRepository = new CustomerFileRepository();
//        customerFileRepository.deleteCustomer(customer);
//
//        navigateTo(ViewPath.CUSTOMER_FILES_SCREEN);
    }

    @FXML
    void onModifyPositionButton() {
        //na chwile
        VehicleFileRowModelDto testowy = vehicleFileDataTable.getSelectionModel().getSelectedItem();
        System.out.println(vehicleFileDataTable.getSelectionModel().getSelectedItem().getId());

        Integer objectId = vehicleFileDataTable.getSelectionModel().getSelectedItem().getId();
        navigateTo(ViewPath.VEHICLE_ADD_EDIT_SCREEN, objectId);
    }

    public ObservableList<VehicleFileRowModelDto> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modifyPositionButton.disableProperty().bind(vehicleFileDataTable.getSelectionModel().selectedItemProperty().isNull());
        deletePositionButton.disableProperty().bind(vehicleFileDataTable.getSelectionModel().selectedItemProperty().isNull());

        vin.setCellValueFactory(new PropertyValueFactory<VehicleFileRowModelDto, String>("vin"));
        registrationNumber.setCellValueFactory(new PropertyValueFactory<VehicleFileRowModelDto, String>("registrationNumber"));
        brand.setCellValueFactory(new PropertyValueFactory<VehicleFileRowModelDto, String>("brand"));
        model.setCellValueFactory(new PropertyValueFactory<VehicleFileRowModelDto, String>("model"));
        owner.setCellValueFactory(new PropertyValueFactory<VehicleFileRowModelDto, Customer>("owner"));
        coowner.setCellValueFactory(new PropertyValueFactory<VehicleFileRowModelDto, Customer>("coowner"));
        expiredDate.setCellValueFactory(new PropertyValueFactory<VehicleFileRowModelDto, Date>("expiredDate"));

        VehicleFileRepository vehicleFileRepository = new VehicleFileRepository();
//        vehicleFileRepository.getAll();
        data = FXCollections.observableArrayList(vehicleFileRepository.getAll());

        vehicleFileDataTable.setItems(data);
        vehicleFileDataTable.getSelectionModel();

        vehicleFileDataTable.setOnMousePressed((event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    onModifyPositionButton();
                }
            }
        });
    }

    public void navigateTo(String viewPath) {
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
        VehicleAddEditScreenController controller = innerLoader.getController();
        controller.setMainScreenController(mainScreenController);
//        set objects here

        mainScreenController.setView(gridPane);
    }

    private void navigateTo(String viewPath, Integer objectId) {
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
        VehicleAddEditScreenController controller = innerLoader.getController();
        controller.setMainScreenController(mainScreenController);
        controller.initData(objectId);
//        set objects here

        mainScreenController.setView(gridPane);
    }
}
