package repositories;

import dtos.AccountDto;
import entities.Customer;
import entities.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthorizationRepository {
    public AccountDto login(String login, String password) {
        RestTemplate restTemplate = new RestTemplate();

        AccountDto accountDto = new AccountDto(login, password, null);

        HttpEntity<AccountDto> requestUpdate = new HttpEntity<>(accountDto, null);

        ResponseEntity<AccountDto> test = restTemplate.exchange("http://localhost:8080/login", HttpMethod.POST, requestUpdate, AccountDto.class);
        accountDto = test.getBody();
        return accountDto;
    }

}
