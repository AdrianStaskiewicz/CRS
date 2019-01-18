package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "DIVISION_0002")
public class Division {
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
    @ManyToOne()
    @JoinColumn(name = "COMPANY")
    private Company company;

    public Division() {
    }

    public Division(int id) {
        this.id = id;
    }


    public String toString() {
        return name1+ " " +name2 + " "+company.toString();
    }

}