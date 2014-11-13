package amis.commodityBalanceSheet.export.excel.entryPoint;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import amis.commodityBalanceSheet.export.data.Factory.DataFactory;
import amis.commodityBalanceSheet.export.data.configurations.dataCreator.DataCreator;
import amis.commodityBalanceSheet.export.excel.creation.handlerCreation.HandlerExcelCreation;
import amis.commodityBalanceSheet.export.data.query.AMISQuery;
import amis.commodityBalanceSheet.export.data.forecast.Forecast;
import amis.commodityBalanceSheet.export.data.daoValue.DaoForecastValue;

import java.io.File;
import java.io.FileOutputStream;
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
        Object[][] data = null;
        String dataSource = null;
        String region = null;
        String season = null;

        dataFactory = new DataFactory( data, season, dataSource,region );
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

}