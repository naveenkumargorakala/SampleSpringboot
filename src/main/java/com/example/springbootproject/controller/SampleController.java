package com.example.springbootproject.controller;

import com.example.springbootproject.entity.SampleEntity;
import com.example.springbootproject.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class SampleController {

    @Autowired
    SampleService service;

    @GetMapping("/one")
    public String method1() {
//        System.out.println("One");
        return "One";
    }

    @GetMapping("/2")
    public Integer method2() {
        return 2;
    }

    @GetMapping("/three")
    public String method3() {
        return "This is Your 3rd API";
    }

    @GetMapping("/four")
    public String method4() {
        return "You knew the GET method in Controller";
    }

    @GetMapping("/")
    public String method5() {
//        System.out.println("no issue");
        return "No Issue";
    }

    @GetMapping("/post1")
    public int data() {
        int a = service.add(8, 7);
        return a;
    }

    @GetMapping("/info")
    public String emp_Data(@RequestBody SampleEntity entity) {
        String response = service.showDetails(entity);
        return response;
    }

    @PostMapping("/info1")
    public String emp_Dataa(@RequestBody SampleEntity entity) {
        String response = service.showDetails(entity);
        return response;
    }

    @PostMapping("/info2")
    public String emp_Details1(@RequestHeader String name, @RequestHeader int id, @RequestHeader String desg) {
        String response = service.display(name, id, desg);
        return response;
    }

    @PostMapping("/info3")
    public String emp_Details2(@RequestParam String name1, @RequestParam String desg1) {
        String response = service.show(name1, desg1);
        return response;
    }

    @PostMapping("/{name}")
    public String emp_Details3(@PathVariable String name) {
        String response = service.show1(name);
        return response;
    }

    @PostMapping("/form")
    public String stu_det(@RequestHeader String name, @RequestHeader int id, @RequestHeader double salary) {
        return "Name: " + name + " and his roll is: " + id + " salary is: " + salary;
    }

    @PostMapping("/form1")
    public String stu_det1(@RequestParam String classs) {
        return "Naveen is: " + classs + " class";
    }

    @GetMapping("/nav/{n}")
    public int[] factors(@PathVariable int n) {
        int[] arr = new int[n];
        arr = service.numbers(n);
        return arr;
    }

    @PostMapping("/newEmployee")
    public SampleEntity newEmployee(@RequestBody SampleEntity Entity) {
        SampleEntity newOne = service.newEmp(Entity);
        return newOne;
    }

    @GetMapping("/allEmployees")
    public List<SampleEntity> allEmployees(@RequestBody SampleEntity entity) {
        List<SampleEntity> listOfEmployees = service.allEmps(entity);
        return listOfEmployees;
    }

    @GetMapping("/getEmployee/{id}")
    public SampleEntity getEmployeebyId(@PathVariable int id) {
        SampleEntity employee = service.getEmp(id);

        return employee;
    }

    @DeleteMapping("/deleteEmpById/{id}")
    public String deleteEmployee(@PathVariable int id) {
        String emp = service.deleteEmp(id);
        return emp;
    }

    @PutMapping("/update")
    public SampleEntity updateEmp(@RequestBody SampleEntity entity){
        SampleEntity updateEmployee = service.updateEmployee(entity);
        return updateEmployee;
    }

}