package com.lockedMe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LockedMe {

	static final String folderPath = "C:\\JavaFS_phase1FinalProject\\LockedMe\\FilesLocation";
	static final String errorMsg= "Some error Occured:Please Contact admin@lockedme.com";
	static final String FILE_NOT_FOUND = "File not Found in Directory";
	
	public static void main(String[] args) throws NumberFormatException, Exception {
		
		Scanner obj = new Scanner(System.in);
		int option = 0;
		do{		
			displayMenu();
			System.out.println("Enter Any Of the Option");
			  try 
			  	{
				  option = Integer.parseInt(obj.nextLine()); 
			    } 
			  	catch (NumberFormatException e)
			  	{
			  		System.out.println(errorMsg);
			    }
				
				switch(option) {
				case 1:
				{
					getAllFiles();	
					break;
				}
				case 2:
				{
					addFile();	
					break;
				}
				case 3:
				{
					deleteFiles();	
					break;
				}
				case 4:
				{
					serachFiles();	
					break;
				}
				case 5:
				{
					exit();
					break;
				}
				 default:
					System.out.println("*********************you have Entered wrong option,"
							+ "Please try Again***************************");
					obj.close();
				}	
			}
		while(option > 0);
		{		
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
		System.out.println("\t\t5.Exit");
		System.out.println("******************************************************************");
		System.out.println("\t\t\t\t\t\tBy Arpit Yadav...");
		
	}
	
	/**
	 * @author Arpit
	 * @apiNote Method is used to return all the files present in
	 * given location of folder path
	 * @param none
	 */
	public static void getAllFiles()
	{
		File file = new File(folderPath);
		var allfiles = file.list();
		if(allfiles.length == 0) 
		{
		System.out.println("*******No file found in Directory********");	
		}else 
		{
			for (var d:allfiles) 
			{
			 System.out.println(d);
			}
		}		
	}

	/**
	 * @author Arpit
	 * @apiNote this code is used to add a file in to given Directory
	 * @param none
	 * @exception IOException
	 */
	public static void addFile() throws IOException
	{
		Scanner obj = new Scanner(System.in);
		try {
			String fileName = null;
			int fileCount = 0;
			
			System.out.println("Enter the file name");
				fileName = obj.nextLine();
			
			System.out.println("Give No Of Lines you want to enter in file");
			try {
				fileCount = Integer.parseInt(obj.nextLine());
			}catch(NumberFormatException ex) {
				System.out.println(errorMsg);
			}
			
			File file = new File(folderPath+"\\"+fileName); 
			if(file.exists()) System.out.println("File With This Name Already Exist");
			else 
			{
				FileWriter fw = new FileWriter(folderPath+"\\"+fileName);
				for(int i=1;i<=fileCount;i++) 
				{
					System.out.println("Enter Line:");
					fw.write(obj.nextLine()+"\n");
				}
					fw.close();
					System.out.println("File created Successfully");
			}
		}
		catch(Exception ex) 
		{
			System.out.println(errorMsg);
		}	
	 }
	
	/**
	 * @author Arpit
	 * @apiNote this code is used to delete the file entered, from Directory
	 * @param none
	 */
	public static void deleteFiles()
	{
		
		Scanner obj = new Scanner(System.in);
		String fileName = null;
		
		System.out.println("Enter the file name to be Deleted");
		fileName = obj.nextLine();  
		File file = new File(folderPath+"\\"+fileName);
			if(file.exists()) {
				System.out.println();
				file.delete();	
				System.out.println("File Delted Successfully");
			}
			else System.out.println(FILE_NOT_FOUND);
		
	}
	
	/**
	 * @author Arpit
	 * @apiNote this code is used to search the file from Directory.
	 * @param none
	 */
	public static void serachFiles()
	{
		Scanner obj = new Scanner(System.in);
		String fileName = null;
		boolean fileFound= false;
		System.out.println("Enter the file name to be Searched");	
		File file = new File(folderPath); 
			fileName = obj.nextLine();
			var listOfFiles = file.list();
			for(var l:listOfFiles)
			{
				if(l.equalsIgnoreCase(fileName)) 
				{
					fileFound= true;
				}
			}
				if(fileFound) System.out.println("File Availabe in Directory");
				else System.out.println(FILE_NOT_FOUND);
	}
	
	public static void exit() 
	{
		Scanner obj = new Scanner(System.in);
		int isExit = 0;
		System.out.println("\t\tAre you Sure want to Exit?");
		System.out.println("\t\t1.Yes"+"\t\t2.No");
		try {
			isExit = Integer.parseInt(obj.nextLine());
		}catch(NumberFormatException ex) {
			System.out.println(errorMsg);
		}
			if(isExit == 1)
			{
				System.out.println("************\t\tThankYou\t\t*************");
				System.exit(0);
			}else if(isExit !=1 && isExit != 2) {
				System.out.println("Please Enter correct choise");
				exit();
			}
	}
}
