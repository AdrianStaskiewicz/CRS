package server;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dtos.MerchandiseOrderDto;
import dtos.MerchandiseOrderRowModelDto;
import entities.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

;

@RestController
public class MerchandiseOrderController {
    @PersistenceContext
    private EntityManager em;

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

    @RequestMapping("/merchandiseorder")
    public List<MerchandiseOrderDto> getMerchandiseOrder() {
        JPAQueryFactory query = new JPAQueryFactory(em);

//        QMerchandiseOrderHeader merchandiseOrderHeader = QMerchandiseOrderHeader.merchandiseOrderHeader;
//       QMerchandiseOrderPosition merchandiseOrderPosition = QMerchandiseOrderPosition.merchandiseOrderPosition;
//
//        MerchandiseOrderDto result = (MerchandiseOrderDto) query.from(merchandiseOrderHeader).leftJoin(merchandiseOrderPosition)
//        .on(merchandiseOrderHeader.id.eq(merchandiseOrderPosition.merchandiseOrderHeader.id))
//                .where()
//                .fetch();

        return null;
    }

    @RequestMapping("/merchandiseorderlist")
    public List<MerchandiseOrderDto> getMerchandiseOrdersList() {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QMerchandiseOrderHeader merchandiseOrderHeader = QMerchandiseOrderHeader.merchandiseOrderHeader;
        List<MerchandiseOrderDto> result = (List<MerchandiseOrderDto>) query.from(merchandiseOrderHeader).fetch();

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