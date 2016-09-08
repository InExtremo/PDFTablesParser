import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Max on 08.09.2016.
 */
public class Fabric {
    private Gson gson;
    private Type collectionType;

    /**
     * Class for
     */
    public Fabric() {
        gson = new Gson();
        collectionType = new TypeToken<ArrayList<PagePOJO>>() {
        }.getType();

    }

    /**
     * Reading json from file path
     *
     * @param filePath path to file
     * @return String object of the text read
     * @throws IOException
     */
    public String readJson(String filePath) {

        StringBuilder result = new StringBuilder("");
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());

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
     * return ArrayList of POJO from json file
     *
     * @param filePath path to file
     * @return ArrayList of POJO
     */
    public ArrayList<PagePOJO> getJsonCollection(String filePath) {
        return gson.fromJson(readJson(filePath), collectionType);
    }
}
