package com.example.springbootproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SampleEntity  {

    @Id
    @GeneratedValue
    private int emp_id;
    private String emp_name;
    private String emp_desg;
    private double salary;

    public SampleEntity(SampleEntity entity) {
        this.emp_name=entity.getEmp_name();
        this.emp_desg=entity.getEmp_desg();
        this.salary=entity.getSalary();

    }

    public SampleEntity() {

    }

    public SampleEntity(int emp_id, String emp_name, String emp_desg, double salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_desg = emp_desg;
        this.salary = salary;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_desg() {
        return emp_desg;
    }

    public void setEmp_desg(String emp_desg) {
        this.emp_desg = emp_desg;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "SampleEntity{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_desg='" + emp_desg + '\'' +
                ", salary=" + salary +
                '}';
    }
}
