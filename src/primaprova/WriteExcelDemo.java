package primaprova;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import primaprova.data.DataCreator;
import primaprova.data.configurations.codeListConf.bean.AMISQuery;
import primaprova.data.configurations.codeListConf.bean.Forecasts.Forecast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by fabrizio on 11/3/14.
 */
//import statements
public class WriteExcelDemo
{
    public static void main(String[] args)
    {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        DataCreator fakeCostructor = new DataCreator();
        fakeCostructor.initData();
        Object[][] fakeData = fakeCostructor.getData();

        Forecast forecasts = new Forecast();

        forecasts.initData(fakeData);

        AMISQuery qvo = new AMISQuery();


        try {
            qvo.init();

            System.out.println("FoodBalance");
            System.out.println(qvo.getFoodBalanceElements().toString());
            System.out.println("International");
            System.out.println(qvo.getItyElements().toString());

            System.out.println("othersss");
            System.out.println(qvo.getOtherElements());
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");

        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[] {1, "Amit", "Shukla"});
        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
        data.put("4", new Object[] {3, "John", "Adwards"});
        data.put("5", new Object[] {4, "Brian", "Schultz"});

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            // create the first row
            Row row = sheet.createRow(rownum++);
            // tak array of value into the map
            Object [] objArr = data.get(key);
            int cellnum = 0;
            //for each obj into the row
            for (Object obj : objArr)
            {
                // create a cell
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    //for each cell, set cell value
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}