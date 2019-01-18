package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "VEHICLE_0010")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "CUSTOMER")
    private Customer customer;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "METER_STATE")
    private Integer meterState;
    @ManyToOne()
    @JoinColumn(name = "DIVISION")
    private Division division;
    @ManyToOne()
    @JoinColumn(name = "COMPANY")
    private Company company;

    public Vehicle() {
    }

    public Vehicle(int id) {
        this.id = id;
    }

    public String toString() {
        return customer.toString()+" "+description+" "+meterState+ " "+division.toString()+" "+company.toString();
    }

}