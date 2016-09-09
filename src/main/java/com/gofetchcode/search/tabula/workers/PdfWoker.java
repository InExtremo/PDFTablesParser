package com.gofetchcode.search.tabula.workers;

import com.gofetchcode.search.tabula.POJOs.PagePOJO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 09.09.2016.
 */
public class PdfWoker {
    /**
     * Generating collection of HTML Strings
     *
     * @param filePath path to file on disk
     * @param jsonObj  JSON string for generation output data
     * @return collection of HTML Strings
     * @throws IOException was throw when PDF file not found at disk
     */
    public static ArrayList<String> getHtmlFromJson(String filePath, String jsonObj) throws IOException {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<PagePOJO>>() {
        }.getType();
        ArrayList<String> html = new ArrayList<>();
        ArrayList<PagePOJO> pagePOJOs = gson.fromJson(jsonObj, collectionType);
        ObjectExtractor oe = null;
        try {
            PDDocument document = PDDocument
                    .load(filePath);
            oe = new ObjectExtractor(document);
            for (PagePOJO obj : pagePOJOs) {
                Page page = oe.extract(obj.getPage())
                        .getArea(
                                obj.getY1(), obj.getX1(),
                                obj.getY1() + obj.getHeight(), obj.getX1() + obj.getWidth());
                SpreadsheetExtractionAlgorithm se = new SpreadsheetExtractionAlgorithm();

                List<? extends Table> tables = se.extract(page);

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
        return html;
    }
}
