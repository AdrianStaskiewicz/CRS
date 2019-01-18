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
@Table(name = "SERVICE_ORDER_0013")
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "MECHANIC")
    private Employee employee;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "APPROVE")
    private Boolean approve;
    @Column(name = "APPROVE_DATE")
    private Date approveDate;
    @ManyToOne()
    @JoinColumn(name = "DIVISION")
    private Division division;
    @ManyToOne()
    @JoinColumn(name = "COMPANY")
    private Company company;
    @ManyToOne()
    @JoinColumn(name = "INSERT_BY")
    private Account insertBy;
    @Column(name = "INSERT_DATE")
    private Date insertDate;
    @ManyToOne()
    @JoinColumn(name = "UPDATE_BY")
    private Account updateBy;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    public ServiceOrder() {
    }

    public ServiceOrder(int id) {
        this.id = id;
    }

    public String toString() {
        return employee.toString()+" "+description;
    }

}