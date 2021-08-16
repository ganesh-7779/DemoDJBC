package com.bridgelabz;

public class tableModel {
    int id;
    String name;
    String gender;
    double salary;

    @Override
    public String toString (){
        return "tableModel [id ="+id+",name ="+name+",gender ="+gender+",salary ="+salary+"]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public tableModel(int id, String name, String gender, double salary){
        super();
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.salary=salary;
    }
}
