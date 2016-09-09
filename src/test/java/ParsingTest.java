import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Max on 08.09.2016.
 */
public class ParsingTest {
    @Test
    public void testParseJsonFromResourceLocal() throws Exception {
        Fabric fabric = new Fabric();
        assertNotNull("Return array", fabric.getJsonCollection(fabric.getJsonFromResource("tabula_1.json")));
    }

    @Test
    public void testParseJsonFromFilePath() throws Exception {
        Fabric fabric = new Fabric();
        assertNotNull("Return array", fabric.getJsonCollection(fabric.getJsonFromFile("C:\\lib\\file.json")));
    }

    @Test(expected = Exception.class)
    public void notFoundFile() throws Exception {
        Fabric fabric = new Fabric();
        assertNotNull("Return array", fabric.getJsonCollection("ss"));
    }

    @Test
    public void te() throws IOException {
        Fabric fabric = new Fabric();

        System.out.println(fabric.getHtmlFromJson("C:\\Users\\Max\\Documents\\doc\\p.pdf", ""));
    }


}
