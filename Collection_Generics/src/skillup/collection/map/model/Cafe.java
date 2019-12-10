package skillup.collection.map.model;

public class Cafe {
	private String menu;
	private int price;
	
	
	public Cafe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cafe(String menu, int price) {
		super();
		this.menu = menu;
		this.price = price;
	}


	public String getMenu() {
		return menu;
	}


	public void setMenu(String menu) {
		this.menu = menu;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "[menu=" + menu + ", price=" + price+"]";
	}

	// 오버라이딩 부분~~~

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + price;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cafe))
			return false;
		Cafe other = (Cafe) obj;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	
	
	
}
