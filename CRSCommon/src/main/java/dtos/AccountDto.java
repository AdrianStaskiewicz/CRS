package dtos;

import entities.Account;
import entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    String login;
    String password;
    Employee employee;

    public AccountDto(Account account){
        this.employee = account.getEmployee();
    }
}
