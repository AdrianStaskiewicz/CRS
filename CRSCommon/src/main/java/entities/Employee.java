package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE_0005")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FORENAME")
    private String forename;
    @Column(name = "SURNAME")
    private String surname;
    @ManyToOne()
    @JoinColumn(name = "ADDRESS")
    private Address address;
    @ManyToOne()
    @JoinColumn(name = "CONTACT")
    private Contact contact;
    @Column(name = "SALARY")
    private BigDecimal salary;
    @ManyToOne()
    @JoinColumn(name = "DIVISION")
    private Division division;
    @ManyToOne()
    @JoinColumn(name = "COMPANY")
    private Company company;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }


    public String toString() {
        return forename+ " " +surname + " "+address.toString() + " "+contact.toString()+" "+division.toString()+" "+company.toString();
    }

}