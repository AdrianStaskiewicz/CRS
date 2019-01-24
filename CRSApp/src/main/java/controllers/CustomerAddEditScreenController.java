package controllers;

import dtos.CustomerFileDto;
import entities.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import parameters.ViewPath;
import repositories.CustomerFileRepository;

import java.io.IOException;

public class CustomerAddEditScreenController extends AbstractScreenController {
    @FXML
    private AnchorPane notificationBackground;

    @FXML
    private Label notificationMessage;

    @FXML
    private Button save;

    @FXML
    private Button saveAndExit;

    @FXML
    private Button resign;

    @FXML
    private MenuButton printDocumentButton;

    @FXML
    private TextField street;

    @FXML
    private TextField city;

    @FXML
    private TextField localNumber;

    @FXML
    private TextField houseNumber;

    @FXML
    private TextField postCodeFirstPart;

    @FXML
    private TextField postCodeSecondPart;

    @FXML
    private TextField surname;

    @FXML
    private TextField forename;

    @FXML
    private TextField fax;

    @FXML
    private TextField phone;

    @FXML
    private TextField mailAddress;

    @FXML
    private TextField cellPhone;

    private Customer customer;
    private Address address;
    private Contact contact;

    @FXML
    public void initialize(){
        customer = new Customer();
        address = new Address();
        contact = new Contact();
    }

    @FXML
    void onResign() {
///nachwile
        navigateTo(ViewPath.CUSTOMER_FILES_SCREEN);
    }

    @FXML
    void onSave() {
        save();
    }

    @FXML
    void onSaveAndExit() {
        save();
        navigateTo(ViewPath.CUSTOMER_FILES_SCREEN);
    }

    private void save() {

        customer.setForename(forename.getText());
        customer.setSurname(surname.getText());

        //Address address = new Address();
        address.setCity(city.getText());
        address.setStreet(street.getText());
        address.setHouseNumber(houseNumber.getText());
        address.setLocalNumber(localNumber.getText());
        address.setPostCode(postCodeFirstPart.getText() + "-" + postCodeSecondPart.getText());

        //Contact contact = new Contact();
        contact.setPhone(phone.getText());
        contact.setFax(fax.getText());
        contact.setCellPhone(cellPhone.getText());
        contact.setMail(mailAddress.getText());

        CustomerFileRepository customerFileRepository = new CustomerFileRepository();
        contact = customerFileRepository.saveContact(contact);
        address = customerFileRepository.saveAddress(address);
        customer.setContact(contact);
        customer.setAddress(address);
        //nachwile
        Division division = new Division();
        division.setId(100000);
        Company company = new Company();
        company.setId(100000);
        customer.setCompany(company);
        customer.setDivision(division);

        customerFileRepository.saveCustomer(customer);
    }

    @Override
    public void initData(Integer objectId) {
        CustomerFileRepository customerFileRepository = new CustomerFileRepository();
        customer = customerFileRepository.findById(objectId);

        forename.setText(customer.getForename());
        surname.setText(customer.getSurname());

        address = customer.getAddress();

        city.setText(address.getCity());
        street.setText(address.getStreet());
        houseNumber.setText(address.getHouseNumber());
        localNumber.setText(address.getLocalNumber());
        postCodeFirstPart.setText(address.getPostCode().substring(0, 2));
        postCodeSecondPart.setText(address.getPostCode().substring(3, 6));

        contact = customer.getContact();

        phone.setText(contact.getPhone());
        fax.setText(contact.getFax());
        cellPhone.setText(contact.getCellPhone());
        mailAddress.setText(contact.getMail());
    }

    public void navigateTo(String viewPath){
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
        CustomerFileScreenController controller = innerLoader.getController();
        controller.setMainScreenController(mainScreenController);
//        set objects here

        mainScreenController.setView(gridPane);
    }

}
