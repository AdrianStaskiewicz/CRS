package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "ADDRESS_0000")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;
    @Column(name = "LOCAL_NUMBER")
    private String localNumber;
    @Column(name = "POST_CODE")
    private String postCode;

    public Address() {
    }

    public Address(int id) {
        this.id = id;
    }


    public String toString() {
        return city + ", ul."+street+" "+houseNumber+"/"+localNumber+" "+postCode+" "+city;
    }

}
