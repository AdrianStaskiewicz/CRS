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
@Table(name = "SPAREPART_CATEGORY_LIST_0014")
public class SparepartCategoryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CODE")
    private int code;

    public SparepartCategoryList() {
    }

    public SparepartCategoryList(int id) {
        this.id = id;
    }

    public String toString() {
        return name+" "+description+" "+code;
    }

}