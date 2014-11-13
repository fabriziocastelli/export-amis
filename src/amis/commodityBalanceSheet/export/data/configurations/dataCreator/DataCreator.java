package amis.commodityBalanceSheet.export.data.configurations.dataCreator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by fabrizio on 11/5/14.
 */


public class DataCreator {


    private LinkedHashMap<String, LinkedHashMap<String, Map<String, Double>>> mapWithoutSemanticOrder;

    private Object[][] data;

    private Object[][] dataTrue;

    private String dataSourceTrue, seasonTrue, regionTrue;

    private String datasource, season, country;

    public DataCreator(Object[][] dataTrue, String season, String dataSource, String region) {
        this.dataTrue = dataTrue;
        this.dataSourceTrue = dataSource;
        this.seasonTrue = season;
        this.regionTrue = region;
    }


    public void initData() {

        this.data = new Object[][]

            /*    {
                        {1,"2013-07-15",14,500,null,"This is something to try a note with asdasdasdsadsadasdsadsa,asdsadasd" +
                                "asdasdasd" +
                                "asdasdasdasd"},
                        {1,"2013-07-15",42,null,null,null},
                        {1,"2013-07-15",32,null,null,null},
                        {1,"2013-07-15",15,130,null,null},
                        {1,"2013-07-15",43,null,null,null},
                        {1,"2013-07-15",37,null,null,null},
                        {1,"2013-07-15",35,13870,null,"This is something to try a note with asdasdasdsadsadasdsadsa,asdsadasd" +
                         "asdasdasdasdasdasdasd"},
                        {1,"2013-07-15",20,5270,null,null},
                        {1,"2013-07-15",17,null,null,null},
                       {1,"2013-07-15",13,null,null,null},
                        {1,"2013-07-15",25,123.2,null,null},
                        {1,"2013-07-15",41,null,null,null},
                        {1,"2013-07-15",2,6050,null,null},
                        {1,"2013-07-15",38,null,null,null},
                        {1,"2013-07-15",39,null,null,null},
                        {1,"2013-07-15",12,5780,null,null},
                        {1,"2013-07-15",19,13870,null,null},
                        {1,"2013-07-15",36,null,null,null},
                        {1,"2013-07-15",8,3,null,null},
                        {1,"2013-07-15",27,13870,null,null},
                        {1,"2013-07-15",34,null,null,null},
                        {1,"2013-07-15",21,null,null,null},
                        {1,"2013-07-15",30,null,null,null},
                        {1,"2013-07-15",16,2360,null,null},
                        {1,"2013-07-15",18,1570,null,null},
                        {1,"2013-07-15",3,null,null,null},
                        {1,"2013-07-15",5,12300,null,null},
                        {1,"2013-07-15",28,null,null,null},
                        {1,"2013-07-15",4,2.03,null,null},
                        {1,"2013-07-15",10,6220,null,null},
                        {1,"2013-07-15",7,3,null,null},
                        {1,"2013-07-15",40,null,null,null},
                        {4,"2013-07-15",39,null,null,null},
                        {4,"2013-07-15",36,null,null,null},
                        {4,"2013-07-15",25,6.37,null,null},
                        {4,"2013-07-15",37,null,null,null},
                        {4,"2013-07-15",15,30,null,null},
                        {4,"2013-07-15",30,null,null,null},
                        {4,"2013-07-15",42,null,null,null},
                        {4,"2013-07-15",8,10,null,null},
                        {4,"2013-07-15",34,null,null,null},
                        {4,"2013-07-15",19,650,null,null},
                        {4,"2013-07-15",43,null,null,null},
                        {4,"2013-07-15",32,null,null,null},
                        {4,"2013-07-15",4,6.01,null,null},
                        {4,"2013-07-15",14,10,null,null},
                        {4,"2013-07-15",40,null,null,null},
                        {4,"2013-07-15",35,650,null,null},
                        {4,"2013-07-15",3,65,null,null},
                        {4,"2013-07-15",13,null,null,null},
                        {4,"2013-07-15",5,460,null,null},
                        {4,"2013-07-15",20,280,null,null},
                        {4,"2013-07-15",18,180,null,null},
                        {4,"2013-07-15",7,10,null,null},
                        {4,"2013-07-15",2,120,null,null},
                        {4,"2013-07-15",10,210,null,null},
                        {4,"2013-07-15",17,null,null,null},
                        {4,"2013-07-15",27,640,null,null},
                        {4,"2013-07-15",21,null,null,null},
                        {4,"2013-07-15",16,160,null,null},
                        {4,"2013-07-15",38,null,null,null},
                        {4,"2013-07-15",41,null,null,null},
                        {4,"2013-07-15",12,190,null,null},
                        {4,"2013-07-15",28,null,null,null},
                        {5,"2013-07-15",20,4300,null,null},
                        {5,"2013-07-15",36,null,null,null},
                        {5,"2013-07-15",34,null,null,null},
                        {5,"2013-07-15",28,null,null,null},
                        {5,"2013-07-15",30,null,null,null},
                        {5,"2013-07-15",32,null,null,null},
                        {5,"2013-07-15",38,null,null,null},
                        {5,"2013-07-15",39,null,null,null},
                        {5,"2013-07-15",27,15420,null,null},
                        {5,"2013-07-15",21,null,null,null},
                        {5,"2013-07-15",18,380,null,null},
                        {5,"2013-07-15",5,15040,null,null},
                        {5,"2013-07-15",17,null,null,null},
                        {5,"2013-07-15",7,3,null,null},
                        {5,"2013-07-15",4,6.07,null,null},
                        {5,"2013-07-15",3,null,null,null},
                        {5,"2013-07-15",25,6.9,null,null},
                        {5,"2013-07-15",42,null,null,null},
                        {5,"2013-07-15",43,null,null,null},
                        {5,"2013-07-15",19,15420,null,null},
                        {5,"2013-07-15",35,15420,null,null},
                        {5,"2013-07-15",13,null,null,null},
                        {5,"2013-07-15",14,null,null,null},
                        {5,"2013-07-15",15,500,null,null},
                        {5,"2013-07-15",10,10680,null,null},
                        {5,"2013-07-15",16,440,null,null},
                        {5,"2013-07-15",8,3,null,null},
                        {5,"2013-07-15",12,11660,null,null},
                        {5,"2013-07-15",2,2420,null,null},
                        {5,"2013-07-15",37,null,null,null},
                        {5,"2013-07-15",40,null,null,null},
                        {5,"2013-07-15",41,null,null,null},
                        {6,"2013-07-15",21,null,null,null},
                        {6,"2013-07-15",10,8780,null,null},
                        {6,"2013-07-15",7,400,null,null},
                        {6,"2013-07-15",5,34820,null,null},
                        {6,"2013-07-15",40,null,null,null},
                        {6,"2013-07-15",16,2730,null,null},
                        {6,"2013-07-15",18,1970,null,null},
                        {6,"2013-07-15",28,null,null,null},
                        {6,"2013-07-15",30,null,null,null},
                        {6,"2013-07-15",8,380,null,null},
                        {6,"2013-07-15",27,36790,null,null},
                        {6,"2013-07-15",19,37190,null,null},
                        {6,"2013-07-15",34,null,null,null},
                        {6,"2013-07-15",12,8600,null,null},
                        {6,"2013-07-15",14,null,null,null},
                        {6,"2013-07-15",39,null,null,null},
                        {6,"2013-07-15",3,null,null,null},
                        {6,"2013-07-15",2,12800,null,null},
                        {6,"2013-07-15",38,null,null,null},
                        {6,"2013-07-15",25,4.88,null,null},
                        {6,"2013-07-15",41,null,null,null},
                        {6,"2013-07-15",37,null,null,null},
                        {6,"2013-07-15",13,null,null,null},
                        {6,"2013-07-15",20,25670,null,null},
                        {6,"2013-07-15",17,null,null,null},
                        {6,"2013-07-15",4,2.72,null,null},
                        {6,"2013-07-15",35,37190,null,null},
                        {6,"2013-07-15",36,24810,null,null},
                        {6,"2013-07-15",32,null,null,null},
                        {6,"2013-07-15",15,680,null,null},
                        {6,"2013-07-15",43,null,null,null},
                        {6,"2013-07-15",42,null,null,null}
                };*/

                {
                        {
                                1,
                                4,
                                "Tonnes/Ha",
                                "20000103",
                                2.67,
                                "",
                                null
                        },
                        {
                                1,
                                3,
                                "%",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                36,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                28,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                32,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                17,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                25,
                                "Kg/Yr",
                                "20000103",
                                107.95,
                                "",
                                null
                        },
                        {
                                1,
                                38,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                39,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                19,
                                "Thousand tonnes",
                                "20000103",
                                9700,
                                "",
                                null
                        },
                        {
                                1,
                                27,
                                "Thousand tonnes",
                                "20000103",
                                9700,
                                "",
                                null
                        },
                        {
                                1,
                                21,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                34,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                30,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                18,
                                "Thousand tonnes",
                                "20000103",
                                680,
                                "",
                                null
                        },
                        {
                                1,
                                5,
                                "Thousand tonnes",
                                "20000103",
                                9020,
                                "",
                                null
                        },
                        {
                                1,
                                7,
                                "Thousand tonnes",
                                "20000103",
                                3,
                                "",
                                null
                        },
                        {
                                1,
                                42,
                                "Tonnes/Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                43,
                                "Tonnes/Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                35,
                                "Thousand tonnes",
                                "20000103",
                                9700,
                                "",
                                null
                        },
                        {
                                1,
                                20,
                                "Thousand tonnes",
                                "20000103",
                                5060,
                                "",
                                null
                        },
                        {
                                1,
                                13,
                                "Thousand tonnes",
                                "20000103",
                                4340,
                                "",
                                null
                        },
                        {
                                1,
                                14,
                                "Thousand tonnes",
                                "20000103",
                                600,
                                "",
                                null
                        },
                        {
                                1,
                                15,
                                "Thousand tonnes",
                                "20000103",
                                120,
                                "",
                                null
                        },
                        {
                                1,
                                10,
                                "Thousand tonnes",
                                "20000103",
                                4190,
                                "",
                                null
                        },
                        {
                                1,
                                16,
                                "Thousand tonnes",
                                "20000103",
                                440,
                                "",
                                null
                        },
                        {
                                1,
                                8,
                                "Thousand tonnes",
                                "20000103",
                                3,
                                "",
                                null
                        },
                        {
                                1,
                                12,
                                "Thousand tonnes",
                                "20000103",
                                5050,
                                "",
                                null
                        },
                        {
                                1,
                                2,
                                "Thousand Ha",
                                "20000103",
                                3260,
                                "",
                                null
                        },
                        {
                                1,
                                37,
                                "Thousand Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                40,
                                "Thousand Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                41,
                                "Thousand Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                1,
                                "1000s",
                                "20000103",
                                40276,
                                "",
                                null
                        },
                        {
                                1,
                                21,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                34,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                28,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                30,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                32,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                17,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                38,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                39,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                36,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                19,
                                "Thousand tonnes",
                                "20130715",
                                15320,
                                "",
                                null
                        },
                        {
                                1,
                                27,
                                "Thousand tonnes",
                                "20130715",
                                15320,
                                "",
                                null
                        },
                        {
                                1,
                                18,
                                "Thousand tonnes",
                                "20130715",
                                820,
                                "",
                                null
                        },
                        {
                                1,
                                5,
                                "Thousand tonnes",
                                "20130715",
                                14500,
                                "",
                                null
                        },
                        {
                                1,
                                4,
                                "Tonnes/Ha",
                                "20130715",
                                3,
                                "",
                                null
                        },
                        {
                                1,
                                3,
                                "%",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                25,
                                "Kg/Yr",
                                "20130715",
                                153.38,
                                "",
                                null
                        },
                        {
                                1,
                                42,
                                "Tonnes/Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                43,
                                "Tonnes/Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                7,
                                "Thousand tonnes",
                                "20130715",
                                3,
                                "",
                                null
                        },
                        {
                                1,
                                35,
                                "Thousand tonnes",
                                "20130715",
                                15320,
                                "",
                                null
                        },
                        {
                                1,
                                20,
                                "Thousand tonnes",
                                "20130715",
                                6700,
                                "",
                                null
                        },
                        {
                                1,
                                13,
                                "Thousand tonnes",
                                "20130715",
                                6300,
                                "",
                                null
                        },
                        {
                                1,
                                14,
                                "Thousand tonnes",
                                "20130715",
                                300,
                                "",
                                null
                        },
                        {
                                1,
                                15,
                                "Thousand tonnes",
                                "20130715",
                                100,
                                "",
                                null
                        },
                        {
                                1,
                                10,
                                "Thousand tonnes",
                                "20130715",
                                7850,
                                "",
                                null
                        },
                        {
                                1,
                                16,
                                "Thousand tonnes",
                                "20130715",
                                770,
                                "",
                                null
                        },
                        {
                                1,
                                8,
                                "Thousand tonnes",
                                "20130715",
                                3,
                                "",
                                null
                        },
                        {
                                1,
                                12,
                                "Thousand tonnes",
                                "20130715",
                                11530,
                                "",
                                null
                        },
                        {
                                1,
                                2,
                                "Thousand Ha",
                                "20130715",
                                4400,
                                "",
                                null
                        },
                        {
                                1,
                                37,
                                "Thousand Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                40,
                                "Thousand Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                41,
                                "Thousand Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                1,
                                1,
                                "1000s",
                                "20130715",
                                41074,
                                "",
                                null
                        },
                        {
                                4,
                                36,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                34,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                28,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                30,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                32,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                17,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                38,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                39,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                19,
                                "Thousand tonnes",
                                "20000103",
                                910,
                                "",
                                null
                        },
                        {
                                4,
                                27,
                                "Thousand tonnes",
                                "20000103",
                                900,
                                "",
                                null
                        },
                        {
                                4,
                                21,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                18,
                                "Thousand tonnes",
                                "20000103",
                                90,
                                "",
                                null
                        },
                        {
                                4,
                                5,
                                "Thousand tonnes",
                                "20000103",
                                800,
                                "",
                                null
                        },
                        {
                                4,
                                7,
                                "Thousand tonnes",
                                "20000103",
                                10,
                                "",
                                null
                        },
                        {
                                4,
                                4,
                                "Tonnes/Ha",
                                "20000103",
                                7.26,
                                "",
                                null
                        },
                        {
                                4,
                                3,
                                "%",
                                "20000103",
                                65,
                                "",
                                null
                        },
                        {
                                4,
                                25,
                                "Kg/Yr",
                                "20000103",
                                7.94,
                                "",
                                null
                        },
                        {
                                4,
                                42,
                                "Tonnes/Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                43,
                                "Tonnes/Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                35,
                                "Thousand tonnes",
                                "20000103",
                                910,
                                "",
                                null
                        },
                        {
                                4,
                                20,
                                "Thousand tonnes",
                                "20000103",
                                360,
                                "",
                                null
                        },
                        {
                                4,
                                13,
                                "Thousand tonnes",
                                "20000103",
                                320,
                                "",
                                null
                        },
                        {
                                4,
                                14,
                                "Thousand tonnes",
                                "20000103",
                                10,
                                "",
                                null
                        },
                        {
                                4,
                                15,
                                "Thousand tonnes",
                                "20000103",
                                30,
                                "",
                                null
                        },
                        {
                                4,
                                10,
                                "Thousand tonnes",
                                "20000103",
                                480,
                                "",
                                null
                        },
                        {
                                4,
                                16,
                                "Thousand tonnes",
                                "20000103",
                                60,
                                "",
                                null
                        },
                        {
                                4,
                                8,
                                "Thousand tonnes",
                                "20000103",
                                10,
                                "",
                                null
                        },
                        {
                                4,
                                12,
                                "Thousand tonnes",
                                "20000103",
                                490,
                                "",
                                null
                        },
                        {
                                4,
                                2,
                                "Thousand Ha",
                                "20000103",
                                190,
                                "",
                                null
                        },
                        {
                                4,
                                37,
                                "Thousand Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                40,
                                "Thousand Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                41,
                                "Thousand Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                1,
                                "1000s",
                                "20000103",
                                40276,
                                "",
                                null
                        },
                        {
                                4,
                                36,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                34,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                28,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                30,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                32,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                17,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                38,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                39,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                19,
                                "Thousand tonnes",
                                "20130715",
                                1170,
                                "",
                                null
                        },
                        {
                                4,
                                27,
                                "Thousand tonnes",
                                "20130715",
                                1170,
                                "",
                                null
                        },
                        {
                                4,
                                21,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                18,
                                "Thousand tonnes",
                                "20130715",
                                60,
                                "",
                                null
                        },
                        {
                                4,
                                5,
                                "Thousand tonnes",
                                "20130715",
                                1100,
                                "",
                                null
                        },
                        {
                                4,
                                7,
                                "Thousand tonnes",
                                "20130715",
                                6,
                                "",
                                null
                        },
                        {
                                4,
                                4,
                                "Tonnes/Ha",
                                "20130715",
                                5.69,
                                "",
                                null
                        },
                        {
                                4,
                                3,
                                "%",
                                "20130715",
                                65,
                                "",
                                null
                        },
                        {
                                4,
                                25,
                                "Kg/Yr",
                                "20130715",
                                10.71,
                                "",
                                null
                        },
                        {
                                4,
                                42,
                                "Tonnes/Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                43,
                                "Tonnes/Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                35,
                                "Thousand tonnes",
                                "20130715",
                                1170,
                                "",
                                null
                        },
                        {
                                4,
                                20,
                                "Thousand tonnes",
                                "20130715",
                                520,
                                "",
                                null
                        },
                        {
                                4,
                                13,
                                "Thousand tonnes",
                                "20130715",
                                440,
                                "",
                                null
                        },
                        {
                                4,
                                14,
                                "Thousand tonnes",
                                "20130715",
                                30,
                                "",
                                null
                        },
                        {
                                4,
                                15,
                                "Thousand tonnes",
                                "20130715",
                                50,
                                "",
                                null
                        },
                        {
                                4,
                                10,
                                "Thousand tonnes",
                                "20130715",
                                540,
                                "",
                                null
                        },
                        {
                                4,
                                16,
                                "Thousand tonnes",
                                "20130715",
                                110,
                                "",
                                null
                        },
                        {
                                4,
                                8,
                                "Thousand tonnes",
                                "20130715",
                                9,
                                "",
                                null
                        },
                        {
                                4,
                                12,
                                "Thousand tonnes",
                                "20130715",
                                630,
                                "",
                                null
                        },
                        {
                                4,
                                2,
                                "Thousand Ha",
                                "20130715",
                                250,
                                "",
                                null
                        },
                        {
                                4,
                                37,
                                "Thousand Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                40,
                                "Thousand Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                41,
                                "Thousand Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                4,
                                1,
                                "1000s",
                                "20130715",
                                41074,
                                "",
                                null
                        },
                        {
                                5,
                                4,
                                "Tonnes/Ha",
                                "20000103",
                                5.57,
                                null,
                                null
                        },
                        {
                                5,
                                3,
                                "%",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                36,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                34,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                28,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                30,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                32,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                25,
                                "Kg/Yr",
                                "20000103",
                                7.2,
                                null,
                                null
                        },
                        {
                                5,
                                38,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                39,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                19,
                                "Thousand tonnes",
                                "20000103",
                                26500,
                                null,
                                null
                        },
                        {
                                5,
                                27,
                                "Thousand tonnes",
                                "20000103",
                                26490,
                                null,
                                null
                        },
                        {
                                5,
                                21,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                18,
                                "Thousand tonnes",
                                "20000103",
                                3810,
                                null,
                                null
                        },
                        {
                                5,
                                5,
                                "Thousand tonnes",
                                "20000103",
                                22680,
                                null,
                                null
                        },
                        {
                                5,
                                17,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                7,
                                "Thousand tonnes",
                                "20000103",
                                4,
                                null,
                                null
                        },
                        {
                                5,
                                42,
                                "Tonnes/Ha",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                43,
                                "Tonnes/Ha",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                35,
                                "Thousand tonnes",
                                "20000103",
                                26500,
                                null,
                                null
                        },
                        {
                                5,
                                20,
                                "Thousand tonnes",
                                "20000103",
                                6940,
                                null,
                                null
                        },
                        {
                                5,
                                13,
                                "Thousand tonnes",
                                "20000103",
                                290,
                                null,
                                null
                        },
                        {
                                5,
                                14,
                                "Thousand tonnes",
                                "20000103",
                                5700,
                                null,
                                null
                        },
                        {
                                5,
                                15,
                                "Thousand tonnes",
                                "20000103",
                                950,
                                null,
                                null
                        },
                        {
                                5,
                                10,
                                "Thousand tonnes",
                                "20000103",
                                15710,
                                null,
                                null
                        },
                        {
                                5,
                                16,
                                "Thousand tonnes",
                                "20000103",
                                3850,
                                null,
                                null
                        },
                        {
                                5,
                                8,
                                "Thousand tonnes",
                                "20000103",
                                4,
                                null,
                                null
                        },
                        {
                                5,
                                12,
                                "Thousand tonnes",
                                "20000103",
                                12960,
                                null,
                                null
                        },
                        {
                                5,
                                2,
                                "Thousand Ha",
                                "20000103",
                                2350,
                                null,
                                null
                        },
                        {
                                5,
                                37,
                                "Thousand Ha",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                40,
                                "Thousand Ha",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                41,
                                "Thousand Ha",
                                "20000103",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                1,
                                "1000s",
                                "20000103",
                                40276,
                                "",
                                null
                        },
                        {
                                5,
                                19,
                                "Thousand tonnes",
                                "20130715",
                                26500,
                                null,
                                null
                        },
                        {
                                5,
                                19,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                27,
                                "Thousand tonnes",
                                "20130715",
                                26490,
                                null,
                                null
                        },
                        {
                                5,
                                27,
                                "Thousand tonnes",
                                "20130715",
                                26490,
                                null,
                                null
                        },
                        {
                                5,
                                27,
                                "Thousand tonnes",
                                "20130715",
                                26490,
                                null,
                                null
                        },
                        {
                                5,
                                27,
                                "Thousand tonnes",
                                "20130715",
                                26490,
                                null,
                                null
                        },
                        {
                                5,
                                27,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                18,
                                "Thousand tonnes",
                                "20130715",
                                3810,
                                null,
                                null
                        },
                        {
                                5,
                                18,
                                "Thousand tonnes",
                                "20130715",
                                3810,
                                null,
                                null
                        },
                        {
                                5,
                                18,
                                "Thousand tonnes",
                                "20130715",
                                3810,
                                null,
                                null
                        },
                        {
                                5,
                                18,
                                "Thousand tonnes",
                                "20130715",
                                3810,
                                null,
                                null
                        },
                        {
                                5,
                                18,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                5,
                                "Thousand tonnes",
                                "20130715",
                                22680,
                                null,
                                null
                        },
                        {
                                5,
                                5,
                                "Thousand tonnes",
                                "20130715",
                                22680,
                                null,
                                null
                        },
                        {
                                5,
                                5,
                                "Thousand tonnes",
                                "20130715",
                                22680,
                                null,
                                null
                        },
                        {
                                5,
                                5,
                                "Thousand tonnes",
                                "20130715",
                                22680,
                                null,
                                null
                        },
                        {
                                5,
                                5,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                7,
                                "Thousand tonnes",
                                "20130715",
                                4,
                                null,
                                null
                        },
                        {
                                5,
                                7,
                                "Thousand tonnes",
                                "20130715",
                                4,
                                null,
                                null
                        },
                        {
                                5,
                                7,
                                "Thousand tonnes",
                                "20130715",
                                4,
                                null,
                                null
                        },
                        {
                                5,
                                7,
                                "Thousand tonnes",
                                "20130715",
                                4,
                                null,
                                null
                        },
                        {
                                5,
                                7,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                35,
                                "Thousand tonnes",
                                "20130715",
                                26500,
                                null,
                                null
                        },
                        {
                                5,
                                35,
                                "Thousand tonnes",
                                "20130715",
                                26500,
                                null,
                                null
                        },
                        {
                                5,
                                35,
                                "Thousand tonnes",
                                "20130715",
                                26500,
                                null,
                                null
                        },
                        {
                                5,
                                35,
                                "Thousand tonnes",
                                "20130715",
                                26500,
                                null,
                                null
                        },
                        {
                                5,
                                35,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                20,
                                "Thousand tonnes",
                                "20130715",
                                6940,
                                null,
                                null
                        },
                        {
                                5,
                                20,
                                "Thousand tonnes",
                                "20130715",
                                6940,
                                null,
                                null
                        },
                        {
                                5,
                                20,
                                "Thousand tonnes",
                                "20130715",
                                6940,
                                null,
                                null
                        },
                        {
                                5,
                                20,
                                "Thousand tonnes",
                                "20130715",
                                6940,
                                null,
                                null
                        },
                        {
                                5,
                                20,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                14,
                                "Thousand tonnes",
                                "20130715",
                                5700,
                                null,
                                null
                        },
                        {
                                5,
                                14,
                                "Thousand tonnes",
                                "20130715",
                                5700,
                                null,
                                null
                        },
                        {
                                5,
                                14,
                                "Thousand tonnes",
                                "20130715",
                                5700,
                                null,
                                null
                        },
                        {
                                5,
                                14,
                                "Thousand tonnes",
                                "20130715",
                                5700,
                                null,
                                null
                        },
                        {
                                5,
                                14,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                13,
                                "Thousand tonnes",
                                "20130715",
                                290,
                                null,
                                null
                        },
                        {
                                5,
                                13,
                                "Thousand tonnes",
                                "20130715",
                                290,
                                null,
                                null
                        },
                        {
                                5,
                                13,
                                "Thousand tonnes",
                                "20130715",
                                290,
                                null,
                                null
                        },
                        {
                                5,
                                13,
                                "Thousand tonnes",
                                "20130715",
                                290,
                                null,
                                null
                        },
                        {
                                5,
                                13,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                15,
                                "Thousand tonnes",
                                "20130715",
                                6,
                                "C",
                                null
                        },
                        {
                                5,
                                15,
                                "Thousand tonnes",
                                "20130715",
                                6,
                                "C",
                                null
                        },
                        {
                                5,
                                15,
                                "Thousand tonnes",
                                "20130715",
                                6,
                                "C",
                                null
                        },
                        {
                                5,
                                15,
                                "Thousand tonnes",
                                "20130715",
                                6,
                                "C",
                                null
                        },
                        {
                                5,
                                15,
                                "Thousand tonnes",
                                "20141105",
                                6,
                                "C",
                                "first"
                        },
                        {
                                5,
                                10,
                                "Thousand tonnes",
                                "20130715",
                                15710,
                                null,
                                null
                        },
                        {
                                5,
                                10,
                                "Thousand tonnes",
                                "20130715",
                                15710,
                                null,
                                null
                        },
                        {
                                5,
                                10,
                                "Thousand tonnes",
                                "20130715",
                                15710,
                                null,
                                null
                        },
                        {
                                5,
                                10,
                                "Thousand tonnes",
                                "20130715",
                                15710,
                                null,
                                null
                        },
                        {
                                5,
                                10,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                16,
                                "Thousand tonnes",
                                "20130715",
                                3850,
                                null,
                                null
                        },
                        {
                                5,
                                16,
                                "Thousand tonnes",
                                "20130715",
                                3850,
                                null,
                                null
                        },
                        {
                                5,
                                16,
                                "Thousand tonnes",
                                "20130715",
                                3850,
                                null,
                                null
                        },
                        {
                                5,
                                16,
                                "Thousand tonnes",
                                "20130715",
                                3850,
                                null,
                                null
                        },
                        {
                                5,
                                16,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                8,
                                "Thousand tonnes",
                                "20130715",
                                4,
                                null,
                                null
                        },
                        {
                                5,
                                8,
                                "Thousand tonnes",
                                "20130715",
                                4,
                                null,
                                null
                        },
                        {
                                5,
                                8,
                                "Thousand tonnes",
                                "20130715",
                                4,
                                null,
                                null
                        },
                        {
                                5,
                                8,
                                "Thousand tonnes",
                                "20130715",
                                4,
                                null,
                                null
                        },
                        {
                                5,
                                8,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                12,
                                "Thousand tonnes",
                                "20130715",
                                12960,
                                null,
                                null
                        },
                        {
                                5,
                                12,
                                "Thousand tonnes",
                                "20130715",
                                12960,
                                null,
                                null
                        },
                        {
                                5,
                                12,
                                "Thousand tonnes",
                                "20130715",
                                12960,
                                null,
                                null
                        },
                        {
                                5,
                                12,
                                "Thousand tonnes",
                                "20130715",
                                12960,
                                null,
                                null
                        },
                        {
                                5,
                                12,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                17,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                2,
                                "Thousand Ha",
                                "20130715",
                                2350,
                                "C,F",
                                null
                        },
                        {
                                5,
                                2,
                                "Thousand Ha",
                                "20130715",
                                2350,
                                "C,F",
                                null
                        },
                        {
                                5,
                                2,
                                "Thousand Ha",
                                "20130715",
                                2350,
                                "C,F",
                                null
                        },
                        {
                                5,
                                2,
                                "Thousand Ha",
                                "20130715",
                                2350,
                                "C,F",
                                null
                        },
                        {
                                5,
                                2,
                                "Thousand Ha",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                37,
                                "Thousand Ha",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                4,
                                "Tonnes/Ha",
                                "20130715",
                                5.57,
                                null,
                                null
                        },
                        {
                                5,
                                19,
                                "Thousand tonnes",
                                "20130715",
                                26500,
                                null,
                                null
                        },
                        {
                                5,
                                19,
                                "Thousand tonnes",
                                "20130715",
                                26500,
                                null,
                                null
                        },
                        {
                                5,
                                19,
                                "Thousand tonnes",
                                "20130715",
                                26500,
                                null,
                                null
                        },
                        {
                                5,
                                28,
                                "Thousand tonnes",
                                "20130715",
                                3,
                                null,
                                null
                        },
                        {
                                5,
                                21,
                                "Thousand tonnes",
                                "20130715",
                                1,
                                null,
                                null
                        },
                        {
                                5,
                                34,
                                "Thousand tonnes",
                                "20130715",
                                2,
                                null,
                                null
                        },
                        {
                                5,
                                32,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                30,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                28,
                                "Thousand tonnes",
                                "20130715",
                                3,
                                null,
                                null
                        },
                        {
                                5,
                                34,
                                "Thousand tonnes",
                                "20130715",
                                2,
                                null,
                                null
                        },
                        {
                                5,
                                4,
                                "Tonnes/Ha",
                                "20130715",
                                5.57,
                                null,
                                null
                        },
                        {
                                5,
                                32,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                30,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                28,
                                "Thousand tonnes",
                                "20130715",
                                3,
                                null,
                                null
                        },
                        {
                                5,
                                21,
                                "Thousand tonnes",
                                "20130715",
                                1,
                                null,
                                null
                        },
                        {
                                5,
                                21,
                                "Thousand tonnes",
                                "20130715",
                                1,
                                null,
                                null
                        },
                        {
                                5,
                                4,
                                "Tonnes/Ha",
                                "20130715",
                                5.57,
                                null,
                                null
                        },
                        {
                                5,
                                34,
                                "Thousand tonnes",
                                "20130715",
                                2,
                                null,
                                null
                        },
                        {
                                5,
                                4,
                                "Tonnes/Ha",
                                "20130715",
                                5.57,
                                null,
                                null
                        },
                        {
                                5,
                                34,
                                "Thousand tonnes",
                                "20130715",
                                2,
                                null,
                                null
                        },
                        {
                                5,
                                32,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                32,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                30,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                28,
                                "Thousand tonnes",
                                "20130715",
                                3,
                                null,
                                null
                        },
                        {
                                5,
                                21,
                                "Thousand tonnes",
                                "20130715",
                                1,
                                null,
                                null
                        },
                        {
                                5,
                                30,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                4,
                                "Tonnes/Ha",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                25,
                                "Kg/Yr",
                                "20130715",
                                7.2,
                                null,
                                null
                        },
                        {
                                5,
                                25,
                                "Kg/Yr",
                                "20130715",
                                7.2,
                                null,
                                null
                        },
                        {
                                5,
                                25,
                                "Kg/Yr",
                                "20130715",
                                7.2,
                                null,
                                null
                        },
                        {
                                5,
                                25,
                                "Kg/Yr",
                                "20130715",
                                7.2,
                                null,
                                null
                        },
                        {
                                5,
                                25,
                                "%",
                                "20141105",
                                null,
                                null,
                                null
                        },
                        {
                                5,
                                21,
                                "Thousand tonnes",
                                "20141105",
                                1,
                                "",
                                "second"
                        },
                        {
                                5,
                                34,
                                "Thousand tonnes",
                                "20141105",
                                2,
                                "",
                                "third"
                        },
                        {
                                5,
                                28,
                                "Thousand tonnes",
                                "20141105",
                                3,
                                "",
                                "fourth"
                        },
                        {
                                5,
                                29,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                "",
                                ""
                        },
                        {
                                5,
                                30,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                "",
                                ""
                        },
                        {
                                5,
                                31,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                "",
                                ""
                        },
                        {
                                5,
                                32,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                "",
                                ""
                        },
                        {
                                5,
                                33,
                                "Thousand tonnes",
                                "20141105",
                                null,
                                "",
                                ""
                        },
                        {
                                5,
                                1,
                                "1000s",
                                "20130715",
                                41074,
                                "",
                                null
                        },
                        {
                                6,
                                34,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                28,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                30,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                32,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                17,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                38,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                39,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                14,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                19,
                                "Thousand tonnes",
                                "20000103",
                                57670,
                                "",
                                null
                        },
                        {
                                6,
                                21,
                                "Thousand tonnes",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                27,
                                "Thousand tonnes",
                                "20000103",
                                57500,
                                "",
                                null
                        },
                        {
                                6,
                                18,
                                "Thousand tonnes",
                                "20000103",
                                4820,
                                "",
                                null
                        },
                        {
                                6,
                                5,
                                "Thousand tonnes",
                                "20000103",
                                52680,
                                "",
                                null
                        },
                        {
                                6,
                                7,
                                "Thousand tonnes",
                                "20000103",
                                170,
                                "",
                                null
                        },
                        {
                                6,
                                4,
                                "Tonnes/Ha",
                                "20000103",
                                2.89,
                                "",
                                null
                        },
                        {
                                6,
                                3,
                                "%",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                25,
                                "Kg/Yr",
                                "20000103",
                                12.65,
                                "",
                                null
                        },
                        {
                                6,
                                42,
                                "Tonnes/Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                43,
                                "Tonnes/Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                35,
                                "Thousand tonnes",
                                "20000103",
                                57670,
                                "",
                                null
                        },
                        {
                                6,
                                20,
                                "Thousand tonnes",
                                "20000103",
                                40450,
                                "",
                                null
                        },
                        {
                                6,
                                13,
                                "Thousand tonnes",
                                "20000103",
                                500,
                                "",
                                null
                        },
                        {
                                6,
                                36,
                                "Thousand tonnes",
                                "20000103",
                                39190,
                                "",
                                null
                        },
                        {
                                6,
                                15,
                                "Thousand tonnes",
                                "20000103",
                                740,
                                "",
                                null
                        },
                        {
                                6,
                                10,
                                "Thousand tonnes",
                                "20000103",
                                13320,
                                "",
                                null
                        },
                        {
                                6,
                                16,
                                "Thousand tonnes",
                                "20000103",
                                3890,
                                "",
                                null
                        },
                        {
                                6,
                                8,
                                "Thousand tonnes",
                                "20000103",
                                50,
                                "",
                                null
                        },
                        {
                                6,
                                12,
                                "Thousand tonnes",
                                "20000103",
                                12740,
                                "",
                                null
                        },
                        {
                                6,
                                2,
                                "Thousand Ha",
                                "20000103",
                                18600,
                                "",
                                null
                        },
                        {
                                6,
                                37,
                                "Thousand Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                40,
                                "Thousand Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                41,
                                "Thousand Ha",
                                "20000103",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                1,
                                "1000s",
                                "20000103",
                                40276,
                                "",
                                null
                        },
                        {
                                6,
                                14,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                21,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                34,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                28,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                30,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                32,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                17,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                38,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                39,
                                "Thousand tonnes",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                19,
                                "Thousand tonnes",
                                "20130715",
                                43840,
                                "",
                                null
                        },
                        {
                                6,
                                27,
                                "Thousand tonnes",
                                "20130715",
                                43820,
                                "",
                                null
                        },
                        {
                                6,
                                18,
                                "Thousand tonnes",
                                "20130715",
                                3720,
                                "",
                                null
                        },
                        {
                                6,
                                5,
                                "Thousand tonnes",
                                "20130715",
                                40100,
                                "",
                                null
                        },
                        {
                                6,
                                7,
                                "Thousand tonnes",
                                "20130715",
                                20,
                                "",
                                null
                        },
                        {
                                6,
                                4,
                                "Tonnes/Ha",
                                "20130715",
                                2.7,
                                "",
                                null
                        },
                        {
                                6,
                                3,
                                "%",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                25,
                                "Kg/Yr",
                                "20130715",
                                9.49,
                                "",
                                null
                        },
                        {
                                6,
                                42,
                                "Tonnes/Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                43,
                                "Tonnes/Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                35,
                                "Thousand tonnes",
                                "20130715",
                                43840,
                                "",
                                null
                        },
                        {
                                6,
                                20,
                                "Thousand tonnes",
                                "20130715",
                                31810,
                                "",
                                null
                        },
                        {
                                6,
                                13,
                                "Thousand tonnes",
                                "20130715",
                                390,
                                "",
                                null
                        },
                        {
                                6,
                                36,
                                "Thousand tonnes",
                                "20130715",
                                30670,
                                "",
                                null
                        },
                        {
                                6,
                                15,
                                "Thousand tonnes",
                                "20130715",
                                750,
                                "",
                                null
                        },
                        {
                                6,
                                10,
                                "Thousand tonnes",
                                "20130715",
                                6030,
                                "",
                                null
                        },
                        {
                                6,
                                16,
                                "Thousand tonnes",
                                "20130715",
                                5990,
                                "",
                                null
                        },
                        {
                                6,
                                8,
                                "Thousand tonnes",
                                "20130715",
                                100,
                                "",
                                null
                        },
                        {
                                6,
                                12,
                                "Thousand tonnes",
                                "20130715",
                                8000,
                                "",
                                null
                        },
                        {
                                6,
                                2,
                                "Thousand Ha",
                                "20130715",
                                18300,
                                "",
                                null
                        },
                        {
                                6,
                                37,
                                "Thousand Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                40,
                                "Thousand Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                41,
                                "Thousand Ha",
                                "20130715",
                                null,
                                "",
                                null
                        },
                        {
                                6,
                                1,
                                "1000s",
                                "20130715",
                                41074,
                                "",
                                null
                        }
                };

        this.country = "Argentina";
        this.datasource="DS Argentina";
        this.season = "2014/15";

    }
    
  


    public Object[][] getData() {
        return this.data;
    }


    public String getDatasource() {
        return datasource;
    }

    public String getSeason() {
        return season;
    }

    public String getCountry() {
        return country;
    }
}