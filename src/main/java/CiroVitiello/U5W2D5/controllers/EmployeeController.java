package CiroVitiello.U5W2D5.controllers;

import CiroVitiello.U5W2D5.dto.NewEmployeeDTO;
import CiroVitiello.U5W2D5.entities.Employee;
import CiroVitiello.U5W2D5.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService es;


    @GetMapping
    private Page<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "id") String sortBy) {
        return this.es.getEmployees(page, size, sortBy);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Employee saveEmployee(@RequestBody NewEmployeeDTO body) {
        return es.save(body);
    }

    @GetMapping("/{employeeId}")
    private Employee findEmployeeById(@PathVariable int empId) {
        return es.findById(empId);

    }

    @PutMapping("/{employeeId}")
    private Employee findEmployeeByIdAndUpdate(@PathVariable int empId, @RequestBody NewEmployeeDTO body) {
        return es.findByIdAndUpdate(empId, body);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findEmployeeByIdAndDelete(@PathVariable int empId) {
        es.findByIdAndDelete(empId);
    }

    @PostMapping("/upload/{employeeId}")
    public Employee uploadAvatar(@RequestParam("avatar") MultipartFile image, @PathVariable long empId) throws IOException {
        return es.uploadImage(image, empId);
    }

}
