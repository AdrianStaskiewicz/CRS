package dtos;

import entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequestRowModelDto {

    private Integer id;
    private Date acceptanceDate;
    private String serviceRequestNumber;
    private Customer customer;
    private String vin;
    private String registrationNumber;
    private String approve;
    private Date approveDate;

    public ServiceRequestRowModelDto(ServiceRequest serviceRequest) {
        this.id = serviceRequest.getId();
        this.acceptanceDate = serviceRequest.getAcceptanceDate();
        this.serviceRequestNumber = serviceRequest.getServiceRequestNumber();
        this.customer = serviceRequest.getCustomer();

        if(serviceRequest.getApprove()){
            this.approve = "Tak";
        }else{
            this.approve = "Nie";
        }

        this.approveDate = serviceRequest.getApproveDate();
    }

    public ServiceRequestRowModelDto(Integer id, Date acceptanceDate, String serviceRequestNumber, Customer customer, String vin, String registrationNumber, Boolean approve, Date approveDate){
        this.id = id;
        this.acceptanceDate = acceptanceDate;
        this.serviceRequestNumber = serviceRequestNumber;
        this.customer = customer;
        this.vin = vin;
        this.registrationNumber=registrationNumber;
        if(approve){
            this.approve = "Tak";
        }else{
            this.approve = "Nie";
        }

        this.approveDate = approveDate;
    }

}
