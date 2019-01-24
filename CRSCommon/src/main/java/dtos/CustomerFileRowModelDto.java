package dtos;

import entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerFileRowModelDto {

    private Integer id;
    private String forename;
    private String surname;
    private Address address;
    private Contact contact;

    public CustomerFileRowModelDto(Customer customer) {
        this.id = customer.getId();
        this.forename = customer.getForename();
        this.surname = customer.getSurname();
        this.address = customer.getAddress();
        this.contact = customer.getContact();
    }

    public String toString(){
        return forename+" "+surname+" "+address.toString();
    }

}
