package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
/*
POM(Page Object Model)
    Test senaryolarının daha az kod ile yazılmasına ve bakımının daha kolay yapılmasına
olanak sağlayan yazılım test yöntemidir. TestNG de ve CUCUMBER da POM kalıbını kullanırız
 */

public class Driver {
    private Driver(){  // bunu yazarak farli bir class da driver class i ile obje olusturmiyoruz. driver diyerek methodu cagirarak driver i cagirmaliyiz
        /*
        Driver class'ından obje oluşturmanın önüne geçmek için
      default constructor'ı private yaparak bunun önüne geçebiliriz.
      Bu uygulamaya singleton patter denir
         */
    }
    static WebDriver driver;
    /*
                    Driver'i her çağırdığımızda yeni bir pencere açılmasının önüne geçmek için
                if bloğu içinde Eğer driver'a değer atanmamışsa değer ata, eğer değer atanmışsa
                Driver'i aynı sayfada return et.
                 */


    /*
.properties dosyasına key olarak browser ve değerini aşağıda oluşturduğumuz switch case lerden birini seçeriz
ve sectiğimiz driver çalışır
 */

    public static WebDriver getDriver() {
        if (driver == null){ // driver null ise deger atanmadiys assagidaki web kodunu calistir ve degeri ata

            switch (ConfigReader.getProperty("browser")){ // burada ki browser key deger
                case "chrome": // key deger choreme ise burasi calicak
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();  // key deger edge ise burasi calicak
                    driver = new EdgeDriver();
                break;
                case "safari":
                    WebDriverManager.safaridriver().setup();// key deger safari ise burasi calicak
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();//// key deger firefox ise burasi calicak
                    driver = new FirefoxDriver();
                    break;
                default:

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }



            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }


        return driver; // java yukaridan assagi calisiyor bu yuzden driver bosken yeni bir pencerede istedigimiz sayfayi acti ve kod buraya geldi
                        // tekrar yeni bir sayfaya gitmek bu sayfa da acacak yine sayfayi yeni bir sayfa acilmayacak if icinde yazdigiz icin
    }
    public static void closeDriver(){ // close icin yaptik
        if (driver != null){//-->driver'a değer ATANMIŞSA
            driver.close(); // driver i kapatti
            driver = null;//-->driver'ı kapattıktan sonra boşalt
        }

    }
    public static void quitDriver(){ // quit icin yaptik
        if (driver != null){//-->driver'a değer ATANMIŞSA
            driver.quit();  // driver i kapatti
            driver = null;//-->driver'ı kapattıktan sonra boşalt null yap kitekrar driver i calistimak istedigimizde yukaridaki if calissin
        }
    }



}





