package server;

;
import com.querydsl.jpa.impl.JPAQueryFactory;

import dtos.MerchandiseOrderDto;
import dtos.ServiceRequestDto;
import entities.*;
import org.apache.coyote.Request;
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

@RestController
public class DemoController {
    @PersistenceContext
    private EntityManager em;

    @RequestMapping("/hello")
    public String hello() {

        return "Hello";
    }

    @RequestMapping("/address")
    public Address getAddress() {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QAddress address = QAddress.address;
        Address addressesList = (Address) query.from(address).fetchOne();

        return addressesList;
    }

    @RequestMapping("/addresses")
    public String getAddresses() {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QAddress address = QAddress.address;
        List<Address> addressesList = (List<Address>) query.from(address).fetch();

        return addressesList.get(0).toString();
    }

    @RequestMapping("/usersWithFilter")
    public List<Address> get() {
        JPAQueryFactory query = new JPAQueryFactory(em);

//        QUsers users = QUsers.users;
//        List<Address> usersList = (List<Address>) query.from(users).where(users.forename.eq("Adrian")).fetch();

        return null;
    }

    @RequestMapping("/companies")
    public List<Company> getCompanies() {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCompany company = QCompany.company;
        List<Company> companiesList = (List<Company>) query.from(company).fetch();

        return companiesList;
    }

    @RequestMapping("/company")
    public String getCompany() {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCompany company = QCompany.company;
        Company firstCompany = (Company) query.from(company).fetchOne();

        return firstCompany.toString();
    }

    @RequestMapping("/test")
    public ResponseEntity<Address> getTest() {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QAddress address = QAddress.address;
        Address addressList = (Address) query.from(address).fetchOne();

        return new ResponseEntity<Address>(addressList, new HttpHeaders(), HttpStatus.OK);
    }

//    @RequestMapping("/servicerequest")
//    public ResponseEntity<ServiceRequest> getServiceRequest() {
//        JPAQueryFactory query = new JPAQueryFactory(em);
//
//        QServiceRequest serviceRequest = QServiceRequest.serviceRequest;
//        ServiceRequest serviceRequestEntity = (ServiceRequest) query.from(serviceRequest).fetchOne();
//
//        return new ResponseEntity<ServiceRequest>(serviceRequestEntity, new HttpHeaders(), HttpStatus.OK);
//    }
//
//    @RequestMapping("/servicerequest2")
//    public List<ServiceRequest> getServiceRequestList() {
//        JPAQueryFactory query = new JPAQueryFactory(em);
//
//        QServiceRequest serviceRequest = QServiceRequest.serviceRequest;
//        List<ServiceRequest> result = (List<ServiceRequest>) query.from(serviceRequest).fetch();
//
//        return result;
//    }
//
//    @RequestMapping("/merchandiseorder")
//    public List<MerchandiseOrderDto> getMerchandiseOrderList() {
//        JPAQueryFactory query = new JPAQueryFactory(em);
//
//       QMerchandiseOrderHeader merchandiseOrderHeader = QMerchandiseOrderHeader.merchandiseOrderHeader;
////       QMerchandiseOrderPosition
//        List<MerchandiseOrderDto> result = (List<MerchandiseOrderDto>) query.from(merchandiseOrderHeader).fetch();
//
//        return result;
//    }

    @Transactional
    @RequestMapping(value = "/testb", method = RequestMethod.POST)
    public ResponseEntity edit(@RequestBody @Valid Address address2, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        JPAQueryFactory query = new JPAQueryFactory(em);

        QAddress address = QAddress.address;
        Address addressList = (Address) query.from(address).fetchOne();

//        Kot kot = kotyService.getById(id);
//tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu

//for update
//        Long identity = query.update(address)
//                .set(address.city, address2.getCity())
//                .set(address.street, address2.getStreet())
//                .set(address.houseNumber, address2.getHouseNumber())
//                .set(address.localNumber, address2.getLocalNumber())
//                .set(address.postCode, address2.getPostCode())
//                .execute();
//
//        int idek = Integer.valueOf(identity.toString());
//        Address tescik = new Address();
//        em.getTransaction().begin();
        Address ad = new Address();
        em.persist(address2);
//        em.getTransaction().commit();

//        tescik = (Address) query.from(address).where().fetchOne();

        return new ResponseEntity(address2, new HttpHeaders(), HttpStatus.OK);
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