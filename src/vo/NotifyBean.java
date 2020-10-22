package vo;

public class NotifyBean {
	private int no_id;
	private String mem_name;
	private String no_title;
	private String no_content;
	private String no_image;
	private String no_date;
	private int no_hits;
	
	
	
	
	public NotifyBean(int no_id,  String no_title, String no_content, String no_image, String no_date,
			int no_hits) {
		this.no_id = no_id;
		
		this.no_title =  no_title;
		this.no_content = no_content;
		this.no_image = no_image;
		this.no_date = no_date;
		this.no_hits = no_hits;
	}
	
	public NotifyBean(int no_id, String no_title, String mem_name, String no_date, int no_hits) {
		// TODO Auto-generated constructor stub
		this.no_id = no_id;
		this.no_title =  no_title;
		this.mem_name = mem_name;
		this.no_date = no_date;
		this.no_hits = no_hits;
	}
	
	public NotifyBean(int no_id, String mem_name, String no_title, String no_content, String no_image, String no_date, int no_hits) {
		// TODO Auto-generated constructor stub
		this.no_id = no_id;
		this.mem_name = mem_name;
		this.no_title =  no_title;
		this.no_content = no_content;
		this.no_image = no_image;
		this.no_date = no_date;
		this.no_hits = no_hits;
	}
	








	public NotifyBean( ) {
		// TODO Auto-generated constructor stub
	}

	public int getNo_id() {
		return no_id;
	}
	public void setNo_id(int no_id) {
		this.no_id = no_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getNo_title() {
		return no_title;
	}
	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}
	public String getNo_image() {
		return no_image;
	}
	public void setNo_image(String no_image) {
		this.no_image = no_image;
	}
	public String getNo_date() {
		return no_date;
	}
	public void setNo_date(String no_date) {
		this.no_date = no_date;
	}
	public int getNo_hits() {
		return no_hits;
	}
	public void setNo_hits(int no_hits) {
		this.no_hits = no_hits;
	}
	
	
}