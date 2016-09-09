package com.gofetchcode.search.tabula.utils;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Max on 09.09.2016.
 */
public class GettingHTML {
    @Test
    public void shouldReturnArray() {
        //Given:
        String jsonFile = "wj.json";
        String pdfFile = "pdf.pdf";
        FileUtils fileWorker = new FileUtils();
        String strings = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            strings = TableParserUtils.getHtmlFromJson(classLoader.getResource(pdfFile).getFile(),
                    fileWorker.getJsonFromResource(jsonFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(strings);
        assertNotNull("is return html: ", strings);
    }
}
