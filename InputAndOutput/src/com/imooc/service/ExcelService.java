package com.imooc.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.imooc.dao.ImportExcelDao;
import com.imooc.entity.Excel;
import com.imooc.entity.Student;

public class ExcelService {
	//上传文件的保存路径
	public static final String SavePath="F:\\JavaWeb程序\\InputAndOutput\\";
public static Excel imp(ImportExcelDao excelDao) {
	Excel excel=new Excel();
	String fileName=null;
	try {
		fileName=saveFile(excelDao.getExcel(), SavePath);
	} catch (Exception e1) {
		excel.setMessage("文件保存失败");
	}
	if(fileName!=null) {
		Workbook workbook=null;
	try {
		List<Student>list=new ArrayList<Student>();
		Student student=null;
		workbook=WorkbookFactory.create(new File(SavePath+fileName));
		Sheet sheet=workbook.getSheetAt(0);
		int rowNum=sheet.getLastRowNum();
		for(int i=1;i<=rowNum;i++) {
			Row row=sheet.getRow(i);
			student=new Student();
			student.setName(row.getCell(0).getStringCellValue());
			student.setAge((int)row.getCell(1).getNumericCellValue());
 
//			System.out.println("姓名："+row.getCell(0).getStringCellValue());
//			System.out.println("年龄："+row.getCell(1).getNumericCellValue());
//			System.out.println("生日："+row.getCell(2).getDateCellValue());
			list.add(student);
		}
		excel.setList(list);
		excel.setTitle(excelDao.getTitle());
		//excel.setMessage("文件保存失败");
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		excel.setMessage("文件保存失败");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		excel.setMessage("文件保存失败");
	}finally{
		if(workbook!=null) {
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}else {
		excel.setMessage("文件保存失败");
	}	
	return excel;
}
public static Workbook exp(boolean isXlsx) {
	Workbook workbook;
	if(isXlsx) {
		workbook=new XSSFWorkbook();
	}else {
		workbook=new HSSFWorkbook();
	}
	Sheet sheet=workbook.createSheet("new sheet");
	List<List<String>>list=addList();
	int length=list.size();
	int length1=0;
	for(int i=0;i<length;i++) {
	Row row=sheet.createRow(i);
	length1=list.get(i).size();
	for(int j=0;j<length1;j++) {
		row.createCell(j).setCellValue(list.get(i).get(j));
	}
	}
return workbook;
}
public static List<List<String>>addList(){
	List<List<String>>list=new ArrayList<>();
	List<String>temp=new ArrayList<>();
	temp.add("序号");
	temp.add("姓名");
	temp.add("年龄");
	temp.add("出生年月");
	list.add(temp);
	temp=new ArrayList<>();
	temp.add("1");
	temp.add("张三");
	temp.add("25");
	temp.add("1990-09-01");
	list.add(temp);
	temp=new ArrayList<>();
	temp.add("2");
	temp.add("李四");
	temp.add("25");
	temp.add("1990-09-01");
	list.add(temp);
	temp=new ArrayList<>();
	temp.add("3");
	temp.add("王五");
	temp.add("22");
	temp.add("1990-09-01");
	list.add(temp);
	return list;
}
public static String saveFile(FileItem excel,String path) throws Exception {
	String fileName=System.currentTimeMillis()+"_"+excel.getName();
	excel.write(new File(path +fileName));
	return fileName;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
