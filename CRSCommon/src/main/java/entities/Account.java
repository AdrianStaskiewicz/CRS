package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT_0006")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "EMPLOYEE")
    private Employee employee;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PASSWORD_EXPIRED_DATE")
    private Date passwordExpiredDate;
    @Column(name = "ACTIVE")
    private Boolean active;
    @ManyToOne()
    @JoinColumn(name = "DIVISION")
    private Division division;
    @ManyToOne()
    @JoinColumn(name = "COMPANY")
    private Company company;

    public Account() {
    }

    public Account(int id) {
        this.id = id;
    }

    public String toString() {
        return employee.toString()+ " " +login + " "+password + " "+passwordExpiredDate+" "+active+" "+division.toString()+" "+company.toString();
    }

}