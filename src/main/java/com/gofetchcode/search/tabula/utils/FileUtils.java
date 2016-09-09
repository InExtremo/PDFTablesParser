package com.gofetchcode.search.tabula.utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Max on 09.09.2016.
 */
public class FileUtils {
    /**
     * Create json  String from File.
     *
     * @param file File whit data
     * @return String with json
     */
    private static String readFromFile(File file) {
        StringBuilder result = new StringBuilder("");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * Reading json from resource local path.
     *
     * @param filePath path to file
     * @return String object of the text read
     * @throws IOException if PDF file not found at resource folder
     */
    public String getJsonFromResource(String filePath) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());
        return readFromFile(file);
    }

    /**
     * Reading json from resource disk path.
     *
     * @param filePath path to file
     * @return String object of the text read
     * @throws IOException if PDF file not found at disk
     */
    public String getJsonFromFile(String filePath) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(filePath);
        return readFromFile(file);
    }
}
