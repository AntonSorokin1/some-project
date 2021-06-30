package my.project.io;

import java.io.File;
import java.util.Objects;

public class IOFileManager {
    private IOFileManager() {}

    /**
     * Берет файл по указанному пути.
     * Путь должен быть относительным для директории resources.
     * @param filePath - путь к файлу
     * @return объект класса File
     */
    public static File getFile(String filePath) {
        return new File(Objects.requireNonNull(InputClass.class.getClassLoader().getResource(filePath)).getFile());
    }

    /**
     * Берет файл по указанному пути.
     * Путь должен быть абсолютным.
     * @param filePath - путь к файлу
     * @return объект класса File
     */
    public static File getFileByAbsolutePath(String filePath) {
        return new File(filePath);
    }
}
