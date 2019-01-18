package server;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.VehicleFileRowModelDto;
import entities.Customer;
import entities.QCustomer;
import entities.QRegistrationCard;
import entities.QVehicle;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

;

@RestController
public class VehicleController {
    @PersistenceContext
    private EntityManager em;

    @RequestMapping("/vehiclefile")
    public ResponseEntity<Customer> getServiceRequest() {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCustomer customer = QCustomer.customer;
        Customer customerEntity = (Customer) query.from(customer).fetchOne();

        return new ResponseEntity<Customer>(customerEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping("/vehiclefilelist")
    public List<VehicleFileRowModelDto> getServiceRequestsList() {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QVehicle vehicle = QVehicle.vehicle;
        QRegistrationCard registrationCard = QRegistrationCard.registrationCard;

        List<VehicleFileRowModelDto> result = (List<VehicleFileRowModelDto>) query.select(Projections.constructor(VehicleFileRowModelDto.class, vehicle.id, registrationCard.vin, registrationCard.registrationNumber, registrationCard.brand, registrationCard.model, registrationCard.owner, registrationCard.coowner, registrationCard.expiredDate))
                .from(vehicle)
                .leftJoin(registrationCard)
                .on(vehicle.id.eq(registrationCard.vehicle.id))
                .where(registrationCard.active.eq(Boolean.TRUE))
                .fetch();

        return result;
    }

}


//    TEMPLATE
//@RequestMapping("/koty")
//public class KotyApiController{
//        @Autowired
//        KotyService kotyService;
//
//        @RequestMapping(value="/{id}", method=RequestMethod.GET)
//        public ResponseEntity<Kot> get(@PathVariable("id") Long id){
//            Kot kot = kotyService.getById(id);
//            return new ResponseEntity<Kot>(kot, new HttpHeaders(), HttpStatus.OK);
//        }
//    }
//}

//    @RequestMapping(value="/{id}", method=RequestMethod.POST)
//    public ResponseEntity edit(@PathVariable("id") Long id, @RequestBody @Valid Kot kot, BindingResult result) {
//        if (result.hasErrors()) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    } } Kot kot = kotyService.getById(id);
////tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu
//kot = kotyService.update(kot);
//return new ResponseEntity(kot, new HttpHeaders(), HttpStatus.OK);
//}