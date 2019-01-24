package context;

import entities.Company;
import entities.Division;
import entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContextHandler {
    private Company company;
    private Division division;
    private Employee employee;
}
