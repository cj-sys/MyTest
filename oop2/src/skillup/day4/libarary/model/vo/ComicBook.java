package skillup.day4.libarary.model.vo;
public class ComicBook extends Book{

	private int accessAge;
	
	public ComicBook() {}

	public ComicBook(String title, String author, String publisher,int accessAge) {
		super(title,author, publisher);
		this.accessAge = accessAge;
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return "ComicBook ["+super.toString()+"accessAge=" + accessAge + "]";
	}
	
	
}
