package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "COMPANY_0001")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME_1")
    private String name1;
    @Column(name = "NAME_2")
    private String name2;
    @ManyToOne()
    @JoinColumn(name = "ADDRESS")
    private Address address;

    public Company() {
    }

    public Company(int id) {
        this.id = id;
    }


    public String toString() {
        return name1+ " " +name2 + " "+address.toString();
    }

}
