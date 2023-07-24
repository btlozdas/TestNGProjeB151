package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {// bu class Properties classindaki verilerin degerini verck
    /*
    .properties uzantılı dosyaya erişebilmemiz için Properties class'ından obje oluşturmamız gerekir.
    bu oluşturduğumuz obje ile akışa aldığımız dosya yolunu load(fis) methodu ile properties dosyasındaki
    key değerini return edebiliriz

    VERILERI DEPOLARIZ VE MOTHOD GIBI KEY DEGERIYLE VALUE DEGERINI CAAGIRIRZ
     */


    //--> driver'i tekrar null yapmamizin sebebi, diger methodlarda
    //--> driver'i kullanmak icin


    static Properties properties;

    static { // belleki daha iyi kullandigi icin bu sekilde kulandik static method herseyden once calisir ilk burasi calisack

        try { // dosya yolunu bulamam diye endiseleniyor kod kirmizi ciciyor ltini bu engellemek icin try catch yaptik

            FileInputStream fis = new FileInputStream("configuration.properties"); // configuration dosyasinin yolunu ekledik
            properties = new Properties(); // properties dosyasi oldugu icin properties den bir obje olusturduk
            properties.load(fis);//-->load() fis'in okuduğu bilgileri properties'e yükler

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key) {

        return properties.getProperty(key);//-->getProperty(key) methodu properties dosyasındaki key'in değerini verir
    }



   /* //2. sekil bu sekilde de calisir uzun yol -- yukarda static blog icine aldik buradan farkli daha az yer kaplar bellekte ve daha hizli calisir bu yuzden yukaridaki kullanilir
    public static String getProperty(String key) {
        try {
            FileInputStream fis = new FileInputStream("configuration.properties"); // buraya . try deedigimizde otomatik alir try catch bloguna
            properties = new Properties();
            properties.load(fis);//--> fis'in okuduğu bilgileri properties'e yükler
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);//-->getProperty(key) methodu properties dosyasındaki key'in değerini verir
    }*/
}



