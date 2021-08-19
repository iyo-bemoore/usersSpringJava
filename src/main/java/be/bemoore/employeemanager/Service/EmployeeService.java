package be.bemoore.employeemanager.Service;

import be.bemoore.employeemanager.exception.UserNotFoundException;
import be.bemoore.employeemanager.model.Employee;
import be.bemoore.employeemanager.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService  {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeId(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by Id "+ id + "Is not found"));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
    public void deleteAllEmployees() {
        employeeRepo.deleteAll();
    }
}
