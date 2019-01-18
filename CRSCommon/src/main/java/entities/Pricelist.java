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
@Table(name = "PRICELIST_0017")
public class Pricelist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ACTIVE")
    private Boolean active;
    @ManyToOne()
    @JoinColumn(name = "DIVISION")
    private Division division;
    @ManyToOne()
    @JoinColumn(name = "COMPANY")
    private Company company;

    public Pricelist() {
    }

    public Pricelist(int id) {
        this.id = id;
    }

    public String toString() {
        return name+" "+description+" "+active+" "+division.toString()+" "+company;
    }

}