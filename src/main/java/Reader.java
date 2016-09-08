import java.util.ArrayList;


/**
 * Created by Max on 08.09.2016.
 */
public class Reader {
    public static void main(String[] args){

        Fabric fabric = new Fabric();
        String string = fabric.readJson("tabula_1.json");
        System.out.println(string);
        ArrayList<PagePOJO> list  = new ArrayList<>();
        list.addAll(fabric.getJsonCollection("tabula_1.json"));
        list.forEach(System.out::println);
    }

}
