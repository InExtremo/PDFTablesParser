import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Max on 08.09.2016.
 */
public class Reader {
    public static void main(String[] args) throws IOException {

        Fabric fabric = new Fabric();
        String string = fabric.getJsonFromResource("tabula_1.json");
        System.out.println(string);
        ArrayList<PagePOJO> list  = new ArrayList<>();
        list.addAll(fabric.getJsonCollection(string));
        list.forEach(System.out::println);

        list.clear();
        list.addAll(fabric.getJsonCollection(fabric.getJsonFromFile("C:\\lib\\file.json")));
        System.out.println("List from file");
        list.forEach(System.out::println);

        Fabric fabric2 = new Fabric();

        System.out.println(fabric2.getHtmlFromJson("C:\\Users\\Max\\Documents\\doc\\P2013.pdf",
                fabric2.getJsonFromFile("C:\\lib\\file2_2013.json")));
    }
}
