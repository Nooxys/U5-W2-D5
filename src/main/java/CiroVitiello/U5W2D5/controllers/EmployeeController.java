package CiroVitiello.U5W2D5.controllers;

import CiroVitiello.U5W2D5.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    private Page<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "id") String sortBy) {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Employee saveEmployee(@RequestBody Employee body) {

    }

    @GetMapping("/{employeeId}")
    private Employee findEmployeeById(@PathVariable int empId) {

    }

    @PutMapping("/{employeeId}")
    private Employee findEmployeeByIdAndUpdate(@PathVariable int empId, @RequestBody Employee body) {

    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findEmployeeByIdAndDelete(@PathVariable int empId) {

    }

    @PostMapping("/upload/{employeeId}")
    public Employee uploadAvatar(@RequestParam("avatar") MultipartFile image, @PathVariable long empId) throws IOException {

    }

}
