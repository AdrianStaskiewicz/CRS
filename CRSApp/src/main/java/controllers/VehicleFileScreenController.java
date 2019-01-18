package controllers;

import dtos.ServiceRequestDto;
import dtos.VehicleFileRowModelDto;
import entities.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import parameters.ViewPath;
import repositories.ServiceRequestRepository;
import repositories.VehicleFileRepository;

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
        navigateTo(ViewPath.ADD_EDIT_SERVICE_REQUEST_SCREEN);
    }

    @FXML
    void onDeletePositionButton() {

    }

    @FXML
    void onModifyPositionButton() {
        VehicleFileRowModelDto testowy = vehicleFileDataTable.getSelectionModel().getSelectedItem();
        System.out.println(vehicleFileDataTable.getSelectionModel().getSelectedItem());
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
    }
}
