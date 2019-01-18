package server;

import com.querydsl.jpa.impl.JPAQueryFactory;
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

@RestController
public class CustomerController {
    @PersistenceContext
    private EntityManager em;

    @RequestMapping("/customerfile")
    public ResponseEntity<Customer> getServiceRequest() {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCustomer customer = QCustomer.customer;
        Customer customerEntity = (Customer) query.from(customer).fetchOne();

        return new ResponseEntity<Customer>(customerEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping("/customerfilelist")
    public List<Customer> getServiceRequestsList() {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCustomer customer = QCustomer.customer;
        List<Customer> result = (List<Customer>) query.from(customer).fetch();

        return result;
    }

    @Transactional
    @RequestMapping(value = "/customercontact", method = RequestMethod.POST)
    public ResponseEntity saveContact(@RequestBody @Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
//        em.getTransaction().begin();
        contact = em.merge(contact);
        em.flush();
//        em.getTransaction().commit();
        //tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu
        return new ResponseEntity(contact, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/customeraddress", method = RequestMethod.POST)
    public ResponseEntity saveAddress(@RequestBody @Valid Address address, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
//        em.getTransaction().begin();
        address = em.merge(address);
        em.flush();
//        em.getTransaction().commit();
        //tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu
        return new ResponseEntity(address, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/customerdetail", method = RequestMethod.POST)
    public ResponseEntity saveCustomer(@RequestBody @Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
//        em.getTransaction().begin();
        customer = em.merge(customer);
        em.flush();
//        em.getTransaction().commit();
        //tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu
        return new ResponseEntity(customer, new HttpHeaders(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/customerdelete", method = RequestMethod.DELETE)
    public void deleteCustomer(@RequestBody @Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            //return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
//        em.getTransaction().begin();
//        em.remove(customer);
//        em.flush();
        em.remove(em.contains(customer) ? customer : em.merge(customer));
//        em.getTransaction().commit();
        //tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu
        //return new ResponseEntity(customer, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer findById(@PathVariable("id") Integer id) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QCustomer customer = QCustomer.customer;
        Customer result = (Customer) query.from(customer).where(customer.id.eq(id)).fetchOne();

        return result;
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public Address findAddressById(@PathVariable("id") Integer id) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QAddress address = QAddress.address;
        Address result = (Address) query.from(address).where(address.id.eq(id)).fetchOne();

        return result;
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public Contact findContactById(@PathVariable("id") Integer id) {
        JPAQueryFactory query = new JPAQueryFactory(em);

       QContact contact = QContact.contact;
        Contact result = (Contact) query.from(contact).where(contact.id.eq(id)).fetchOne();

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