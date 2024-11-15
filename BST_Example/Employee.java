/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author fali
 */
public class Employee {
    String name;
    int id;
    int salary;
    int dept_id;

    public Employee(String name, int id, int salary, int dept_id) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id + ", salary=" + salary + ", dept_id=" + dept_id + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }


}
