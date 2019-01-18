package services;

import dtos.VehicleFileRowModelDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ConnectionService {

    public Boolean checkConnection() {
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<String> response = restTemplate.exchange(
                    "http://localhost:8080/hello",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<String>() {
                    });
            String result = response.getBody();
        }catch(Exception e){
            return false;
        }

        return true;
    }
}
