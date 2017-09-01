package com.spa.htmlToExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.spa.student.Student;

public class HtmlToExcel {

	String completeFileContent="";
	String subname ="ctl00_ContentPlaceHolder1_lblName";
	String subFatherName="ctl00_ContentPlaceHolder1_lblFname";
	String subRollNo="ctl00_ContentPlaceHolder1_lblRollName";
	String subEnrollmentNo="ctl00_ContentPlaceHolder1_lblEnrollmentNo";
	String subCourse="ctl00_ContentPlaceHolder1_lblCourse";
	String subInstitute="ctl00_ContentPlaceHolder1_lblInstName";
	String subGp="ctl00_ContentPlaceHolder1_lblSesMark16";
	String subCarryOver="ctl00_ContentPlaceHolder1_lblCarryOver";
	String subHumanValues="ctl00_ContentPlaceHolder1_lblsubstatus";
	String subMarksObt="ctl00_ContentPlaceHolder1_lblTotalMarks";
	FileInputStream input;
	
	String fileExtension = "";
	public HtmlToExcel(Student student,String dirname) throws Exception
	{
		student = new Student();
		File entry = new File(dirname);
		
		File[] count=entry.listFiles();
		for(File f : count)
		{
			if(f.isFile())
			{
				fileExtension = FilenameUtils.get
				student.sn++;
				input = new FileInputStream(f);
				byte[] data = new byte[(int)f.length()];
			    input.read(data);
				completeFileContent = new String(data, "UTF-8");
			}
		}
	}
	
	
	String nameGetter()
	{
		 int nameStartIndex;
	      	nameStartIndex = completeFileContent.indexOf(subname);
	      	nameStartIndex = nameStartIndex + 35;
	      	
	      	int nameEndIndex;
	      	nameEndIndex = completeFileContent.indexOf("<",nameStartIndex);
	      	System.out.println("hello");
	      	String name = completeFileContent.substring(nameStartIndex, nameEndIndex);
	      	return name;
	}
	String fatherNameGetter()
	{
		int FatherNameStartIndex;
      	FatherNameStartIndex = completeFileContent.indexOf(subFatherName);
      	FatherNameStartIndex = FatherNameStartIndex + 36;
      	
      	int FatherNameEndIndex;
      	FatherNameEndIndex = completeFileContent.indexOf("<",FatherNameStartIndex);
      	String fatherName = completeFileContent.substring(FatherNameStartIndex, FatherNameEndIndex);
      	return fatherName;
	}
	String rollNoGetter()
	{
		int rollNoStartIndex;
      	rollNoStartIndex = completeFileContent.indexOf(subRollNo);
      	rollNoStartIndex = rollNoStartIndex + 39;
      	
      	int rollNoEndIndex;
      	rollNoEndIndex = completeFileContent.indexOf("<",rollNoStartIndex);
      	String rollNo = completeFileContent.substring(rollNoStartIndex, rollNoEndIndex);
      	return rollNo;
	}
	String enrollmentNoGetter()
	{
		int enrollmentNoStartIndex;
      	enrollmentNoStartIndex = completeFileContent.indexOf(subEnrollmentNo);
      	enrollmentNoStartIndex = enrollmentNoStartIndex + 43;
      	
      	int enrollmentNoEndIndex;
      	enrollmentNoEndIndex = completeFileContent.indexOf("<",enrollmentNoStartIndex);
      	String enrollmentNo = completeFileContent.substring(enrollmentNoStartIndex, enrollmentNoEndIndex);
      	return enrollmentNo;
	}
	String courseGetter()
	{
		int courseStartIndex;
      	courseStartIndex = completeFileContent.indexOf(subCourse);
      	courseStartIndex = courseStartIndex + 37;
      	
      	int courseEndIndex;
      	courseEndIndex = completeFileContent.indexOf("h. ",courseStartIndex);
      	courseEndIndex = courseEndIndex + 2;
      	String course = completeFileContent.substring(courseStartIndex, courseEndIndex);
      	return course;
	}
	String branchGetter()
	{
		int branchStartIndex;
      	branchStartIndex = completeFileContent.indexOf("B. Tech. ");
      	branchStartIndex = branchStartIndex + 9;
      	
      	int branchEndIndex;
      	branchEndIndex = completeFileContent.indexOf("<",branchStartIndex);
      	String branch = completeFileContent.substring(branchStartIndex, branchEndIndex);
      	return branch;
	}
	String instituGetter()
	{
		int instituteStartIndex;
     	instituteStartIndex = completeFileContent.indexOf(subInstitute);
     	instituteStartIndex = instituteStartIndex + 39;
      	
      	int instituteEndIndex;
      	instituteEndIndex = completeFileContent.indexOf("<",instituteStartIndex);
      	String institute = completeFileContent.substring(instituteStartIndex, instituteEndIndex);
      	String inst = institute.replaceAll("amp;","");
      	return inst;
	}
	String imageGetter()
	{
		int imageStartIndex;
      	imageStartIndex = completeFileContent.indexOf("src=");
      	imageStartIndex =imageStartIndex +5;
      	
      	int imageEndIndex;
      	imageEndIndex = completeFileContent.indexOf(">",imageStartIndex);
      	imageEndIndex = imageEndIndex-1;
      	String image=completeFileContent.substring(imageStartIndex, imageEndIndex);
      	return image;
	}
	String gpGetter()
	{
		int gpStartIndex;
      	gpStartIndex = completeFileContent.indexOf(subGp);
      	gpStartIndex = gpStartIndex + 40;
      	
      	int gpEndIndex;
      	gpEndIndex = completeFileContent.indexOf("<",gpStartIndex);
      	String gp = completeFileContent.substring(gpStartIndex, gpEndIndex);
      	return gp;
	}
	String carryOverGetter()
	{
		int carryOverStartIndex;
      	carryOverStartIndex = completeFileContent.indexOf(subCarryOver);
      	carryOverStartIndex = carryOverStartIndex + 40;
      	
      	int caryOverEndIndex;
      	caryOverEndIndex = completeFileContent.indexOf("<",carryOverStartIndex);
      	String carryOver = completeFileContent.substring(carryOverStartIndex, caryOverEndIndex);
      	if(caryOverEndIndex==carryOverStartIndex){
      		carryOver="NA";
      	}
      	return carryOver;
	}
	String humanValuesGetter()
	{
		int humanValuesStartIndex;
    	humanValuesStartIndex = completeFileContent.indexOf(subHumanValues);
    	humanValuesStartIndex = humanValuesStartIndex + 40;
      	
      	int humanValuesEndIndex;
      	humanValuesEndIndex = completeFileContent.indexOf("<",humanValuesStartIndex);
      	String humanValues = completeFileContent.substring(humanValuesStartIndex, humanValuesEndIndex);
      	return humanValues;
	}
	String totalMarksGetter()
	{
		int marksObtStartIndex;
      	marksObtStartIndex = completeFileContent.indexOf(subMarksObt);
      	marksObtStartIndex = marksObtStartIndex + 41;
      	
      	int marksObtEndIndex;
      	marksObtEndIndex = completeFileContent.indexOf("<",marksObtStartIndex);
      	String marksObt = completeFileContent.substring(marksObtStartIndex, marksObtEndIndex);
      	return marksObt;
	}
}
