package my.project.utils;

import my.project.entities.Human;
import my.project.entities.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Utils {
    private Utils() {}

    /**
     * Создает и возвращает компаратор для объектов класса Human.
     * Сравнение происходит по возрасту человека.
     * @return компаратор для объектов класса Human
     */
    public static Comparator<Human> getHumanComparator() {
        return Comparator.comparingInt(Human::getAge);
    }

    /**
     * Создает компаратор для объектов класса Student.
     * Сравнение происходит по средней оценке студента.
     * @return компаратор для объектов класса Student
     */
    public static Comparator<Student> getStudentComparator() {
        return Comparator.comparingDouble(Student::getAverageMark);
    }

    /**
     * Сортирует список объектов класса Human с помощью сортировки вставками
     * @param list - список объектов класса Human
     */
    public static void insertSortHumans(List<Human> list) {
        for (int i = 1; i < list.size(); i++) {
            Human curHum = list.get(i);
            int curAge = curHum.getAge();
            int j = i - 1;
            while(j >= 0 && curAge < list.get(j).getAge()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, curHum);
        }
    }

    /**
     * Сортирует список объектов класса Student с помощью сортировки вставками
     * @param list - список объектов класса Human
     */
    public static void insertSortStudents(List<Student> list) {
        for (int i = 1; i < list.size(); i++) {
            Student curStudent = list.get(i);
            double curAverageMark = curStudent.getAverageMark();
            int j = i - 1;
            while(j >= 0 && curAverageMark < list.get(j).getAverageMark()) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, curStudent);
        }
    }

    /**
     * Позволяет получить список студентов из общего списка людей
     * @param humanList - список объектов класса Human
     * @return список объектов класса Student или пустой список
     */
    public static List<Student> getStudents(List<Human> humanList) {
        List<Student> studentList = new ArrayList<>();
        for (Human human : humanList) {
            if (human instanceof Student) studentList.add((Student)human);
        }
        return studentList;
    }
}
