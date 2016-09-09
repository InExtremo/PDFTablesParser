package tabulaTests;

import com.gofetchcode.search.tabula.utils.FileUtils;
import com.gofetchcode.search.tabula.utils.JsonUtils;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Max on 08.09.2016.
 */
public class ParsingTest {
    @Test
    public void shouldParseJsonFromResourceLocal() throws Exception {
        //Given:
        String givenJson = "[{\"page\":7,\"extraction_method\":\"spreadsheet\",\"selection_id\":\"K1473338066220" +
                "\",\"x1\":164.9998697895813,\"x2\":571.1491591877747,\"y1\":205.0021328521732,\"y2\"" +
                ":750.3588999725346,\"width\":406.1492893981934,\"height\":545.3567671203614,\"spec_index\"" +
                ":0},{\"page\":8,\"extraction_method\":\"spreadsheet\",\"selection_id\":\"I1473338066236\",\"x1\"" +
                ":144.99988557266235,\"x2\":551.9140512220764,\"y1\":77.00009221038825,\"y2\"" +
                ":203.20467366180426,\"width\":406.9141656494141,\"height\":126.20458145141602,\"spec_index\":1}," +
                "{\"page\":13,\"extraction_method\":\"spreadsheet\",\"selection_id\":\"S1473338067658\",\"x1\"" +
                ":59.00025939041134,\"x2\":571.4673477082824,\"y1\":578.016983047486,\"y2\":733.2868620452887,\"width\"" +
                ":512.4670883178711,\"height\":155.26987899780275,\"spec_index\":2},{\"page\":14,\"extraction_method\"" +
                ":\"spreadsheet\",\"selection_id\":\"W1473338068089\",\"x1\":39.000275173492454,\"x2\"" +
                ":552.2322397425843,\"y1\":174.00934715270995,\"y2\":462.367693862915,\"width\":" +
                "513.2319645690918,\"height\":288.35834671020507,\"spec_index\":3},{\"page\":16,\"extraction_method\"" +
                ":\"spreadsheet\",\"selection_id\":\"U1473338068889\",\"x1\":39.000275173492454,\"x2\"" +
                ":552.2322397425843,\"y1\":559.965903518677,\"y2\":714.470906265259,\"width\"" +
                ":513.2319645690918,\"height\":154.50500274658202,\"spec_index\":4},{\"page\"" +
                ":17,\"extraction_method\":\"spreadsheet\",\"selection_id\":\"I1473338069607\",\"x1\"" +
                ":59.00025939041134,\"x2\":571.4673477082824,\"y1\":403.0132967681882,\"y2\"" +
                ":665.3658509368894,\"width\":512.4670883178711,\"height\":262.35255416870115,\"spec_index\":5}]";
        FileUtils fileWorker = new FileUtils();
        assertNotNull("Return array", fileWorker.getJsonFromFile(givenJson));

        String json = fileWorker.getJsonFromResource("tabula_1.json");
    }

    @Test
    public void shouldReturnString() throws Exception {
        //Given:
        String givenJson = "[{\"page\":7,\"extraction_method\":\"spreadsheet\",\"selection_id\":\"K1473338066220" +
                "\",\"x1\":164.9998697895813,\"x2\":571.1491591877747,\"y1\":205.0021328521732,\"y2\"" +
                ":750.3588999725346,\"width\":406.1492893981934,\"height\":545.3567671203614,\"spec_index\"" +
                ":0},{\"page\":8,\"extraction_method\":\"spreadsheet\",\"selection_id\":\"I1473338066236\",\"x1\"" +
                ":144.99988557266235,\"x2\":551.9140512220764,\"y1\":77.00009221038825,\"y2\"" +
                ":203.20467366180426,\"width\":406.9141656494141,\"height\":126.20458145141602,\"spec_index\":1}," +
                "{\"page\":13,\"extraction_method\":\"spreadsheet\",\"selection_id\":\"S1473338067658\",\"x1\"" +
                ":59.00025939041134,\"x2\":571.4673477082824,\"y1\":578.016983047486,\"y2\":733.2868620452887,\"width\"" +
                ":512.4670883178711,\"height\":155.26987899780275,\"spec_index\":2},{\"page\":14,\"extraction_method\"" +
                ":\"spreadsheet\",\"selection_id\":\"W1473338068089\",\"x1\":39.000275173492454,\"x2\"" +
                ":552.2322397425843,\"y1\":174.00934715270995,\"y2\":462.367693862915,\"width\":" +
                "513.2319645690918,\"height\":288.35834671020507,\"spec_index\":3},{\"page\":16,\"extraction_method\"" +
                ":\"spreadsheet\",\"selection_id\":\"U1473338068889\",\"x1\":39.000275173492454,\"x2\"" +
                ":552.2322397425843,\"y1\":559.965903518677,\"y2\":714.470906265259,\"width\"" +
                ":513.2319645690918,\"height\":154.50500274658202,\"spec_index\":4},{\"page\"" +
                ":17,\"extraction_method\":\"spreadsheet\",\"selection_id\":\"I1473338069607\",\"x1\"" +
                ":59.00025939041134,\"x2\":571.4673477082824,\"y1\":403.0132967681882,\"y2\"" +
                ":665.3658509368894,\"width\":512.4670883178711,\"height\":262.35255416870115,\"spec_index\":5}]";
        FileUtils fileWorker = new FileUtils();
        assertNotNull("Return array", JsonUtils.getJsonCollection(givenJson));

        String json = fileWorker.getJsonFromResource("tabula_1.json");
    }

    @Test
    public void shouldParseJsonFromFilePath() throws Exception {
        FileUtils fileWorker = new FileUtils();
        assertNotNull("Return array", JsonUtils.getJsonCollection(fileWorker.getJsonFromFile("C:\\lib\\file.json")));
    }

    @Test(expected = Exception.class)
    public void shouldNotFoundFile() throws Exception {
        JsonUtils jsonWorker = new JsonUtils();
        assertNotNull("Return array", jsonWorker.getJsonCollection("ss"));
    }


}
