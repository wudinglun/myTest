package myTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Readxls {
	public List<List<String>>readXls(String path) throws Exception{
		InputStream is=new FileInputStream(path);
//		System.out.println(is.toString());
		HSSFWorkbook hssfWorkbook=new HSSFWorkbook(is);
		List<List<String>> result=new ArrayList<List<String>>();
		
		for(int numSheet=0;numSheet<hssfWorkbook.getNumberOfSheets();numSheet++){
			HSSFSheet hssfSheet= hssfWorkbook.getSheetAt(numSheet);
		    if(hssfSheet==null){
		    	continue;
		    }
		    int rowSize=hssfSheet.getLastRowNum()+1;//得到行数
		    for(int rowNum=1;rowNum<rowSize;rowNum++){
		    	HSSFRow hssfRow=hssfSheet.getRow(rowNum);
		    	if(hssfRow==null){
		    		continue;
		    	}
		    	List<String> values=new ArrayList<String>();
		    	boolean hasValue = false;
		    	for (short cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
		    		String value="";//装载单元格的值
		    		HSSFCell hssfCell=hssfRow.getCell(cellNum);
		    		if (hssfCell != null) {
	                     // 注意：一定要设成这个，否则可能会出现乱码
//		    			hssfCell.setEncoding(HSSFCell.ENCODING_UTF_16);
	                     switch (hssfCell.getCellType()) {  
	                     case HSSFCell.CELL_TYPE_STRING:
	                         value = hssfCell.getStringCellValue();
	                         break;
	                     case HSSFCell.CELL_TYPE_NUMERIC: //数字   
	                         if (HSSFDateUtil.isCellDateFormatted(hssfCell)) {//是否可以转换成日期
	                            Date date = hssfCell.getDateCellValue();
	                            if (date != null) {
	                                value = new SimpleDateFormat("yyyy-MM-dd").format(date);
	                            } else {
	                                value = "";
	                            }
	                         } else {                                        //不能转换成日期的直接转换成数字
	                            value = new DecimalFormat("0").format(hssfCell.getNumericCellValue());
	                         }
	                         break;
	                     case HSSFCell.CELL_TYPE_FORMULA://公式
	                         // 导入时如果为公式生成的数据则无值
	                         if (!hssfCell.getStringCellValue().equals("")) {
	                            value = hssfCell.getStringCellValue();
	                         } else {
	                            value = hssfCell.getNumericCellValue() + "";
	                         }
	                         break;
	                     case HSSFCell.CELL_TYPE_BLANK:
	                         break;
	                     case HSSFCell.CELL_TYPE_ERROR:
	                         value = "";
	                         break;
	                     case HSSFCell.CELL_TYPE_BOOLEAN://布尔型
	                         value = (hssfCell.getBooleanCellValue() == true ? "Y": "N");
	                         break;
	                     default:
	                         value = "";
	                     }
	                  }
//		    		  if (cellNum == 0 && value.trim().equals("")) {
//	                     break;
//	                  }
		    		 values.add(value.trim());
	                 hasValue = true;	    		
		    	}
		    	if (hasValue) {
		           result.add(values);
		        }		    	
		    }
		}
		is.close();		
		return result;
	}

}
