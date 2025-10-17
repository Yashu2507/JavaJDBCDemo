package org.example.model;



public class Employee {
   private int id;
   private String firstname;
   private  String lastname;
   private int salary;
   private int age;
   private String dept;
   private String fullname;
   private int deptid;

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getFullname() {
        return fullname;
    }

    public Employee() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }

    public int getAge() {
        return age;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
//    public Employee(int id, String firstname,String lastname, int salary, int age, String dept) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.salary = salary;
//        this.age = age;
//        this.dept = dept;
//
//    }




    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", dept=" + dept +
                '}';
    }

}

