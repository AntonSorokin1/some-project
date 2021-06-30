package my.project.io;

import my.project.entities.Human;
import my.project.entities.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputClass {
    private InputClass() {}

    /**
     * Читает файл по указанному пути и переводит его в список строк
     * @param filePath - абсолютный путь до файла
     * @return список строк содержащих в файле
     */
    public static List<String> read(String filePath) {
        // Список строк из файла
        List<String> lines = new ArrayList<>();
        // Берем файл по указанному абсолютному пути
        File file = IOFileManager.getFileByAbsolutePath(filePath);
        // Читаем указанный файл и запоминаем все его строки в наш список
        try (Stream<String> lineStream = new BufferedReader(new FileReader(file)).lines()) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Возвращаем список строк
        return lines;
    }

    /**
     * Переводит список строк в список объектов класса Human
     * @param lines - список строк прочитанных из файла
     * @return список объектов класса Human
     */
    public static List<Human> parse(List<String> lines) {
        List<Human> humanList = new ArrayList<>();
        // Список строк информации о текущем объекте
        List<String> temp = new ArrayList<>();
        for (String line : lines) {
            switch (line) {
                // Если в строке символ "{", то начинаем новый список строк
                case "{" : temp = new ArrayList<>(); break;
                // Если в строке символ "}", то в зависимости от количества строк, получаем человека или студента
                case "}" : humanList.add((temp.size() == 3) ? parseHuman(temp) : parseStudent(temp)); break;
                // Если строка содержит информацию об объекте, то запоминаем её
                default: temp.add(line);
            }
        }
        return humanList;
    }

    /**
     * Шаблон для разбора списка строк в объект класса Human
     * @param lines - список строк содержащие информацию об объекте
     * @return объект класса Human
     */
    private static Human parseHuman(List<String> lines) {
        String name = lines.get(0);
        String surName = lines.get(1);
        LocalDate birthday = LocalDate.parse(lines.get(2));
        return new Human(name, surName, birthday);
    }

    /**
     * Шаблон для разбора списка строк в объект класса Student
     * @param lines - список строк содержащие информацию об объекте
     * @return объект класса Student
     */
    private static Student parseStudent(List<String> lines) {
        String name = lines.get(0);
        String surName = lines.get(1);
        LocalDate birthday = LocalDate.parse(lines.get(2));
        String group = lines.get(3);
        // Берем строку оценок и разбиваем её на подстроки по разделителю " "(пробел)
        String[] marksStrings = lines.get(4).split(" ");
        // Получившийся массив строк переводим в список чисел
        List<Integer> marks = new ArrayList<>();
        Arrays.stream(marksStrings).forEach(mark -> marks.add(Integer.parseInt(mark)));
        // Возвращаем студента
        return new Student(name, surName, birthday, group, marks);
    }
}
