package primaprova.excel.utils.config;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import primaprova.export.data.configurations.dataCreator.DataCreator;
import primaprova.export.data.daoValue.DaoForecastValue;
import primaprova.export.data.formula.CellMapper;
import primaprova.export.data.formula.bean.FormulaBean;
import primaprova.export.data.formula.configurator.ConfigurationReader;
import primaprova.export.data.query.AMISQuery;
import org.apache.log4j.Logger;


import java.util.*;

/**
 * Created by fabrizio on 11/10/14.
 */
public class SheetCreator {

    private static final Logger LOGGER = Logger.getLogger(SheetCreator.class);

    private static final String[] NATIONAL_CODES_FORMULAS = {"27","19","20"};

    private String[] nationalCodes;

    private  String FORMULA_URL ;

    private ConfigurationReader configurationReader;

    private String commodityChosen;

    private String toDeleteProva;

    private CellMapper cellMappers;

    public SheetCreator(){


    }

    public int createSummary(int rowCounter, HSSFSheet sheet, HSSFWorkbook workbook, DataCreator dataCreator, String commodityLabel) {


        //Create Date Last Updated
        String commodity = commodityLabel;
        this.commodityChosen = commodityLabel;
        String season = dataCreator.getSeason();
        String dataSource = dataCreator.getDatasource();
        String country = dataCreator.getCountry();

        rowCounter = createHeadingRow(rowCounter, sheet, workbook, "COMMODITY: ", commodity);
        rowCounter = createHeadingRow(rowCounter, sheet, workbook, "SEASON: ", season);
        rowCounter = createHeadingRow(rowCounter, sheet, workbook, "COUNTRY: ", country);
        rowCounter = createHeadingRow(rowCounter, sheet, workbook, "DATASOURCE: ", dataSource);

        rowCounter = AmisExcelUtils.createEmptyRow(rowCounter, sheet, workbook);

        return rowCounter;
    }

    private int createHeadingRow(int rowCounter, HSSFSheet sheet, HSSFWorkbook workbook, String header, String headerValue) {
        HSSFRow row = sheet.createRow(rowCounter++);
        // LOGGER.info("----------- createHeadingRow .... START ");

        if (header != null && headerValue == null) {
            HSSFCell cell = row.createCell((short) 0);
            cell.setCellStyle(AmisExcelUtils.getBigBoldTextCellStyle(workbook, null));
            cell.setCellValue(header);

            row.createCell((short) 1).setCellValue("");
        } else {
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

    public int createSheetTitle(int rowCounter, HSSFSheet sheet, HSSFWorkbook workbook) {
        HSSFRow row = sheet.createRow(rowCounter++);

        String title = "amis commodity balance sheet";
        HSSFCell cell = row.createCell((short) 0);
        cell.setCellStyle(AmisExcelUtils.getBoldTextCellStyle(workbook, null));
        cell.setCellValue(title.toUpperCase());

        rowCounter = AmisExcelUtils.createEmptyRow(rowCounter, sheet, workbook);

        return rowCounter;
    }


    public int createHeadersGroup(int rowCounter, HSSFSheet sheet, HSSFWorkbook workbook,
                                  LinkedHashMap<String, LinkedHashMap<String, DaoForecastValue>> mapGroup, String type) {

        String title;
        this.cellMappers = new CellMapper();

        if (type == "foodBalance") {
            title = "National Marketing Year (NMY):";
            this.nationalCodes = this.NATIONAL_CODES_FORMULAS;
            this.FORMULA_URL = "formulaNational.properties";
            this.configurationReader = new ConfigurationReader(FORMULA_URL);
        } else if (type == "international") {
            title = "International Trade Year (ITY):";
        } else {
            title = "Other";
        }

        int columnNumber = 0;

        HSSFRow row = sheet.createRow(rowCounter++);
        HSSFCell cell = row.createCell((short) columnNumber);
        cell.setCellStyle(AmisExcelUtils.getBoldTextCellStyle(workbook, null));
        cell.setCellValue(title);
        columnNumber++;

        Set<String> dates = mapGroup.keySet();

        for (String date : dates) {

            columnNumber = createHeadersValues(date, columnNumber, row, workbook, sheet);
            columnNumber++;
        }

        rowCounter++;

        return rowCounter;
    }

    private int createHeadersValues(String date, int columnNumber, HSSFRow row, HSSFWorkbook workbook, HSSFSheet sheet) {

        String flags = "Forecasting Methodology";
        String notes = "Notes";


        row.setHeight((short) (3*260));
        HSSFCell cell = row.createCell((short) columnNumber);
        cell.setCellStyle(AmisExcelUtils.getBlueCellStyle(workbook));
        cell.setCellValue(date);
        sheet.autoSizeColumn(columnNumber);


        columnNumber++;

        HSSFCell cell2 = row.createCell((short) columnNumber);
        cell2.setCellStyle(AmisExcelUtils.getBlueCellStyle(workbook));
        cell2.setCellValue(flags);
        sheet.autoSizeColumn(columnNumber);


        columnNumber++;

        HSSFCell cell3 = row.createCell((short) columnNumber);
        cell3.setCellStyle(AmisExcelUtils.getBlueCellStyle(workbook));
        cell3.setCellValue(notes);
        sheet.autoSizeColumn(columnNumber);


        columnNumber++;

        return columnNumber;
    }

    public int createDataTableGroup(int rowCounter, HSSFSheet sheet, HSSFWorkbook workbook,
                                    HashMap<Integer, String> elements,
                                    LinkedHashMap<String, LinkedHashMap<String,
                                            DaoForecastValue>> foodBalanceResults) {

        List<String> datesList = null;
        Set<Integer> codes = elements.keySet();

        for (int code : codes) {

            int columnNumber = 0;

            HSSFRow row = sheet.createRow(rowCounter++);

            HSSFCell cell = row.createCell((short) columnNumber);
            cell.setCellStyle(AmisExcelUtils.getGreyCellStyle(workbook));
            cell.setCellValue(elements.get(code));
            sheet.autoSizeColumn(columnNumber);

            columnNumber++;

            Set<String> dates = foodBalanceResults.keySet();

            int length = dates.size();

            int i=0;

            datesList = new LinkedList<String>();

            for (String date : dates) {
                columnNumber = fillForecastElements(columnNumber,row,workbook,foodBalanceResults.get(date),code,sheet,date);
                columnNumber++;
                i++;
                datesList.add(date);
            }

        }

/*
        for(String date: datesList) {
            LinkedList<FormulaBean> formulaBeans = this.configurationReader.getFormulas(this.nationalCodes);
            handleFormulas(formulaBeans,sheet,workbook,date);
        }
*/
        return rowCounter;
    }

    private int fillForecastElements(int columnNumber, HSSFRow row, HSSFWorkbook workbook, LinkedHashMap<String,
            DaoForecastValue> elements, int code, HSSFSheet sheet, String date) {


        DaoForecastValue forecast = elements.get("" + code);


        if(forecast != null) {
            // value

            int value =  (int)forecast.getValue();
            HSSFCell cell = row.createCell((short) columnNumber);
            cell.setCellStyle(AmisExcelUtils.getBasicCellStyle(workbook));
            if(value == -1){
                cell.setCellValue(cell.CELL_TYPE_BLANK);
            }else {
                cell.setCellValue(value);
            }
            String indexLetter = CellReference.convertNumToColString(columnNumber) + ""+(cell.getRowIndex()+1);
            cellMappers.putData(date,""+code,"value",indexLetter);

            columnNumber++;

            // flags
            HSSFCell cell1 = row.createCell((short) columnNumber);
            cell1.setCellStyle(AmisExcelUtils.getBasicCellStyle(workbook));
            cell1.setCellValue(forecast.getFlags());

            String indexLetter1 = CellReference.convertNumToColString(columnNumber) + ""+(cell.getRowIndex()+1);
            cellMappers.putData(date, "" + code, "flags", indexLetter1);

            columnNumber++;

            // notes
            HSSFCell cell2 = row.createCell((short) columnNumber);
            cell2.setCellStyle(AmisExcelUtils.getBasicCellStyle(workbook));
            cell2.setCellValue(forecast.getNotes());
            sheet.autoSizeColumn(columnNumber);

            String indexLetter2 = CellReference.convertNumToColString(columnNumber) + ""+(cell.getRowIndex()+1);
            cellMappers.putData(date, "" + code, "notes", indexLetter2);

            columnNumber++;
        }
        else
        {

            HSSFCell cell = row.createCell((short) columnNumber);
            cell.setCellStyle(AmisExcelUtils.getBasicCellStyle(workbook));
            cell.setCellValue("");

            String indexLetter = CellReference.convertNumToColString(columnNumber) + ""+(cell.getRowIndex()+1);
            cellMappers.putData(date, "" + code, "value", indexLetter);

            columnNumber++;

            // flags
            HSSFCell cell1 = row.createCell((short) columnNumber);
            cell1.setCellStyle(AmisExcelUtils.getBasicCellStyle(workbook));
            cell1.setCellValue("");

            String indexLetter1 = CellReference.convertNumToColString(columnNumber) + ""+(cell.getRowIndex()+1);
            cellMappers.putData(date, "" + code, "flags", indexLetter1);

            columnNumber++;

            // notes
            HSSFCell cell2 = row.createCell((short) columnNumber);
            cell2.setCellStyle(AmisExcelUtils.getBasicCellStyle(workbook));
            cell2.setCellValue("");

            String indexLetter2 = CellReference.convertNumToColString(columnNumber) + ""+(cell.getRowIndex()+1);
            cellMappers.putData(date, "" + code, "notes", indexLetter2);

            columnNumber++;

        }

        return columnNumber;
    }


    private void handleFormulas(LinkedList<FormulaBean> formulaBeans, HSSFSheet sheet, HSSFWorkbook wb, String date){

        LinkedHashMap<String,String> mapper = cellMappers.getMapCells();

        for(FormulaBean formulaBean: formulaBeans){
            String codeOperand = formulaBean.getOperand();
            String operandCodeValue = mapper.get(date+"*"+codeOperand+"*"+"value");
            String operandCodeFlags = mapper.get(date+"*"+codeOperand+"*"+"flags");

            LinkedList<String> addendumsCodes = new LinkedList<String>();
            String operator = formulaBean.getOperator();

            for (String addendum: formulaBean.getAddendums()){
                addendumsCodes.add(mapper.get(date+"*"+addendum+"*"+"value"));
            }
            makeFormula(operandCodeFlags, operandCodeValue, operator, addendumsCodes, sheet);

        }
    }

    private void makeFormula(String operandCodeFlags, String operandCodeValue,
                             String operator,  LinkedList<String> addendumsCodes,
                             HSSFSheet sheet){

        LOGGER.info("StartedMAKE FORMULA");

        Cell operandCell = null;
        CellReference referenceValue = new CellReference(operandCodeValue);
        Row rowIndex = sheet.getRow(referenceValue.getRow());
        if (rowIndex != null) {
            operandCell = rowIndex.getCell(referenceValue.getCol());
        }

        String formula="";

        int lengthAddendums = addendumsCodes.size();

        int i= 0;
        for(String addendumCode: addendumsCodes){
            formula+=addendumCode;
            if(i != lengthAddendums-1){
                formula+=operator;
            }
            i++;
        }

        operandCell.setCellFormula(formula);

    }


}

