package services;

import dummy.database.FileDatabase;
import entities.File;

public class FileService {
	private FileDatabase db;

	public FileService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileService(FileDatabase db) {
		super();
		this.db = db;
	}
	
	public boolean addFile(File file) {
		db.insertNewFile(file);
		return true;
	}
	
	public boolean deleteFile(int fileId) {
		db.deleteFile(fileId);
		return true;
	}
	
	public boolean searchFile(int[] arrayOfIds, int fId) {
		db.searchById(arrayOfIds, fId);
		return true;
	}
	
	public File getFileById(int fId) {
		return db.getFileById(fId);
	}
}
