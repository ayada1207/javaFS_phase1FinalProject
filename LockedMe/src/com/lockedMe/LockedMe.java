package com.lockedMe;

import java.io.File;
import java.util.Scanner;

public class LockedMe {

	public static final String folderPath = "C:\\JavaFS_phase1FinalProject\\LockedMe\\FilesLocation";
	
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		String option;
		displayMenu();
		System.out.println("Enter Any Of the Option");
		option = obj.nextLine();
		try {
			switch(option) {
			
			case "1":
			{
				getAllFiles();	
				break;
			}
			 default:
				System.out.println("*********************you have Entered wrong option, Please try Again***************************");
			}
		}
		catch(Exception e) {
			System.out.println("Please Check again, some error Occured");
		}
		finally{
			while(option !="5") {
				displayMenu();
				break;
			}
			obj.close();
			
		}
	
		
	}
	
	public static void displayMenu()
	{
		System.out.println("******************************************************************");
		System.out.println("\t\tWelcome to LockedMe.com");
		System.out.println("******************************************************************");
		System.out.println("\t\t1.Display All Files");
		System.out.println("\t\t2.Add a New File");
		System.out.println("\t\t3.Delete a File");
		System.out.println("\t\t4.Search File");
		System.out.println("\t\t4.Exit");
		System.out.println("******************************************************************");
		
	}
	public static void getAllFiles()
	{
		File file = new File(folderPath);
		var allfiles = file.list();
		
		for (var d:allfiles) {
			System.out.println(d);
		}
	}

	public static void addFile()
	{
		
	}
	
	public static void deleteFiles()
	{
		
	}
	
	public static void serachFiles()
	{
		
	}
}
