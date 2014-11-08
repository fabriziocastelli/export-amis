package primaprova.data.configurations.codeListConf.bean;

import org.apache.log4j.Logger;
import primaprova.data.configurations.codeListConf.utils.DataUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by fabrizio on 11/7/14.
 */
public class AMISQuery {

    private static final Logger LOGGER = Logger.getLogger(AMISQuery.class);

    private static final int[] MAIZE_AND_WHEAT_FOOD ={19,18,5,7,35,20,13,14, 15,21,34,28,29,30,31,32,33 ,10, 16 };

    private static final int[] RICE_FOOD ={19,18,998,5,7,35,20,13,14, 15, 10, 16, 21,34,28,29,30,31,32,33 };

    private static final int[] SOYBEANS_FOOD ={19,18,5,7,35,20,36,14, 15, 10, 16, 21,34,28,29,30,31,32,33 };

    private static final int[] COMMODITIES = {5,4,6,1};

    private static final String URL_NATIONAL = "national.properties";
    private static final String URL_INTERNATION = "international.properties";
    private static final String URL_OTHERS = "other.properties";

    private HashMap< Integer, HashMap<Integer, String>> foodBalanceElements;

    private HashMap< Integer, HashMap<Integer, String>> ityElements;

    private HashMap< Integer, HashMap<Integer, String>> otherElements;

    private DataUtils dataUtils;

    public  void init() throws IOException {
        try {

            initMaps( "national");
            initMaps("international");
            initMaps("others");

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    private void initMaps(String type) throws IOException {

       // InputStream inputStream = null;

         if(type.equals("national")){
             dataUtils = new DataUtils();

             Properties prop = new Properties();
             String propFileName = null;
             this.foodBalanceElements = new HashMap<Integer, HashMap<Integer, String>>();
             propFileName = URL_NATIONAL;
             InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
             prop.load(inputStream);

             System.out.println("INPUTTT");
             System.out.println(inputStream);

             this.foodBalanceElements = new HashMap<Integer, HashMap<Integer, String>>();


             dataUtils.fillMap(this.foodBalanceElements,COMMODITIES,MAIZE_AND_WHEAT_FOOD,RICE_FOOD,SOYBEANS_FOOD, prop);
             LOGGER.info("*****************************************");
             LOGGER.info("FOOD BALANCE ELEMENTS");

             LOGGER.info( this.foodBalanceElements.toString());
         }



        else if(type.equals("international")){
             dataUtils = new DataUtils();

             Properties prop = new Properties();
             String propFileName = null;
             this.ityElements = new HashMap<Integer, HashMap<Integer, String>>();
             propFileName = URL_INTERNATION;
             InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
             prop.load(inputStream);

             dataUtils.fillMap(this.ityElements,COMMODITIES,MAIZE_AND_WHEAT_FOOD,RICE_FOOD,SOYBEANS_FOOD, prop);
             LOGGER.info("*****************************************");
             LOGGER.info("ITY ELEMENTS");

             LOGGER.info(this.ityElements.toString());

         }

        else if(type.equals("others")){
             dataUtils = new DataUtils();

             Properties prop = new Properties();
             String propFileName = null;
             this.otherElements = new HashMap<Integer, HashMap<Integer, String>>();
             propFileName = URL_OTHERS;
             InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

             prop.load(inputStream);
             LOGGER.info("*****************************************");
             LOGGER.info("OTHERS ELEMENTS PROPERTIES");
             LOGGER.info(prop.toString());
             dataUtils.fillMap(this.otherElements,COMMODITIES,MAIZE_AND_WHEAT_FOOD,RICE_FOOD,SOYBEANS_FOOD, prop);


             LOGGER.info(this.otherElements.toString());

         }
    }

    public HashMap<Integer, HashMap<Integer, String>> getFoodBalanceElements() {
        return foodBalanceElements;
    }

    public HashMap<Integer, HashMap<Integer, String>> getItyElements() {
        return ityElements;
    }

    public HashMap<Integer, HashMap<Integer, String>> getOtherElements() {
        return otherElements;
    }

}
