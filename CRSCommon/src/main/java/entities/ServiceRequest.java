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
@Table(name = "SERVICE_REQUEST_0012")
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ACCEPTANCE_DATE")
    private Date acceptanceDate;
    @Column(name = "SERVICE_REQUEST_NUMBER")
    private String serviceRequestNumber;
    @ManyToOne()
    @JoinColumn(name = "CUSTOMER")
    private Customer customer;
    @ManyToOne()
    @JoinColumn(name = "VEHICLE")
    private Vehicle vehicle;
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

    public ServiceRequest() {
    }

    public ServiceRequest(int id) {
        this.id = id;
    }


    public String toString() {
        return serviceRequestNumber+" "+customer.toString()+" "+vehicle.toString()+" "+description;
    }

}