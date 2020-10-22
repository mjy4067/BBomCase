package vo;

public class OrderViewBean {
	private int ord_id;
	private int goo_id;
	private String goo_name;
	private String goo_color;
	private String goo_model;
	private int goo_price;
	private String goo_image;
	private int goo_qty;
	
	
	private String item_code;
	private String image;
	private String color;
	private String name;
	private int price;
	private int qty;
	
	public OrderViewBean(int goo_id, String goo_name, int goo_price, String goo_model, String goo_color, String goo_image, int goo_qty) {
		this.goo_id = goo_id;
		this.goo_name = goo_name;
		this.goo_price = goo_price;
		this.goo_model = goo_model;
		this.goo_color = goo_color;
		this.goo_image = goo_image;
		this.goo_qty = goo_qty;
	}
	
	
	
	public OrderViewBean(int ord_id, int goo_id, String goo_name, String goo_color, String goo_model, int goo_price, String goo_image, int goo_qty) {
		this.ord_id = ord_id;
		this.goo_id = goo_id;
		this.goo_name = goo_name;
		this.goo_color = goo_color;
		this.goo_model = goo_model;
		this.goo_price = goo_price;
		this.goo_image = goo_image;
		this.goo_qty = goo_qty;
	}
	
	public OrderViewBean(String item_code, String name, String color, String image, int price) {
		// TODO Auto-generated constructor stub
	}
	
	public OrderViewBean(int goo_id, String goo_name, String goo_color, String goo_model, int goo_price, String goo_image) {
		this.goo_id = goo_id;
		this.goo_name = goo_name;
		this.goo_color = goo_color;
		this.goo_model = goo_model;
		this.goo_price = goo_price;
		this.goo_image = goo_image;
	}
	
	public OrderViewBean(String item_code, String image, String color, String name, int price, int qty) {
		this.item_code = item_code;
		this.image = image;
		this.color = color;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	

	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public int getGoo_id() {
		return goo_id;
	}
	public void setGoo_id(int goo_id) {
		this.goo_id = goo_id;
	}
	public String getGoo_name() {
		return goo_name;
	}
	public void setGoo_name(String goo_name) {
		this.goo_name = goo_name;
	}
	public String getGoo_color() {
		return goo_color;
	}
	public void setGoo_color(String goo_color) {
		this.goo_color = goo_color;
	}
	public String getGoo_model() {
		return goo_model;
	}
	public void setGoo_model(String goo_model) {
		this.goo_model = goo_model;
	}
	public int getGoo_price() {
		return goo_price;
	}
	public void setGoo_price(int goo_price) {
		this.goo_price = goo_price;
	}
	public String getGoo_image() {
		return goo_image;
	}
	public void setGoo_image(String goo_image) {
		this.goo_image = goo_image;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getGoo_qty() {
		return goo_qty;
	}

	public void setGoo_qty(int goo_qty) {
		this.goo_qty = goo_qty;
	}
	
	
}	
