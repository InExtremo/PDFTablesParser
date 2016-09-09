package tabulaTests;

import com.gofetchcode.search.tabula.utils.FileUtils;
import com.gofetchcode.search.tabula.utils.PdfUtils;
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
        FileUtils fileWorker = new FileUtils();
        ArrayList<String> strings = null;
        try {
            strings = PdfUtils.getHtmlFromJson(pdfFile, fileWorker.getJsonFromResource(jsonFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull("is return html: ", strings);
    }
}
