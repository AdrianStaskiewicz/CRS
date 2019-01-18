package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "MEASUREMENT_UNIT_0015")
public class MeasurementUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SYMBOL")
    private String symbol;
    @Column(name = "CODE")
    private String code;

    public MeasurementUnit() {
    }

    public MeasurementUnit(int id) {
        this.id = id;
    }


    public String toString() {
        return symbol+" "+code;
    }

}