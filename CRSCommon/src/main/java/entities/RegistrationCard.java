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
@Table(name = "REGISTRATION_CARD_0011")
public class RegistrationCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "VEHICLE")
    private Vehicle vehicle;
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;
    @ManyToOne()
    @JoinColumn(name = "OWNER")
    private Customer owner;
    @ManyToOne()
    @JoinColumn(name = "COOWNER")
    private Customer coowner;
    @Column(name = "BRAND")
    private String brand;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "VIN")
    private String vin;
    @Column(name = "PRODUCTION_YEAR")
    private int productionYear;
    @Column(name = "ENGINE_CAPACITY")
    private BigDecimal engineCapacity;
    @Column(name = "FUEL_TYPE")
    private String fuelType;
    @Column(name = "POWER")
    private BigDecimal power;
    @Column(name = "ACTIVE")
    private Boolean active;
    @Column(name = "EXPIRED_DATE")
    private Date expiredDate;

    public RegistrationCard() {
    }

    public RegistrationCard(int id) {
        this.id = id;
    }

    public String toString() {
        return brand+" "+model+" "+registrationNumber;
    }

}