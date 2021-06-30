package my.project.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student extends Human {
    private String group;
    private List<Integer> marks;

    public Student() {
        this.marks = new ArrayList<>();
    }

    public Student(String group, List<Integer> marks) {
        this.group = group;
        this.marks = marks;
    }

    public Student(String name, String surName, LocalDate year) {
        super(name, surName, year);
        this.marks = new ArrayList<>();
    }

    public Student(String name, String surName, LocalDate year, String group, List<Integer> marks) {
        super(name, surName, year);
        this.group = group;
        this.marks = marks;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public double getAverageMark() {
        double result = 0d;
        for (Integer mark : marks) {
            result += mark;
        }
        return result / marks.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), group);
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                ", group='" + group + '\'' +
                ", marks=" + Arrays.toString(marks.toArray()) +
                '}';
    }
}
