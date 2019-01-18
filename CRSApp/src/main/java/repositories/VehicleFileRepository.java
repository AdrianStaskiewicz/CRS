package repositories;

import dtos.CustomerFileRowModelDto;
import dtos.MerchandiseOrderDto;
import dtos.ServiceRequestDto;
import dtos.VehicleFileRowModelDto;
import entities.Customer;
import entities.ServiceRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class VehicleFileRepository {
    public List<VehicleFileRowModelDto> getAll() {

//        RestTemplate restTemplate = new RestTemplate();
//        List<ServiceRequestDto> result = restTemplate.getForObject("http://localhost:8080/servicerequest2", List<ServiceRequestDto> result);


//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<List<Customer>> response = restTemplate.exchange(
//                "http://localhost:8080/vehiclefilelist", HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>(){});
//        List<Customer> customerfilelist = response.getBody();
//
//        List<CustomerFileRowModelDto> result = new ArrayList<>();
//
//        for(int i =0;i<customerfilelist.size();i++){
//            result.add(new CustomerFileRowModelDto(customerfilelist.get(i)));
//        }

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<VehicleFileRowModelDto>> response = restTemplate.exchange(
                "http://localhost:8080/vehiclefilelist",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<VehicleFileRowModelDto>>(){});
        List<VehicleFileRowModelDto> result = response.getBody();

        return result;

    }
}
