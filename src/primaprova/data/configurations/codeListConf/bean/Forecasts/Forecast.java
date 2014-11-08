package primaprova.data.configurations.codeListConf.bean.Forecasts;

import org.apache.log4j.Logger;
import primaprova.data.configurations.codeListConf.bean.Forecasts.model.ForecastValueModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by fabrizio on 11/8/14.
 */
public class Forecast {


    private static final String URL_FORECASTS = "forecast.properties";

    private static final Logger LOGGER = Logger.getLogger(Forecast.class);

    private  LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>> unorderedMap;

    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>> getUnorderedMap() {
        return unorderedMap;
    }

    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>> getFoodBalanceResults() {
        return foodBalanceResults;
    }

    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>> getItyResults() {
        return ityResults;
    }

    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>> getOtherResults() {
        return otherResults;
    }

    private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>> foodBalanceResults;

    private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>> ityResults;

    private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>> otherResults;

    private Properties prop;


    private void initProperties()  {
        this.prop = new Properties();
        String propFileName = null;
        propFileName = URL_FORECASTS;
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        try {
            this.prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Forecast(){
        initProperties();
    }


    public void initData(Object[][] data){

        int commodityIndex = Integer.parseInt(this.prop.getProperty("commodity"));
        int dateIndex = Integer.parseInt(this.prop.getProperty("date"));

        this.unorderedMap  =
                new LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>>();
        for(Object[] row: data){

            String commodityCode = ""+row[commodityIndex];
            String date = ""+row[dateIndex];

            if(! this.unorderedMap.containsKey(commodityCode) && !unorderedMap.get(commodityCode).containsKey(date)) {
                LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>> semiMap =
                        createTempMap(data, commodityCode, date, commodityIndex, dateIndex);

                unorderedMap.put(commodityCode, semiMap);
            }
        }

    }


    private LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>> createTempMap(Object[][] data, String commodityCode,  String date, int commodityIndex, int dateIndex) {

        LinkedHashMap<String, ForecastValueModel> tempMap = new LinkedHashMap<String,ForecastValueModel>();
        int codeIndex = Integer.parseInt(this.prop.getProperty("code"));

        int valueIndex = Integer.parseInt(this.prop.getProperty("value"));
        int flagsIndex = Integer.parseInt(this.prop.getProperty("flags"));
        int notesIndex = Integer.parseInt(this.prop.getProperty("notes"));


        for (Object[] row : data) {

            if(row[commodityIndex].equals(commodityCode) && row[dateIndex].equals(date)){
                ForecastValueModel valueModel = new ForecastValueModel(""+row[notesIndex],""+ row[flagsIndex], +(Double)row[valueIndex]);
                tempMap.put(""+row[codeIndex],valueModel);
            }
        }

        LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>> result =  new LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>();
        result.put(date, tempMap);

        return result;

    }


}
