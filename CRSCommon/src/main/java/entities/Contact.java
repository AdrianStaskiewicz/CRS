package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "CONTACT_0003")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "CELLPHONE")
    private String cellPhone;
    @Column(name = "MAIL")
    private String mail;

    public Contact() {
    }

    public Contact(int id) {
        this.id = id;
    }


    public String toString() {
        return "tel. "+phone+ " fax " +fax + " tel. kom. "+cellPhone +" e-mail "+mail;
    }

}