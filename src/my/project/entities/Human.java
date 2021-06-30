package my.project.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Human {
    private String name;
    private String surName;
    private LocalDate birthday;

    public Human() {
    }

    public Human(String name, String surName, LocalDate birthday) {
        this.name = name;
        this.surName = surName;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && Objects.equals(surName, human.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
