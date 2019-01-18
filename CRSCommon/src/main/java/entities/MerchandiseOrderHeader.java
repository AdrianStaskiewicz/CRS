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
@Table(name = "MERCHANDISE_ORDER_0019_H")
public class MerchandiseOrderHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MERCHANDISE_ORDER_NUMBER")
    private String merchandiseOrderNumber;
    @ManyToOne()
    @JoinColumn(name = "Customer")
    private Customer customer;
    @Column(name = "APPROVE")
    private Boolean approve;
    @Column(name = "APPROVE_DATE")
    private Date approveDate;
    @ManyToOne()
    @JoinColumn(name = "SERVICE_REQUEST")
    private ServiceRequest serviceRequest;
    @ManyToOne()
    @JoinColumn(name = "SERVICE_ORDER")
    private ServiceOrder serviceOrder;
    @ManyToOne()
    @JoinColumn(name = "VEHICLE")
    private Vehicle vehicle;
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

    public MerchandiseOrderHeader() {
    }

    public MerchandiseOrderHeader(int id) {
        this.id = id;
    }

    public String toString() {
        return customer.toString() + " " + merchandiseOrderNumber + " " + approve + " " + approveDate + " " + serviceRequest.toString() + " " + serviceOrder.toString() + " " + vehicle.toString() + " " + division.toString() + " " + company.toString() + " " + insertBy.toString() + " " + insertDate + " " + updateBy.toString() + " " + updateDate;
    }

}