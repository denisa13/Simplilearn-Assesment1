package sorting;

import java.util.Comparator;

import entities.File;

public class SortFilesByIdAndName implements Comparator<File>{

	@Override
	public int compare(File o1, File o2) {
		// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
	}

}
