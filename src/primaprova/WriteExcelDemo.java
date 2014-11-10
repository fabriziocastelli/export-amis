package primaprova;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import primaprova.export.data.Factory.DataFactory;
import primaprova.export.data.configurations.dataCreator.DataCreator;
import primaprova.export.data.handlerCreation.HandlerExcelCreation;
import primaprova.export.data.query.AMISQuery;
import primaprova.export.data.forecast.Forecast;
import primaprova.export.data.daoValue.DaoForecastValue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by fabrizio on 11/3/14.
 */
//import statements
public class WriteExcelDemo {


    private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(WriteExcelDemo.class);



    public static DataFactory dataFactory;



    public static void main(String[] args) {
        dataFactory = new DataFactory();

        Forecast forecast = dataFactory.getForecastIstance();

        AMISQuery qvo = dataFactory.getAMISQueryIstance();

        DataCreator fakeCostructor = dataFactory.getDataCreatorIstance();


        LOGGER.debug("FoodBalance");
        LOGGER.debug(qvo.getFoodBalanceElements().toString());
        LOGGER.debug("International");
        LOGGER.debug(qvo.getItyElements().toString());

        LOGGER.debug("othersss");
        LOGGER.debug(qvo.getOtherElements());


        LOGGER.debug("forecasts: getFoodBalanceREsults");
        LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>> map =
                forecast.getUnorderedMap();



        LOGGER.debug("Food balance Results");
        LOGGER.debug(forecast.getFoodBalanceResults().toString());


        LOGGER.debug("forecasts: getFoodBalanceREsults");

        HandlerExcelCreation excelController = new HandlerExcelCreation();
        excelController.init(forecast,qvo,fakeCostructor);


    }



    public static void exampleTaken(){

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Employee Data");

        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[]{1, "Amit", "Shukla"});
        data.put("3", new Object[]{2, "Lokesh", "Gupta"});
        data.put("4", new Object[]{3, "John", "Adwards"});
        data.put("5", new Object[]{4, "Brian", "Schultz"});

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            // create the first row
            Row row = sheet.createRow(rownum++);
            // tak array of value into the map
            Object[] objArr = data.get(key);
            int cellnum = 0;
            //for each obj into the row
            for (Object obj : objArr) {
                // create a cell
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    //for each cell, set cell value
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
            workbook.write(out);
            out.close();
            LOGGER.debug("howtodoinjava_demo.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}