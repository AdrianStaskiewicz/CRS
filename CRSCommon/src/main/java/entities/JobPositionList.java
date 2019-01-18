package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "JOB_POSITION_LIST_0004")
public class JobPositionList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CODE")
    private String code;

    public JobPositionList() {
    }

    public JobPositionList(int id) {
        this.id = id;
    }


    public String toString() {
        return name+ " [" +code + "] - "+description;
    }

}