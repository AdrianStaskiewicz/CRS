package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "SPAREPART_0016")
public class Sparepart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME_1")
    private String name1;
    @Column(name = "NAME_2")
    private String name2;
    @ManyToOne()
    @JoinColumn(name = "CATEGORY")
    private SparepartCategoryList category;
    @ManyToOne()
    @JoinColumn(name = "MEASUREMENT_UNIT")
    private MeasurementUnit measurementUnit;
    @ManyToOne()
    @JoinColumn(name = "DIVISION")
    private Division division;
    @ManyToOne()
    @JoinColumn(name = "COMPANY")
    private Company company;

    public Sparepart() {
    }

    public Sparepart(int id) {
        this.id = id;
    }

    public String toString() {
        return name1+" "+name2+" "+category.toString()+" "+measurementUnit.toString()+" "+division.toString()+" "+company.toString();
    }

}