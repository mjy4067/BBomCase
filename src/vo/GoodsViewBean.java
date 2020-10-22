package vo;

public class GoodsViewBean {
	private int goo_id;
	private String goo_image;
	private String goo_name;
	private String goo_category;
	private String goo_model;
	private String goo_color;
	private int sto_qty;
	private String date;

	public GoodsViewBean(int goo_id, String goo_image, String goo_name, String goo_category, String goo_model,
			String goo_color, int sto_qty, String date) {
		super();
		this.goo_id = goo_id;
		this.goo_image = goo_image;
		this.goo_name = goo_name;
		this.goo_category = goo_category;
		this.goo_model = goo_model;
		this.goo_color = goo_color;
		this.sto_qty = sto_qty;
		this.date = date;
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

	public int getGoo_id() {
		return goo_id;
	}

	public void setGoo_id(int goo_id) {
		this.goo_id = goo_id;
	}

	public String getGoo_image() {
		return goo_image;
	}

	public void setGoo_image(String goo_image) {
		this.goo_image = goo_image;
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

	public int getSto_qty() {
		return sto_qty;
	}

	public void setSto_qty(int sto_qty) {
		this.sto_qty = sto_qty;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
