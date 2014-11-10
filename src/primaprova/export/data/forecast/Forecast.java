package primaprova.export.data.forecast;

import org.apache.log4j.Logger;
import primaprova.export.data.daoValue.DaoForecastValue;
import primaprova.export.data.utils.DataUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by fabrizio on 11/8/14.
 */
public class Forecast {


    private static final String URL_FORECASTS = "forecast.properties";

    private static final Logger LOGGER = Logger.getLogger(Forecast.class);

    private static final int[] COMMODITY_LIST = {1, 5, 6, 4};

    private DataUtils dataUtils;

    private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>> unorderedMap;

    private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>> foodBalanceResults;

    private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>> ityResults;

    private LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>> otherResults;

    private Properties prop;


    private void initProperties() {
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


    public Forecast() {

        initProperties();
        this.foodBalanceResults = new LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>>();
        this.ityResults  = new LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>>();
        this.otherResults = new LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>>();
    }


    public void initData(Object[][] data) {

        this.unorderedMap =
                new LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>>();

        int commodityIndex = Integer.parseInt(this.prop.getProperty("commodity"));
        int dateIndex = Integer.parseInt(this.prop.getProperty("date"));


        for (int commodity : COMMODITY_LIST) {

            LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>> semiMap =
                    new LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>();

            String commodityCode = "" + commodity;
            for (Object[] row : data) {


                if (commodityCode.equals("" + row[commodityIndex])) {
                    String date = "" + row[dateIndex];


                    if (!this.unorderedMap.containsKey(commodityCode) || (this.unorderedMap.containsKey(commodityCode) &&
                            !this.unorderedMap.get(commodityCode).containsKey(date))) {
                        LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>> temporary = createTempMap(data, commodityCode, date, commodityIndex, dateIndex);
                        semiMap.put(date, temporary.get(date));

                    }
                }
            }
            unorderedMap.put(commodityCode, semiMap);
        }


        LOGGER.debug("***************************************");
        LOGGER.debug("UNORDERED MAP");
        LOGGER.debug(unorderedMap);

    }

    // OK
    private LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>> createTempMap(
            Object[][] data, String commodityCode, String date, int commodityIndex, int dateIndex) {

        LinkedHashMap<String, DaoForecastValue> tempMap = new LinkedHashMap<String, DaoForecastValue>();
        int codeIndex = Integer.parseInt(this.prop.getProperty("code"));

        int valueIndex = Integer.parseInt(this.prop.getProperty("value"));
        int flagsIndex = Integer.parseInt(this.prop.getProperty("flags"));
        int notesIndex = Integer.parseInt(this.prop.getProperty("notes"));

        for (Object[] row : data) {
            double value;
            if (((Integer) row[commodityIndex]).equals(Integer.parseInt(commodityCode)) && ((String) row[dateIndex]).equals(date)) {

                if (row[valueIndex] instanceof Double) {

                    value = (Double) row[valueIndex];
                } else if (row[valueIndex] instanceof Integer) {
                    int tempInt = (Integer) row[valueIndex];
                    value = (double) tempInt;

                } else {
                    value = -1.0;
                }
                //          LOGGER.debug(" "+row[notesIndex]+ ", "+ row[flagsIndex]+" ,"+ valueList.get(valueList.size() - 1));
                DaoForecastValue valueModel = new DaoForecastValue("" + row[notesIndex], "" + row[flagsIndex], value);
                tempMap.put("" + row[codeIndex], valueModel);
            }
        }


        LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>> result = new LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>();

        result.put(date, tempMap);

        return result;

    }


    // OK
    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>> getUnorderedMap() {
        return unorderedMap;
    }


    public void createOrderedMaps( HashMap< Integer, HashMap<Integer, String>> listElements, String type){
        dataUtils = new DataUtils();

        if(type.equals("national")){
          dataUtils.fillElementsMap(this.foodBalanceResults,listElements,this.unorderedMap);
        }
        else if(type.equals("international")){
            dataUtils.fillElementsMap(this.ityResults,listElements,this.unorderedMap);
        }
        else{
            dataUtils.fillElementsMap(this.otherResults,listElements,this.unorderedMap);

        }
/*
        dataUtils = new DataUtils();

        Set<Integer> keyList= listElements.keySet();

        for(int commodity: keyList){

            HashMap<Integer, String> valuesList = listElements.get(commodity);

            LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>> valuesUnordered = getUnorderedMap().get(""+commodity);

            Set<String> dates = valuesUnordered.keySet();

            LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>> mapWithDate  = new LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>();
            for(String date: dates){

                LinkedHashMap<String, DaoForecastValue> elementsValues =  valuesUnordered.get(date);

                LinkedHashMap<String, DaoForecastValue> mapWithoutDate = dataUtils.compareAndCreateSemiMap(valuesList,elementsValues);

                mapWithDate.put(date, mapWithoutDate);
            }
            if(type.equals("national")){
                this.foodBalanceResults.put(""+commodity,mapWithDate);
            }
            else if(type.equals("international")){
                this.ityResults.put(""+commodity,mapWithDate);
            }
            else{
                this.otherResults.put(""+commodity,mapWithDate);

            }*/

    }



    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>> getFoodBalanceResults() {
        return foodBalanceResults;
    }


    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>> getItyResults() {
        return ityResults;
    }


    public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>>> getOtherResults() {
        return otherResults;
    }


    public int[] getCommodityList(){
        return this.COMMODITY_LIST;
    }


}
