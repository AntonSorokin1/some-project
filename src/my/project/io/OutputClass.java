package my.project.io;

import java.io.*;

public class OutputClass {
    private OutputClass() {}

    /**
     * Записывает указанный текст в файл по указанному абсолютному пути.
     * При записи информации в файл, вся предыдущая информация содержащаяся в нем будет удалена!
     * @param text - текст для записи в файл
     * @param filePath - абсолютный путь к файлу
     */
    public static void write(String text, String filePath) {
        // Берем файл по указанному абсолютному пути
        File file = IOFileManager.getFileByAbsolutePath(filePath);
        // Записываем информацию в указанный файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
