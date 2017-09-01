package com.spa.htmlToExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.spa.student.Student;


public class WriteInExcel

{
	File savingDir;
	public WriteInExcel(File savingDir2){
		savingDir = savingDir2;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = 
			workbook.createSheet("Sample sheet");
		TreeMap<Integer, Object[]> data = 
			new TreeMap<Integer, Object[]>();
		data.put(1, new Object[] 
				{"Name","Father's Name", "Roll No", "Enrollment No", "Semester",
				"Branch","Course",  "Institute", "Image", "GP", "Carry Over",
				"Human Values", "Marks Obt"});
		for(int i=0;i<Student.sn;i++){
		data.put(i, new Object[] 
			{Student.name[i],Student.fatherName[i],Student.rollNo[i],Student.enrollmentNo[i],
				Student.semester[i],Student.branch[i],Student.course[i],
				Student.institute[i],Student.image[i],Student.gp[i],
				Student.carryOver[i],Student.humanValues[i],Student.marksObt[i]});
		
		Set<Integer> keyset = data.keySet();
		int rownum = 0;
		for (Integer key : keyset) 
		{
			Row row = sheet.createRow(rownum++);
			Object [] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) 
			{
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof Date)
				cell.setCellValue((Date)obj);
				else if(obj instanceof Boolean)
				cell.setCellValue((Boolean)obj);
				else if(obj instanceof String)
				cell.setCellValue((String)obj);
				else if(obj instanceof Double)
				cell.setCellValue((Double)obj);
			}
		}
		try 
		{
			FileOutputStream out =
			new FileOutputStream
				(new File(savingDir+".xls"));
			workbook.write(out);
			out.close();
			System.out.println
				("Excel written successfully..");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	}
}
