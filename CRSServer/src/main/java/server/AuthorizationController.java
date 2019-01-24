package server;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.AccountDto;
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
public class AuthorizationController {
    @PersistenceContext
    private EntityManager em;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody @Valid AccountDto account, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        JPAQueryFactory query = new JPAQueryFactory(em);

        QAccount accounte = QAccount.account;
        QEmployee employee = QEmployee.employee;
        QCompany company = QCompany.company;
        QDivision division = QDivision.division;

        Account test = (Account) query.from(accounte)
                .leftJoin(employee)
                .on(employee.id.eq(accounte.employee.id))
                .leftJoin(company)
                .on(company.id.eq(accounte.company.id))
                .leftJoin(division)
                .on(division.id.eq(accounte.division.id))
                .where(accounte.login.eq(account.getLogin()).and(accounte.password.eq(account.getPassword())))
                .fetchOne();

        if(test != null){
            account = new AccountDto(test);
            return new ResponseEntity(account, new HttpHeaders(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
//        em.getTransaction().begin();
//        customer = em.merge(customer);
//        em.flush();
//        em.getTransaction().commit();
        //tutaj przypisujemy wartość pól z obiektu otrzymanego w zapytaniu
//        return new ResponseEntity(account, new HttpHeaders(), HttpStatus.OK);
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