package tabulaTests;

import com.gofetchcode.search.tabula.workers.FileWorker;
import com.gofetchcode.search.tabula.workers.PdfWoker;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Max on 09.09.2016.
 */
public class GettingHTML {
    @Test
    public void shouldReturnArray() {
        //Given:
        String jsonFile = "tabula_2.json";
        String pdfFile = "src/test/res/pdf.pdf";
        FileWorker fileWorker = new FileWorker();
        ArrayList<String> strings = null;
        try {
            strings = PdfWoker.getHtmlFromJson(pdfFile, fileWorker.getJsonFromResource(jsonFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull("is return html: ", strings);
    }
}
