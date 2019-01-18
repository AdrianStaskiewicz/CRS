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
public class MerchandiseOrderRowModelDto {

    private Integer lp;
    private Integer id;
    private Date acceptanceDate;
    private String merchandiseOrderNumber;
    private Customer customer;
    private ServiceRequest serviceRequest;
    private ServiceOrder serviceOrder;
    private Vehicle vehicle;
    private Boolean approve;
    private Date approveDate;

    public MerchandiseOrderRowModelDto(MerchandiseOrderHeader merchandiseOrderHeader) {
        this.id = merchandiseOrderHeader.getId();
        this.acceptanceDate = merchandiseOrderHeader.getInsertDate();
        this.merchandiseOrderNumber = merchandiseOrderHeader.getMerchandiseOrderNumber();
        this.customer = merchandiseOrderHeader.getCustomer();
        this.serviceRequest = merchandiseOrderHeader.getServiceRequest();
        this.serviceOrder = merchandiseOrderHeader.getServiceOrder();
        this.vehicle = merchandiseOrderHeader.getVehicle();
        this.approve = merchandiseOrderHeader.getApprove();
        this.approveDate = merchandiseOrderHeader.getApproveDate();
    }



//    public MerchandiseOrderHeader toEntity() {
//        MerchandiseOrderHeader merchandiseOrderHeader = new MerchandiseOrderHeader();
//
//        return merchandiseOrderHeader;
//    }
}
