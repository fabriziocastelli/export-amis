package primaprova.export.data.formula;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CellMapper{

   private LinkedHashMap<String,String> mapCells;


    public CellMapper() {
        this.mapCells = new LinkedHashMap<String, String>();
    }

    @Override
    public String toString() {
        return "CellMapper{" +
                "mapCells=" + mapCells +
                '}';
    }


    public LinkedHashMap<String, String> getMapCells() {
        return mapCells;
    }


    public void putData(String date, String code, String type, String value){

        String key = date+"*"+code+"*"+type;

        this.mapCells.put(key,value);
    }


}