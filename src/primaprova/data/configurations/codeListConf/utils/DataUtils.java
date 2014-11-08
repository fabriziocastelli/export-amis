package primaprova.data.configurations.codeListConf.utils;

import org.apache.log4j.Logger;
import primaprova.data.configurations.codeListConf.bean.Forecasts.model.ForecastValueModel;

import java.util.*;

/**
 * Created by fabrizio on 11/7/14.
 */
public class DataUtils {

    private static final Logger LOGGER = Logger.getLogger(DataUtils.class);


    public void fillMap(HashMap<Integer, HashMap<Integer, String>> elementMap, int[] commodities,
                        int[] maizeAndWheatList,
                        int[] riceList, int[] soybeanList, Properties codeList) {


        LOGGER.info("***********************");
        LOGGER.info("Start fill map");

        for (int commodity : commodities) {

            HashMap<Integer, String> temporaryMap = new HashMap<Integer, String>();

            switch (commodity) {
                case 1:
                case 5:
                    fillTempMap(temporaryMap, maizeAndWheatList, codeList);
                    break;
                case 4:
                    fillTempMap(temporaryMap, riceList, codeList);
                    break;
                case 6:
                    fillTempMap(temporaryMap, soybeanList, codeList);
                    break;
            }

            elementMap.put(commodity, temporaryMap);
        }

    }

    public void fillTempMap(HashMap<Integer, String> tmp, int[] listCodes, Properties codeList) {

        for (int code : listCodes) {
            String value = codeList.getProperty(Integer.toString(code));
            if (value != null)
                tmp.put(code, value);
        }
    }


    public void fillElementsMap(LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>> toFillMap, HashMap<Integer, HashMap<Integer, String>> toFollow,
                                LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>> unorderedMap) {

        Set<Integer> commodities = toFollow.keySet();

        for (int commodity : commodities) {

            HashMap<Integer, String> semiFollow = toFollow.get(commodity);

            LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>> semiUnorderedMap = unorderedMap.get("" + commodity);

            Set<String> dates = semiUnorderedMap.keySet();

            LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>> resultWithoutCommodity = new  LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>();

            for (String date : dates) {


                LinkedHashMap<String, ForecastValueModel> codesForecastsMap= semiUnorderedMap.get(date);

                Set<String> codes = semiUnorderedMap.get(date).keySet();

                resultWithoutCommodity.put(date, fillElementsByCodes(codes, semiFollow, codesForecastsMap));

            }

            toFillMap.put(""+commodity,resultWithoutCommodity);
        }
    }

    private  LinkedHashMap<String, ForecastValueModel>fillElementsByCodes(Set<String> codes,
                                                                          HashMap<Integer, String> semiFollow,
                                                                          LinkedHashMap<String, ForecastValueModel> codesForecastsMap) {


        LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>> result = new LinkedHashMap<String, LinkedHashMap<String, ForecastValueModel>>();
        LinkedHashMap<String, ForecastValueModel> semiResult = new LinkedHashMap<String, ForecastValueModel>();

        for(String code: codes){
            if(semiFollow.containsKey(Integer.parseInt(code))){
                semiResult.put(code, codesForecastsMap.get(code));
            }
        }

        return semiResult;
    }

}


