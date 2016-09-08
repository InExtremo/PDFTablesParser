import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Max on 08.09.2016.
 */
public class ParsingTest {
    @Test
    public void testParseJson() throws Exception {
        Fabric fabric = new Fabric();
        assertNotNull("Return array", fabric.getJsonCollection("tabula_1.json"));
    }

    @Test(expected = Exception.class)
    public void notFoundFile() throws Exception {
        Fabric fabric = new Fabric();
        assertNotNull("Return array", fabric.getJsonCollection("ss"));
    }


}
