package my.project;

import my.project.entities.Human;
import my.project.entities.Student;
import my.project.io.InputClass;
import my.project.io.OutputClass;
import my.project.utils.Utils;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static final String PATH_TO_INPUT_FILE = "C:\\Users\\Anton_Sorokin1\\IdeaProjects\\some-project\\resources\\input.txt";
    public static final String PATH_TO_OUTPUT_FILE = "C:\\Users\\Anton_Sorokin1\\IdeaProjects\\some-project\\resources\\output.txt";

    public static void main(String[] args) {
        // Читаем строки из файла ввода
        List<String> lines = InputClass.read(PATH_TO_INPUT_FILE);
        // Переводим прочитанные строки в список людей
        List<Human> humanList = InputClass.parse(lines);
        // Выбираем из списка людей студентов и запоминаем отдельный список (список людей не изменятся)
        List<Student> studentList = Utils.getStudents(humanList);

        // StringBuilder для вывода информации
        StringBuilder sb = new StringBuilder();

        // Показываем содержимое списка людей
        sb.append("Humans list:").append('\n');
        humanList.forEach(human -> sb.append(human).append('\n'));

        sb.append('\n');

        // Показываем содержимое списка студентов
        sb.append("Students list:").append('\n');
        studentList.forEach(student -> sb.append(student).append('\n'));

        sb.append('\n');

        // Сортируем список людей и показываем его
        Utils.insertSortHumans(humanList);
        sb.append("Humans list sorted by age:").append('\n');
        humanList.forEach(human -> sb.append(human).append('\n'));

        sb.append('\n');

        // Сортируем список студентов и показываем его
        Utils.insertSortStudents(studentList);
        sb.append("Students list sorted by average mark:").append('\n');
        studentList.forEach(student -> sb.append(student).append('\n'));

        // Получаем компаратор для сравнения людей
        Comparator<Human> humanComparator = Utils.getHumanComparator();
        // Получаем компаратор для сравнения студентов
        Comparator<Student> studentComparator = Utils.getStudentComparator();

        sb.append('\n');

        // Сравниваем двух людей
        sb.append(humanList.get(0).getName()).append(" ");
        if (humanComparator.compare(humanList.get(0), humanList.get(1)) > 0)
            sb.append("older then ");
        else
            sb.append("younger then ");
        sb.append(humanList.get(1).getName()).append("\n");

        // Сравниваем двух студентов
        sb.append(studentList.get(0).getName()).append(" ");
        if (studentComparator.compare(studentList.get(0), studentList.get(1)) > 0)
            sb.append("smarter then ");
        else
            sb.append("stupider then ");
        sb.append(studentList.get(1).getName()).append("\n");

        // Выводим всю информацию в файл вывода
        OutputClass.write(sb.toString(), PATH_TO_OUTPUT_FILE);
    }
}
