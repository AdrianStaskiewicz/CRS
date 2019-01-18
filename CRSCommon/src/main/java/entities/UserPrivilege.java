package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "USER_PRIVILEGE_0008")
public class UserPrivilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "ACCOUNT")
    private Account account;
    @ManyToOne()
    @JoinColumn(name = "PRIVILEGE")
    private Privilege privilege;
    @Column(name = "LEVEL")
    private int level;

    public UserPrivilege() {
    }

    public UserPrivilege(int id) {
        this.id = id;
    }

    public String toString() {
        return account.toString()+" "+privilege.toString()+" "+level;
    }

}