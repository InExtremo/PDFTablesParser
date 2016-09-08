
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;
import technology.tabula.writers.CSVWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Max on 08.09.2016.
 */
public class GettingText {

    public static Page getAreaFromPage(String path, int page, float top, float left, float bottom, float right) throws IOException {
        return getPage(path, page).getArea(top, left, bottom, right);
    }

    public static Page getPage(String path, int pageNumber) throws IOException {
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

    //    {
//        page: 7
//        extraction model: spreadsheet
//        selectonID: K1473338066220
//        x1: 164.9998697895813 //top                   left
//        y1:205.0021328521732  //left                  top
//        width:406.1492893981934  //top+width = x2     right
//        height:545.3567671203614 //left+height = y2   bottom
//    }
    @Test
    public void getText() throws IOException {
        Page page = getAreaFromPage("C:\\Users\\Max\\Documents\\doc\\p.pdf", 7,
                205.0021328521732f, 164.9998697895813f,
                750.3588999725346f, 571.1491591877747f);

        SpreadsheetExtractionAlgorithm se = new SpreadsheetExtractionAlgorithm();
        boolean isTabular = se.isTabular(page);
        assertTrue(isTabular);
        List<? extends Table> tables = se.extract(page);
        StringBuilder sb = new StringBuilder();
        (new CSVWriter()).write(sb, tables.get(0));

        System.out.println(sb.toString());
        // SpreadsheetExtractionAlgorithm.findCells(page.getHorizontalRulings(), page.getVerticalRulings());
        // System.out.println( SpreadsheetExtractionAlgorithm.findCells(page.getHorizontalRulings(), page.getVerticalRulings()));
    }
}
