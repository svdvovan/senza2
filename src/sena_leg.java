import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
/**
 * Created by SretenskyVD on 27.02.2018.
 */
public class sena_leg {
    public static void main(String[] args) throws IOException {
        //      System.setProperty("javax.net.ssl.trustStore", "S:/senza.crt.jks");
        String Path = "https://www.senzarivali.ru/catalog/legginsy/";

        Document doc1 = Jsoup.connect(Path).get();
        //   Elements lHref = doc1.select("a.d_block");
        Elements lHref = doc1.getElementsByClass("item-title");
        Elements links1 = doc1.getElementsByClass("dark_link");
        Elements addressUrl = lHref.select("a[href]");
        Elements prices = doc1.getElementsByClass("current_price got_bold pink");
        Elements Names = doc1.select("a[data-product]");
        Elements id_product = doc1.getElementsByClass("fast_view_block");
//   //     Elements id_product = doc1.select("input[name = product_id]");
//        Elements id_product = doc1.select("data-param-id");
//        String idName = id_product.val();
//        System.out.print(" ; " + idName);
//        String id_product = doc1.getElementsByClass("fast_view_block").attr("data-param-id");
//        System.out.print(id_product + " ; ");


        int y = 0;
        for (Element link1 : links1) {
            String idNumber = id_product.get(y).attr("data-param-id");
            String Url = addressUrl.get(y).attr("abs:href");
            System.out.println( Url + " ; " +idNumber+ " ; " + link1.text() + " ; " );
            Document doc2 = Jsoup.connect(Url).get();
            y++;
        }

    }

}
