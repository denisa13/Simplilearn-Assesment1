package entities;

public class File implements Comparable<File>{
	private Integer id;
	private String name;
	private String directory;
	private double size;
	
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public File(int id, String name, String directory, double size) {
		this.id = id;
		this.name = name;
		this.directory = directory;
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", name=" + name + ", directory=" + directory + ", size=" + size + "]";
	}

	public int compareTo2(File o1, File o2) {
		// TODO Auto-generated method stub
		if( o1.getId().compareTo(o2.getId()) == 0) {
			return o1.getName().compareTo(o2.getName());
		}else {
			return o1.getId().compareTo(o2.getId());
		}
		
	}

	@Override
	public int compareTo(File o) {
		// TODO Auto-generated method stub
		return o.getId().compareTo(o.getId());
	}
}
