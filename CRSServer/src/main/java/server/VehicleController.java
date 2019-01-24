package server;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.VehicleFileRowModelDto;
import entities.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
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

//    @Transactional
//    @RequestMapping(value = "/customercontact", method = RequestMethod.POST)
//    public ResponseEntity saveContact(@RequestBody @Valid Contact contact, BindingResult result) {
//        if (result.hasErrors()) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
////        em.getTransaction().begin();
//        contact = em.merge(contact);
//        em.flush();
////        em.getTransaction().commit();
//        //tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu
//        return new ResponseEntity(contact, new HttpHeaders(), HttpStatus.OK);
//    }

    @Transactional
    @RequestMapping(value = "/vehicleregistrationcard", method = RequestMethod.POST)
    public ResponseEntity saveRegistrationCard(@RequestBody @Valid RegistrationCard registrationCard, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
//        em.getTransaction().begin();
        registrationCard = em.merge(registrationCard);
        em.flush();
//        em.getTransaction().commit();
        //tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu
        return new ResponseEntity(registrationCard, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/vehicledetail", method = RequestMethod.POST)
    public ResponseEntity saveVehicle(@RequestBody @Valid Vehicle vehicle, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
//        em.getTransaction().begin();
        vehicle = em.merge(vehicle);
        em.flush();
//        em.getTransaction().commit();
        //tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu
        return new ResponseEntity(vehicle, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/vehicledelete", method = RequestMethod.DELETE)
    public void deleteVehicle(@RequestBody @Valid Vehicle vehicle, BindingResult result) {
        if (result.hasErrors()) {
            //return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
//        em.getTransaction().begin();
//        em.remove(customer);
//        em.flush();
        em.remove(em.contains(vehicle) ? vehicle : em.merge(vehicle));
//        em.getTransaction().commit();
        //tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu
        //return new ResponseEntity(customer, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET)
    public Customer findVehicleById(@PathVariable("id") Integer id) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCustomer customer = QCustomer.customer;
        Customer result = (Customer) query.from(customer).where(customer.id.eq(id)).fetchOne();
//TODO??
        return result;
    }

    @RequestMapping(value = "/registrationcard/{id}", method = RequestMethod.GET)
    public RegistrationCard findRegistrationCardById(@PathVariable("id") Integer id) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QRegistrationCard registrationCard = QRegistrationCard.registrationCard;
        QVehicle vehicle = QVehicle.vehicle;

        RegistrationCard result = (RegistrationCard) query.from(registrationCard).where(registrationCard.vehicle.id.eq(id)).fetchOne();
//TODO??
        return result;
    }

//    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
//    public Address findAddressById(@PathVariable("id") Integer id) {
//        JPAQueryFactory query = new JPAQueryFactory(em);
//
//        QAddress address = QAddress.address;
//        Address result = (Address) query.from(address).where(address.id.eq(id)).fetchOne();
//
//        return result;
//    }
//
//    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
//    public Contact findContactById(@PathVariable("id") Integer id) {
//        JPAQueryFactory query = new JPAQueryFactory(em);
//
//        QContact contact = QContact.contact;
//        Contact result = (Contact) query.from(contact).where(contact.id.eq(id)).fetchOne();
//
//        return result;
//    }

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