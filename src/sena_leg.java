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

        Elements lHref = doc1.getElementsByClass("item-title");
        Elements links1 = doc1.getElementsByClass("dark_link");
        Elements addressUrl = lHref.select("a[href]");
//        Elements prices = doc1.getElementsByClass("current_price got_bold pink");
        Elements Names = doc1.getElementsByClass("page-top-main");
        Elements id_product = doc1.getElementsByClass("fast_view_block");



        int y = 0;
        for (Element link1 : links1) {
            System.out.println();
            String idNumber = id_product.get(y).attr("data-param-id");
            String Url = addressUrl.get(y).attr("abs:href");
            Document doc2 = Jsoup.connect(Url).get();
//            String razmeres = doc2.select("meta[itemprop=sku]").attr("content");
//            System.out.println( Url + " ; " + Names.text() + " ; " +idNumber+ " ; " + link1.text() + " ; " + razmeres );

            Elements razmeres = doc2.getElementsByClass("bx_size");
            Elements Price = doc2.getElementsByClass("price discount");
            Elements Img = doc2.getElementsByClass("offers_img wof");
            Elements Nalichie = doc2.getElementsByClass("item-stock");

      //      System.out.print( Url + " ; " + Names.text() + " ; " + "sr-"  +idNumber+ " ; " + link1.text() + " ; " + Price.text() );
            System.out.print( Nalichie.text() + " ; " +  Names.text() + " ; "  +idNumber+ " ; " + link1.text() + " ; " + Price.text() );
            switch (razmeres.text()){
                case "XS-SM-L":
                    System.out.print(" ; XS ; 10 ; S ; 10 ; M ; 10 ; L ; 10 ;");
                    break;
                case "XS-S":
                    System.out.print(" ; XS ; 10 ; S ; 10 ; M ; 0 ; L ; 0 ;");
                    break;
                case "M-L":
                    System.out.print(" ; XS ; 0 ; S ; 0 ; M ; 10 ; L ; 10 ;");
            }

            System.out.print(Img.select("a[href]").attr("abs:href"));

            y++;
        }

    }

}
