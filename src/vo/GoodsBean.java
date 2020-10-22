package vo;

public class GoodsBean {
	private int goo_id;
	private String goo_name;
	private int goo_price;
	private String goo_model;
	private String goo_color;
	private String goo_content;
	private String goo_image;
	private String goo_date;
	private String goo_category;
	private int qty = 1;
	
	public GoodsBean() {}
		
	public GoodsBean(int goo_id, String goo_name, int goo_price, String goo_model, String goo_color, String goo_content,
			String goo_image, String goo_date, String goo_category) {
		super();
		this.goo_id = goo_id;
		this.goo_name = goo_name;
		this.goo_price = goo_price;
		this.goo_model = goo_model;
		this.goo_color = goo_color;
		this.goo_content = goo_content;
		this.goo_image = goo_image;
		this.goo_date = goo_date;
		this.goo_category = goo_category;
	}

	public GoodsBean(int goo_id, String goo_name, int goo_price, String goo_image, String goo_date, String goo_category, String goo_model) {
		super();
		this.goo_id = goo_id;
		this.goo_name = goo_name;
		this.goo_price = goo_price;
		this.goo_image = goo_image;
		this.goo_date = goo_date;
		this.goo_category = goo_category;
		this.goo_model = goo_model;
	}
	
	public GoodsBean(int goo_id, String goo_name, int goo_price, String goo_image, int qty, String goo_category, String goo_model) {
		super();
		this.goo_id = goo_id;
		this.goo_name = goo_name;
		this.goo_price = goo_price;
		this.goo_image = goo_image;
		this.qty = qty;
		this.goo_category = goo_category;
		this.goo_model = goo_model;
	}
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
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

	public String getGoo_category() {
		return goo_category;
	}

	public void setGoo_category(String goo_category) {
		this.goo_category = goo_category;
	}

	public int getGoo_price() {
		return goo_price;
	}

	public void setGoo_price(int goo_price) {
		this.goo_price = goo_price;
	}

	public String getGoo_model() {
		return goo_model;
	}

	public void setGoo_model(String goo_model) {
		this.goo_model = goo_model;
	}

	public String getGoo_color() {
		return goo_color;
	}

	public void setGoo_color(String goo_color) {
		this.goo_color = goo_color;
	}

	public String getGoo_content() {
		return goo_content;
	}

	public void setGoo_content(String goo_content) {
		this.goo_content = goo_content;
	}

	public String getGoo_image() {
		return goo_image;
	}

	public void setGoo_image(String goo_image) {
		this.goo_image = goo_image;
	}

	public String getGoo_date() {
		return goo_date;
	}

	public void setGoo_date(String goo_date) {
		this.goo_date = goo_date;
	}

}
