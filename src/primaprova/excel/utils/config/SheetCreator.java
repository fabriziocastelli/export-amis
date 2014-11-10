package primaprova.excel.utils.config;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import primaprova.export.data.configurations.dataCreator.DataCreator;

import java.util.logging.Logger;

/**
 * Created by fabrizio on 11/10/14.
 */
public class SheetCreator {

    private static  Logger LOGGER ;

    public int createSummary(int rowCounter, HSSFSheet sheet, HSSFWorkbook workbook, DataCreator dataCreator, String commodityLabel){


        //Create Date Last Updated
        String commodity = commodityLabel;
        String season = dataCreator.getSeason();
        String dataSource = dataCreator.getDatasource();
        String country  = dataCreator.getCountry();

        rowCounter = createHeadingRow(rowCounter, sheet,workbook,"COMMODITY: ",commodity);
        rowCounter = createHeadingRow(rowCounter, sheet,workbook,"SEASON: ",season);
        rowCounter = createHeadingRow(rowCounter, sheet,workbook,"COUNTRY: ",country);
        rowCounter = createHeadingRow(rowCounter, sheet,workbook,"DATASOURCE: ",dataSource);

        rowCounter = AmisExcelUtils.createEmptyRow(rowCounter, sheet, workbook);

/*
        rowCounter = AMISSupplyDemandExcelUtils.createHeadingRow(rowCounter, sheet, workbook, "Data Last Updated on:", dateLastUpdated);

        if(qvo.getxLabel().equals("COUNTRY")){
            rowCounter = AMISSupplyDemandExcelUtils.createHeadingRow(rowCounter, sheet, workbook, "COUNTRY:", country.toUpperCase());
        } else if(qvo.getxLabel().equals("PRODUCT")){
            rowCounter = AMISSupplyDemandExcelUtils.createHeadingRow(rowCounter, sheet, workbook, "COUNTRY:", label.toUpperCase());
        }  else if(qvo.getxLabel().equals("DATASOURCE")){
            rowCounter = AMISSupplyDemandExcelUtils.createHeadingRow(rowCounter, sheet, workbook, "COMMODITY:", area.toUpperCase());
        }

        if(qvo.getxLabel().equals("COUNTRY")){
            rowCounter = AMISSupplyDemandExcelUtils.createHeadingRow(rowCounter, sheet, workbook, "COMMODITY:", AMISSupplyDemandExcelUtils.convertMapItemLabelsToString(qvo.getItems()).toUpperCase());
        } else if(qvo.getxLabel().equals("PRODUCT")){
            rowCounter = AMISSupplyDemandExcelUtils.createHeadingRow(rowCounter, sheet, workbook, "COMMODITY:", country.toUpperCase());
        } else if(qvo.getxLabel().equals("DATASOURCE")){
            rowCounter = AMISSupplyDemandExcelUtils.createHeadingRow(rowCounter, sheet, workbook, "COMMODITY:", label.toUpperCase());
        }

        //Create Source
        String source = createSource(qvo, country, label, area);

        rowCounter = AMISSupplyDemandExcelUtils.createHeadingRow(rowCounter, sheet, workbook, "SOURCE", source);

        rowCounter = AMISSupplyDemandExcelUtils.createEmptyRow(rowCounter, sheet, workbook);

        LOGGER.info("createSummary: END");*/

        return rowCounter;
    }

    private int createHeadingRow(int rowCounter, HSSFSheet sheet, HSSFWorkbook workbook,String header, String headerValue){
        HSSFRow row = sheet.createRow(rowCounter++);
        // LOGGER.info("----------- createHeadingRow .... START ");

        if(header != null && headerValue==null){
            HSSFCell cell = row.createCell((short) 0);
            cell.setCellStyle(AmisExcelUtils.getBigBoldTextCellStyle(workbook, null));
            cell.setCellValue(header);

            row.createCell((short) 1).setCellValue("");
        }
        else {
            // LOGGER.info("----------- header  "+header);

            HSSFCell cell = row.createCell((short) 0);
            cell.setCellStyle(AmisExcelUtils.getRightAlignmentStyle(workbook));
            cell.setCellValue(header);

            cell = row.createCell((short) 1);
            cell.setCellStyle(AmisExcelUtils.getBoldTextCellStyle(workbook, null));
            cell.setCellValue(headerValue);
        }

        // LOGGER.info("----------- createHeadingRow .... END rowCounter =  "+rowCounter);

        return rowCounter;
    }

}
