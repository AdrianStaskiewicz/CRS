package repositories;

import dtos.ServiceRequestDto;
import dtos.ServiceRequestRowModelDto;
import entities.ServiceRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ServiceRequestRepository {

    public List<ServiceRequestRowModelDto> getAll() {

//        RestTemplate restTemplate = new RestTemplate();
//        List<ServiceRequestDto> result = restTemplate.getForObject("http://localhost:8080/servicerequest2", List<ServiceRequestDto> result);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ServiceRequestRowModelDto>> response = restTemplate.exchange(
                "http://localhost:8080/servicerequestlist", HttpMethod.GET, null, new ParameterizedTypeReference<List<ServiceRequestRowModelDto>>(){});
        List<ServiceRequestRowModelDto> result = response.getBody();

//        List<ServiceRequestRowModelDto> result = new ArrayList<>();
//
//        for(int i =0;i<servicerequestlist.size();i++){
//            result.add(new ServiceRequestRowModelDto(servicerequestlist.get(i)));
//        }

        return result;

    }

}
