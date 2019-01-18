package repositories;

import dtos.MerchandiseOrderDto;
import dtos.MerchandiseOrderRowModelDto;
import dtos.ServiceRequestDto;
import entities.MerchandiseOrderHeader;
import entities.ServiceRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MerchandiseOrderRepository {

    public List<MerchandiseOrderRowModelDto> getAll() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<MerchandiseOrderHeader>> response = restTemplate.exchange(
                "http://localhost:8080/merchandiseorderlist", HttpMethod.GET, null, new ParameterizedTypeReference<List<MerchandiseOrderHeader>>(){});
        List<MerchandiseOrderHeader> merchandise = response.getBody();

        List<MerchandiseOrderRowModelDto> result = new ArrayList<>();

        for(int i =0;i<merchandise.size();i++){
            result.add(new MerchandiseOrderRowModelDto(merchandise.get(i)));
            result.get(i).setLp(i+1);
        }

        return result;
    }

    public MerchandiseOrderDto findById(Integer id){
        return null;
    }

}
