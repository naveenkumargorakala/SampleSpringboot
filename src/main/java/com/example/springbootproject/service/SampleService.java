package com.example.springbootproject.service;

import com.example.springbootproject.entity.SampleEntity;
import com.example.springbootproject.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;
    public int add(int a, int b) {
        int c =a+b;
        return c;
    }

    public String showDetails(SampleEntity entity) {
        String details = "Emp Name: "+entity.getEmp_name()+"\n id: "+entity.getEmp_id()+"\n Designation: "+entity.getEmp_desg();
        return details;
    }


    public String display(String name, int id, String desg) {
        return "employee: "+name+ "has id: "+id+ " his desg is: "+desg;
    }

    public String show(String name1, String desgn) {
        return name1+ " is "+desgn;
    }

    public String show1(String name) {
        return name;
    }


    public int[] numbers(int n) {
        int[] array = new int[n];
        for(int i=2;i<n-1;i++){
            if(n%i==0){
                array[i]=i;
            }
        }
        return array;
    }

    public SampleEntity newEmp(SampleEntity entity) {
        SampleEntity newOne = new SampleEntity(entity);
        sampleRepository.save(newOne);
        return newOne;
    }

    public List<SampleEntity> allEmps(SampleEntity entity) {
        List<SampleEntity> list1 =sampleRepository.findAll();
        return list1;
    }

    public SampleEntity getEmp(int id) {
        Optional<SampleEntity> emp = sampleRepository.findById(id);
        return emp.get();
    }

    public String deleteEmp(int id) {
        sampleRepository.deleteById(id);
        return "Deleted "+id+" employee Data... ";
    }

    public SampleEntity updateEmployee(SampleEntity entity) {
        Optional<SampleEntity> employee = sampleRepository.findById(entity.getEmp_id());
        employee.get().setEmp_name(entity.getEmp_name());
        employee.get().setEmp_desg(entity.getEmp_desg());
        employee.get().setSalary(entity.getSalary());
        sampleRepository.save(employee.get());
        return employee.get();
    }
}
