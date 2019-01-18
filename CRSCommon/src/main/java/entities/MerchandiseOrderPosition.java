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
@Table(name = "MERCHANDISE_ORDER_0020_P")
public class MerchandiseOrderPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "SPAREPART")
    private Sparepart sparepart;
    @Column(name = "Quantity")
    private BigDecimal quantity;
    @ManyToOne()
    @JoinColumn(name = "MERCHANDISE_ORDER_H")
    private MerchandiseOrderHeader merchandiseOrderHeader;

    public MerchandiseOrderPosition() {
    }

    public MerchandiseOrderPosition(int id) {
        this.id = id;
    }

    public String toString() {
        return sparepart.toString()+" "+quantity+" "+merchandiseOrderHeader.toString();
    }

}