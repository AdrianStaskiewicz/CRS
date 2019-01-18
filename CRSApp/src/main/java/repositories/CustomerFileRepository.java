package repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.CustomerFileRowModelDto;
import dtos.ServiceRequestRowModelDto;
import entities.Address;
import entities.Contact;
import entities.Customer;
import entities.ServiceRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class CustomerFileRepository {

    public List<CustomerFileRowModelDto> getAll() {

//        RestTemplate restTemplate = new RestTemplate();
//        List<ServiceRequestDto> result = restTemplate.getForObject("http://localhost:8080/servicerequest2", List<ServiceRequestDto> result);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> response = restTemplate.exchange(
                "http://localhost:8080/customerfilelist", HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {
                });
        List<Customer> customerfilelist = response.getBody();

        List<CustomerFileRowModelDto> result = new ArrayList<>();

        for (int i = 0; i < customerfilelist.size(); i++) {
            result.add(new CustomerFileRowModelDto(customerfilelist.get(i)));
        }

        return result;

    }

    public Contact saveContact(Contact contact) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Contact> requestUpdate = new HttpEntity<>(contact, null);

        ResponseEntity<Contact> test = restTemplate.exchange("http://localhost:8080/customercontact", HttpMethod.POST, requestUpdate, Contact.class);
        contact = test.getBody();
        return contact;
    }

    public Address saveAddress(Address address) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Address> requestUpdate = new HttpEntity<>(address, null);

        ResponseEntity<Address> test = restTemplate.exchange("http://localhost:8080/customeraddress", HttpMethod.POST, requestUpdate, Address.class);
        address = test.getBody();
        return address;
    }

    public Customer saveCustomer(Customer customer) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Customer> requestUpdate = new HttpEntity<>(customer, null);

        ResponseEntity<Customer> test = restTemplate.exchange("http://localhost:8080/customerdetail", HttpMethod.POST, requestUpdate, Customer.class);
        customer = test.getBody();
        return customer;
    }

    public void deleteCustomer(Customer customer) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Customer> requestUpdate = new HttpEntity<>(customer, null);
        restTemplate.exchange("http://localhost:8080/customerdelete", HttpMethod.DELETE, requestUpdate, Customer.class);
    }

    public Customer findById(Integer customerId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Customer> response = restTemplate.exchange(
                "http://localhost:8080/customer/"+customerId.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<Customer>() {
                });
        Customer customer = response.getBody();

        return customer;
    }

    public Address findAddressById(Integer addressId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Address> response = restTemplate.exchange(
                "http://localhost:8080/address/"+addressId.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<Address>() {
                });
        Address address = response.getBody();

        return address;
    }

    public Contact findContactById(Integer addressId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Contact> response = restTemplate.exchange(
                "http://localhost:8080/contact/"+addressId.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<Contact>() {
                });
        Contact contact = response.getBody();

        return contact;
    }
}