package controllers;

import dtos.CustomerFileRowModelDto;
import dtos.ServiceRequestRowModelDto;
import entities.Address;
import entities.Contact;
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

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CustomerFileScreenController extends AbstractScreenController implements Initializable {

    @FXML
    private Label breadcrumbLabel;

    @FXML
    private AnchorPane notificationBackground;
    @FXML
    private Label notificationMessage;

    @FXML
    private TableView<CustomerFileRowModelDto> customerFileDataTable;
    @FXML
    private TableColumn<CustomerFileRowModelDto, String> forenameColumn;
    @FXML
    private TableColumn<CustomerFileRowModelDto, String> surnameColumn;
    @FXML
    private TableColumn<CustomerFileRowModelDto, Address> addressColumn;
    @FXML
    private TableColumn<CustomerFileRowModelDto, Contact> contactColumn;

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
        navigateTo(ViewPath.CUSTOMER_ADD_EDIT_SCREEN);
    }

    @FXML
    void onDeletePositionButton() {
        Customer customer = new Customer();
        customer.setId(customerFileDataTable.getSelectionModel().getSelectedItem().getId());
        CustomerFileRepository customerFileRepository = new CustomerFileRepository();
        customerFileRepository.deleteCustomer(customer);

        navigateTo(ViewPath.CUSTOMER_FILES_SCREEN);
    }

    @FXML
    void onModifyPositionButton() {
//        ServiceRequestRowModelDto testowy= serviceRequestDataTable.getSelectionModel().getSelectedItem();
        Integer objectId = customerFileDataTable.getSelectionModel().getSelectedItem().getId();
        navigateTo(ViewPath.CUSTOMER_ADD_EDIT_SCREEN, objectId);
    }

    public ObservableList<CustomerFileRowModelDto> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modifyPositionButton.disableProperty().bind(customerFileDataTable.getSelectionModel().selectedItemProperty().isNull());
        deletePositionButton.disableProperty().bind(customerFileDataTable.getSelectionModel().selectedItemProperty().isNull());

        forenameColumn.setCellValueFactory(new PropertyValueFactory<CustomerFileRowModelDto, String>("forename"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<CustomerFileRowModelDto, String>("surname"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<CustomerFileRowModelDto, Address>("address"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<CustomerFileRowModelDto, Contact>("contact"));

        CustomerFileRepository customerFileRepository = new CustomerFileRepository();

        data = FXCollections.observableArrayList(customerFileRepository.getAll());

        customerFileDataTable.setItems(data);
        customerFileDataTable.getSelectionModel();

        customerFileDataTable.setOnMousePressed((event) -> {
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
        CustomerAddEditScreenController controller = innerLoader.getController();
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
        CustomerAddEditScreenController controller = innerLoader.getController();
        controller.setMainScreenController(mainScreenController);
        controller.initData(objectId);
//        set objects here

        mainScreenController.setView(gridPane);
    }
}
