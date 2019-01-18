package controllers;

import dtos.ServiceRequestDto;
import dtos.ServiceRequestRowModelDto;
import entities.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import parameters.ViewPath;
import repositories.ServiceRequestRepository;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ServiceRequestScreenController extends AbstractScreenController implements Initializable {

    @FXML
    private Label breadcrumbLabel;

    @FXML
    private AnchorPane notificationBackground;
    @FXML
    private Label notificationMessage;

    @FXML
    private TableView<ServiceRequestRowModelDto> serviceRequestDataTable;
    @FXML
    private TableColumn<ServiceRequestRowModelDto, String> serviceRequestNumberColumn;
    @FXML
    private TableColumn<ServiceRequestRowModelDto, Date> acceptanceDateColumn;
    @FXML
    private TableColumn<ServiceRequestRowModelDto, Customer> customerNameColumn;
    @FXML
    private TableColumn<ServiceRequestRowModelDto, String> vinNumberColumn;
    @FXML
    private TableColumn<ServiceRequestRowModelDto, String> registrationNumberColumn;
    @FXML
    private TableColumn<ServiceRequestRowModelDto, Boolean> statusColumn;
    @FXML
    private TableColumn<ServiceRequestRowModelDto, Date> approveDateColumn;

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
        ServiceRequestRowModelDto testowy= serviceRequestDataTable.getSelectionModel().getSelectedItem();
        System.out.println(serviceRequestDataTable.getSelectionModel().getSelectedItem());
    }

    public ObservableList<ServiceRequestRowModelDto> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modifyPositionButton.disableProperty().bind(serviceRequestDataTable.getSelectionModel().selectedItemProperty().isNull());
        deletePositionButton.disableProperty().bind(serviceRequestDataTable.getSelectionModel().selectedItemProperty().isNull());

        serviceRequestNumberColumn.setCellValueFactory(new PropertyValueFactory<ServiceRequestRowModelDto, String>("serviceRequestNumber"));
        acceptanceDateColumn.setCellValueFactory(new PropertyValueFactory<ServiceRequestRowModelDto, Date>("acceptanceDate"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<ServiceRequestRowModelDto, Customer>("customer"));
        vinNumberColumn.setCellValueFactory(new PropertyValueFactory<ServiceRequestRowModelDto, String>("vin"));
        registrationNumberColumn.setCellValueFactory(new PropertyValueFactory<ServiceRequestRowModelDto, String>("registrationNumber"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<ServiceRequestRowModelDto, Boolean>("approve"));
        approveDateColumn.setCellValueFactory(new PropertyValueFactory<ServiceRequestRowModelDto, Date>("approveDate"));

        ServiceRequestRepository serviceRequestRepository = new ServiceRequestRepository();

        data = FXCollections.observableArrayList(serviceRequestRepository.getAll());

        serviceRequestDataTable.setItems(data);
        serviceRequestDataTable.getSelectionModel();

    }
}
