package dummy.database;

import java.util.ArrayList;
import java.util.List;
import entities.File;

public class FileDatabase {
	private List<File> files = new ArrayList<File>();
	
	public FileDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void insertNewFile(File file)
	{
		files.add(file);		
	}
	
	public List<File> displayFiles(){
		 return files;
	}
	
	public boolean deleteFile(int fileId)
	{
		for(int i=0; i<files.size(); i++)
		{
			if(files.get(i).getId() == fileId)
			{
				files.remove(files.get(i));
				return true;
			}
		}
		return false;
	}
	
	public boolean searchById(int[] arrayOfIds, int fId) {
		boolean found = false;
		int l=0, h=arrayOfIds.length-1;
		while(l<=h)
		{
			int m = (l+h)/2;
			if(arrayOfIds[m] == fId)
			{
				found = true;
				break;
			}
			else if(fId < arrayOfIds[m])
				h = m-1;
			else
				l = m+1;
		}
		return found;
	}
	
	public File getFileById(int fId)
	{
		for(int i=0;i<files.size();i++)
		{
			if(files.get(i).getId() == fId)
			{
				
				return files.get(i);
			}
		}	
		return null;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
	
}
