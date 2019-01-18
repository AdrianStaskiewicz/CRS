package dtos;

import entities.Customer;
import entities.ServiceRequest;
import entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleFileRowModelDto {

    private Integer id;
    private String vin;
    private String registrationNumber;
    private String brand;
    private String model;
    private Customer owner;
    private Customer coowner;
    private Date expiredDate;

//    public VehicleFileRowModelDto() {
////        this.id = serviceRequest.getId();
////        this.acceptanceDate = serviceRequest.getAcceptanceDate();
////        this.serviceRequestNumber = serviceRequest.getServiceRequestNumber();
////        this.customer = serviceRequest.getCustomer();
////        this.vehicle = serviceRequest.getVehicle();
////        if(serviceRequest.getApprove()){
////            this.approve = "Tak";
////        }else{
////            this.approve = "Nie";
////        }
////
////        this.approveDate = serviceRequest.getApproveDate();
//    }

}
