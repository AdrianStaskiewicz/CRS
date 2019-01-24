package repositories;

import dtos.CustomerFileRowModelDto;
import dtos.MerchandiseOrderDto;
import dtos.ServiceRequestDto;
import dtos.VehicleFileRowModelDto;
import entities.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class VehicleFileRepository {
    public List<VehicleFileRowModelDto> getAll() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<VehicleFileRowModelDto>> response = restTemplate.exchange(
                "http://localhost:8080/vehiclefilelist",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<VehicleFileRowModelDto>>(){});
        List<VehicleFileRowModelDto> result = response.getBody();

        return result;

    }

//    public Contact saveContact(Contact contact) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpEntity<Contact> requestUpdate = new HttpEntity<>(contact, null);
//
//        ResponseEntity<Contact> test = restTemplate.exchange("http://localhost:8080/customercontact", HttpMethod.POST, requestUpdate, Contact.class);
//        contact = test.getBody();
//        return contact;
//    }

    public RegistrationCard saveRegistrationCard(RegistrationCard registrationCard) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<RegistrationCard> requestUpdate = new HttpEntity<>(registrationCard, null);

        ResponseEntity<RegistrationCard> test = restTemplate.exchange("http://localhost:8080/vehicleregistrationcard", HttpMethod.POST, requestUpdate, RegistrationCard.class);
        registrationCard = test.getBody();
        return registrationCard;
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Vehicle> requestUpdate = new HttpEntity<>(vehicle, null);

        ResponseEntity<Vehicle> test = restTemplate.exchange("http://localhost:8080/vehicledetail", HttpMethod.POST, requestUpdate, Vehicle.class);
        vehicle = test.getBody();
        return vehicle;
    }

    public void deleteVehicle(Vehicle vehicle) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Vehicle> requestUpdate = new HttpEntity<>(vehicle, null);
        restTemplate.exchange("http://localhost:8080/vehicledelete", HttpMethod.DELETE, requestUpdate, Vehicle.class);
    }

    public Vehicle findById(Integer vehicleId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Vehicle> response = restTemplate.exchange(
                "http://localhost:8080/vehicle/"+vehicleId.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<Vehicle>() {
                });
        Vehicle vehicle = response.getBody();

        return vehicle;
    }

    public RegistrationCard findREgistrationCardByVehicleId(Integer vehicleId){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RegistrationCard> response = restTemplate.exchange(
                "http://localhost:8080/registrationcard/"+vehicleId.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<RegistrationCard>() {
                });
        RegistrationCard registrationCard = response.getBody();

        return registrationCard;
    }
}
