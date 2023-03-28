package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

//		System.out.print("Enter the path of a file or directory >>> ");
//		String path = userInput.nextLine();
//		File file = new File(path);
//		getFileDetails(file);

		System.out.println();
		System.out.println("Let's create a new directory.");
		System.out.print("Enter the path of the new directory >>> ");
		String directoryPath = userInput.nextLine();
		File newDirectory = new File(directoryPath);

		if(newDirectory.exists()){
			System.out.println("Directory already exists.");
		} else {
			if(newDirectory.mkdir()){
				System.out.println("New directory created at " + newDirectory.getAbsolutePath());
			} else {
				System.out.println("Could not create directory.");
				System.exit(1);
			}
		}

		/*******************
		 * Creating a file *
		 *******************/

		System.out.println();
		System.out.println("Now let's put a file in the directory");
		System.out.print("Enter the name of the new file >>> ");
		String fileName = userInput.nextLine();
		File newFile = new File(newDirectory, fileName);

		// creates a new file
		newFile.createNewFile();
		getFileDetails(newFile);


		/*******************
		 * write to a file *
		 *******************/
//		System.out.println();
//		System.out.println("Now let's put something in the new file");
//		System.out.print("Enter a message to be stored in the new file >>> ");
//		String message = userInput.nextLine();
//
//		try(PrintWriter writer = new PrintWriter(newFile)){
//			writer.println(message);
//		}

		/********************
		 * Append to a file *
		 ********************/

		System.out.println();
		System.out.println("Now let's append something to the existing file.");
		System.out.println("Enter a message to be added to the file (Enter 'q' to quit) >>> ");

		PrintWriter writer = new PrintWriter(new FileOutputStream(newFile.getAbsoluteFile(), true));

		while(true) {
			String message = userInput.nextLine();
			if(message.equals("q")) {
				break;
			}
			try {
				writer.append(message);
				writer.println();
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		writer.flush();
		writer.close();
		getFileDetails(newFile);

	}

	public static void getFileDetails(File file) {

		/*****************************
		 * Inspecting the filesystem *
		 *****************************/
		System.out.println();
		if(file.exists()) {
			System.out.println("name: " + file.getName());
			System.out.println("absolute path: " + file.getAbsolutePath());
			if(file.isDirectory()){
				System.out.println("type: directory");
			}
			else {
				System.out.println("type: file");
			}
			System.out.println("size: " + file.length());
		} else {
			System.out.println(file.getPath() + " does not exist");
		}
	}
}
