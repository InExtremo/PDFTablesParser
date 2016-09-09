import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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

    private static Page getAreaFromPage(String path, int page, float top, float left, float bottom, float right) throws IOException {
        return getPage(path, page).getArea(top, left, bottom, right);
    }

    private static Page getPage(String path, int pageNumber) throws IOException {
        ObjectExtractor oe = null;
        try {
            PDDocument document = PDDocument
                    .load(path);
            oe = new ObjectExtractor(document);
            Page page = oe.extract(pageNumber);
            return page;
        } finally {
            if (oe != null)
                oe.close();
        }
    }

    /**
     * Reading json from resource local path
     *
     * @param filePath path to file
     * @return String object of the text read
     * @throws IOException
     */
    public String getJsonFromResource(String filePath) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());
        return readFromFile(file);
    }

    /**
     * Reading json from resource disk path
     *
     * @param filePath path to file
     * @return String object of the text read
     * @throws IOException
     */
    public String getJsonFromFile(String filePath) {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(filePath);
        return readFromFile(file);
    }

    /**
     * return ArrayList of POJO from json
     *
     * @param jsonString json file for converting to POJO
     * @return ArrayList of POJO
     */
    public ArrayList<PagePOJO> getJsonCollection(String jsonString) {
        return gson.fromJson(jsonString, collectionType);
    }

    /**
     * Create json String from File
     *
     * @param file File whit data
     * @return String with json
     */
    private String readFromFile(File file) {
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

    public ArrayList<String> getHtmlFromJson(String filePath, String jsonObj) throws IOException {
        ArrayList<String> html = new ArrayList<>();
        ArrayList<PagePOJO> pagePOJOs = getJsonCollection(jsonObj);
        ObjectExtractor oe = null;
        try {
            PDDocument document = PDDocument
                    .load(filePath);
            oe = new ObjectExtractor(document);
            for (PagePOJO obj : pagePOJOs) {
                System.out.println(obj);
                Page page = oe.extract(obj.getPage())
                        .getArea(
                                obj.getX1(), obj.getY1(),
                                obj.getX1() + obj.getWidth(), obj.getY1() + obj.getHeight());
                SpreadsheetExtractionAlgorithm se = new SpreadsheetExtractionAlgorithm();
                boolean isTabular = se.isTabular(page);

                List<? extends Table> tables = se.extract(page);
//        StringBuffer sb = new StringBuffer();
//        sb.append("");
//        System.out.println("tables.size(): "+tables.size());
//        System.out.println("tables.get(0).getRows().size(): "+tables.get(0).getRows().size());
//        System.out.println("tables.get(0).getCols().size(): "+tables.get(0).getCols().size());
//        System.out.println("tables.get(0).getCells().size()): "+tables.get(0).getCells().size());
//        System.out.println("tables.get(0).getCell(1,1).getText(): "+tables.get(0).getCell(1,1).getText());
//        System.out.println("StringBuffer sbb: "+sb.toString());

                tables.forEach(table -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("<table border=\"1\"  width=\"100%\">\n");
                    for (int i = 0; i < table.getRows().size(); i++) {
                        sb.append("\t<tr>\n");
                        for (int j = 0; j < table.getCols().size(); j++) {
                            sb.append("\t\t<td>");
                            sb.append(table.getCell(i, j).getText());
                            sb.append("</td>\n");
                        }
                        sb.append("\t</tr>\n");
                    }
                    sb.append("</table>\n");
                    html.add(sb.toString());
                });

            }
        } finally {
            if (oe != null)
                oe.close();
        }
//         File newHtmlFile = new File("C:\\lib\\1.html");
//         FileUtils.writeStringToFile(newHtmlFile, sb.toString());
        return html;
    }
}
