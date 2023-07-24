package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    Workbook workbook; // class seviyesinde onje olusturduk dosyayolu
    Sheet sheet; // class seviyesinde obje olusturuk --sayfa--

    public ExcelReader(String dosyaYolu,String sayfaIsmi){ // constractor olusturduk  --- hangi dosya yolunu belirtirsek ve
                                                            // sayfa isimini verdigimiz verilerle verileri intelij e getirecek
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu); // yukardaki dosya yolunu akisa alir bu dosya yolunu almak icin FileInputStream class dan obje olusturduk
            workbook= WorkbookFactory.create(fis); // fis i okuyabilmek icin WorkbookFactory class dan create methodu kullanarak fis i excel de okuyabilecegiz
            sheet=workbook.getSheet(sayfaIsmi); // ya okuyamazsam endisesiyle try chtch atti
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //Satir ve sütun sayılarını girdiğimizde, O hücredeki veriyi return eden method
    public String getCellData(int satir,int sutun){
        Cell cell = sheet.getRow(satir).getCell(sutun);// cell arayuzunden obje olusturduk
        return cell.toString(); // yukarda buldugu hucreyi tostring e cevirerek return edecek
    }

    //Exceldeki satir sayısını return eden method
    public int rowCount(){
        return sheet.getLastRowNum();//sheet buldugumuz satir sayisinin getLastRowNum()->satir numaralarini verir
    }


}