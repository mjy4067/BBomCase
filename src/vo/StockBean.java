package vo;

public class StockBean {
	private int sto_id;
	private int goo_id;
	private String sto_import;
	private String sto_export;
	private int sto_qty;
	private String sto_date;

	public StockBean(int sto_id, String sto_import, String sto_export, int sto_qty, String sto_date, int goo_id) {
		super();
		this.sto_id = sto_id;
		this.sto_import = sto_import;
		this.sto_export = sto_export;
		this.sto_qty = sto_qty;
		this.sto_date = sto_date;
		this.goo_id = goo_id;
	}

	public StockBean(int sto_id, int goo_id, String sto_export, int sto_qty, String sto_date) {
		// TODO 자동 생성된 생성자 스텁
		this.sto_id = sto_id;
		this.goo_id = goo_id;
		this.sto_export = sto_export;
		this.sto_qty = sto_qty;
		this.sto_date = sto_date;
		
	}
	public StockBean(int sto_id, int goo_id, String sto_import, String sto_export, int sto_qty, String sto_date) {
		super();
		this.sto_id = sto_id;
		this.goo_id = goo_id;
		this.sto_import = sto_import;
		this.sto_export = sto_export;
		this.sto_qty = sto_qty;
		this.sto_date = sto_date;
	}
	public String getSto_import() {
		return sto_import;
	}

	public void setSto_import(String sto_import) {
		this.sto_import = sto_import;
	}

	public String getSto_export() {
		return sto_export;
	}

	public void setSto_export(String sto_export) {
		this.sto_export = sto_export;
	}

	public int getSto_qty() {
		return sto_qty;
	}

	public void setSto_qty(int sto_qty) {
		this.sto_qty = sto_qty;
	}

	public String getSto_date() {
		return sto_date;
	}

	public void setSto_date(String sto_date) {
		this.sto_date = sto_date;
	}

	public int getSto_id() {
		return sto_id;
	}

	public void setSto_id(int sto_id) {
		this.sto_id = sto_id;
	}

	public int getGoo_id() {
		return goo_id;
	}

	public void setGoo_id(int goo_id) {
		this.goo_id = goo_id;
	}

}
