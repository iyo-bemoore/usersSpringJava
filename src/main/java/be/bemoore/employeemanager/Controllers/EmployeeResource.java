package be.bemoore.employeemanager.Controllers;

import be.bemoore.employeemanager.Service.EmployeeService;
import be.bemoore.employeemanager.Util.Mappings;
import be.bemoore.employeemanager.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(Mappings.BASE_URL)
public class EmployeeResource {
    private final EmployeeService employeeService;
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(Mappings.ALL_EMPLOYEES)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.ACCEPTED);
    }

    @GetMapping(Mappings.FIND_EMPLOYEE_BY_ID)
        public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")  Long id){
            Employee employee = employeeService.findEmployeeById(id);
            return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
    }

    @PostMapping(Mappings.ADD_EMPLOYEE)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @PutMapping(Mappings.UPDATE_EMPLOYEE)
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
    }

    @DeleteMapping(Mappings.DELETE_EMPLOYEE)
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){ // question mark means we do not want to return anything in the body.
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(Mappings.REMOVE_ALL)
    public ResponseEntity<?> removeAllEmployees(){
        employeeService.deleteAllEmployees();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
