package org.example.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int person_id;

    @NotEmpty(message = "Поле \"ФИО\" не должно быть пустым")
    @Size(min = 2, max = 50, message = "Поле \"ФИО\" должно содержать от 2 до 50 символов.")
    private String fullName;

    private int age;

    public Person(int person_id, String fullName, int age) {
        this.person_id = person_id;
        this.fullName = fullName;
        this.age = age;
    }

    public Person(){}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }
}
