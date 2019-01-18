package dtos;

import entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.spi.DateFormatProvider;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequestDto {

    private Integer id;
    private Date acceptanceDate;
    private String serviceRequestNumber;
    private Customer customer;
    private Vehicle vehicle;
    private String description;
    private Boolean approve;
    private Date approveDate;
    private Division division;
    private Company company;
    private Account insertBy;
    private Date insertDate;
    private Account updateBy;
    private Date updateDate;

    public ServiceRequestDto(ServiceRequest serviceRequest){
        this.id=serviceRequest.getId();
        this.acceptanceDate=serviceRequest.getAcceptanceDate();
        this.serviceRequestNumber=serviceRequest.getServiceRequestNumber();
        this.customer=serviceRequest.getCustomer();
        this.vehicle=serviceRequest.getVehicle();
        this.description=serviceRequest.getDescription();
        this.approve=serviceRequest.getApprove();
        this.approveDate=serviceRequest.getApproveDate();
        this.division=serviceRequest.getDivision();
        this.company=serviceRequest.getCompany();
        this.insertBy=serviceRequest.getInsertBy();
        this.insertDate=serviceRequest.getInsertDate();
        this.updateBy=serviceRequest.getUpdateBy();
        this.updateDate=serviceRequest.getUpdateDate();
    }

    public ServiceRequest toEntity() {
        ServiceRequest serviceRequest = new ServiceRequest();

        serviceRequest.setServiceRequestNumber(this.serviceRequestNumber);
        serviceRequest.setCustomer(this.customer);
        serviceRequest.setVehicle(this.vehicle);
        serviceRequest.setDescription(this.description);
        serviceRequest.setApprove(this.approve);
        serviceRequest.setApproveDate(this.approveDate);
        //no need
        serviceRequest.setDivision(this.division);
        serviceRequest.setCompany(this.company);
        serviceRequest.setInsertBy(this.insertBy);
        serviceRequest.setInsertDate(this.insertDate);
        serviceRequest.setUpdateBy(this.updateBy);
        serviceRequest.setUpdateDate(this.updateDate);

        return serviceRequest;
    }
}
