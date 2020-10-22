package vo;

public class OrderGoodsBean {
	private int goo_id;
	private int ord_id;
	private int ord_price;
	private int ord_qty;
	
	public OrderGoodsBean(int goo_id, int ord_id, int ord_qty, int ord_price) {
		this.goo_id = goo_id;
		this.ord_id = ord_id;
		this.ord_qty = ord_qty;
		this.ord_price = ord_price;
	}
	
	
	public int getGoo_id() {
		return goo_id;
	}
	public void setGoo_id(int goo_id) {
		this.goo_id = goo_id;
	}
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public int getOrd_price() {
		return ord_price;
	}
	public void setOrd_price(int ord_price) {
		this.ord_price = ord_price;
	}
	public int getOrd_qty() {
		return ord_qty;
	}
	public void setOrd_qty(int ord_qty) {
		this.ord_qty = ord_qty;
	}
	
	
	
	
	

	

	
}
