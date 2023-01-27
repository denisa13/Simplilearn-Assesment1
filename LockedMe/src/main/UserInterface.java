package main;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import dummy.database.FileDatabase;
import entities.File;
import services.FileService;
import sorting.SortFilesByIdAndName;

public class UserInterface {

	public static void displayEntireMenu() {
		System.out.println("Welcome to LockedMe.com; Application provided by Denisa Sutu, Vodafone-VOIS");
		System.out.println("Choose one of the options below:");
		System.out.println("1. Display all system files in ascending order");
		System.out.println("2. Operations");
		System.out.println("3. Close the app");
	}

	public static void displaySubMenu() {
		System.out.println("1. Add a new File");
		System.out.println("2. Delete a File");
		System.out.println("3. Search for a specific File");
		System.out.println("4. Go back");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FileDatabase db = new FileDatabase();
		FileService service = new FileService(db);
		boolean applicationNotClosed = true;

		while (applicationNotClosed) {
			try{// current context
			displayEntireMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				if (db.getFiles().size() == 0)
					System.out.println("Root is empty. Please add some files.\n");
				else {
					System.out.println("\n\nId\tName\tDirectory\tSize");
					List<File> files = db.displayFiles();
					Collections.sort(files, new SortFilesByIdAndName());
					for (File file : files) {
						if (file != null)
							System.out.println(file.getId() + "\t" + file.getName() + "\t" + file.getDirectory() + "\t"
									+ file.getSize());
					}
				}
				System.out.println();
				break;
			case 2:
				boolean isSubmenuSelected = true;
				displaySubMenu();
				int subMenuChoice = sc.nextInt();
				while (isSubmenuSelected) {
					if (subMenuChoice == 1) {
						try {
							System.out.println("\nEnter file details to add");
							System.out.println("Enter id");
							int id = sc.nextInt();
							System.out.println("Enter name");
							String name = sc.next();
							System.out.println("Enter directory");
							String directory = sc.next();
							sc.nextLine();
							System.out.println("Enter size");
							double size = sc.nextDouble();
							File file = new File(id, name, directory, size);
							if (service.addFile(file))
								System.out.println("File added");
							else {
								System.out.println("File could not be added");
							}
						} catch (InputMismatchException e) {
							System.out.println("Input is wrong");
							e.printStackTrace();
							break;
						} catch (Exception e) {
							System.out.println("Something went wrong please try again or contact admin");
							break;
						}
						break;
					} else if (subMenuChoice == 2) {
						System.out.println("\nEnter the id of the file you want to delete");
						System.out.println("Enter id");
						int fileId = sc.nextInt();
						if (!db.deleteFile(fileId)) {
							System.out.println("File not found");
						}
						break;
					} else if (subMenuChoice == 3) {
						System.out.println("\nEnter the id of the file you want to search");
						System.out.println("Enter id");
						int fId = sc.nextInt();
						List<File> files = db.getFiles();
						int arrayOfIds[] = new int[files.size()];
						int i = 0;
						for (File f : files) {
							arrayOfIds[i] = f.getId();
							i++;
						}
						if (db.searchById(arrayOfIds, fId)) {
							File foundFile = db.getFileById(fId);
							if (foundFile != null) {
								System.out.println(foundFile.getId() + "\t" + foundFile.getName() + "\t"
										+ foundFile.getDirectory() + "\t" + foundFile.getSize());
								break;
							}
						} else {
							System.out.println("File does not exist");
							break;
						}
					} else if (subMenuChoice == 4) {
						isSubmenuSelected = false;
						break;
					}
				}
				break;
			case 3:
				applicationNotClosed = false;
				System.out.println("Application is closed");
				break;
			}
		}
		catch(Exception e) {
			System.out.println("An error occured");
			break;
		}
	}
	}
}