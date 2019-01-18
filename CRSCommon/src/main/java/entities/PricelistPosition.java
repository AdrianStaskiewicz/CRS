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
@Table(name = "PRICELIST_POSITION_0018")
public class PricelistPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "SPAREPART")
    private Sparepart sparepart;
    @Column(name = "PRICE")
    private BigDecimal price;
    @ManyToOne()
    @JoinColumn(name = "PRICELIST")
    private Pricelist pricelist;

    public PricelistPosition() {
    }

    public PricelistPosition(int id) {
        this.id = id;
    }

    public String toString() {
        return sparepart.toString()+" "+price+" "+pricelist.toString();
    }

}