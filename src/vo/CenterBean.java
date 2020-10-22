package vo;

public class CenterBean {
	private int cc_id;
	private String mem_id;
	private String cc_title;
	private String cc_content;
	private String cc_image;
	private String cc_date;
	private int has_re;
	private int re_lev;
	private int re_step;
	private String cc_secret;
	
	
	
	
	
	
	
	public CenterBean(int cc_id, String mem_id, String cc_title, String cc_date, 
			int has_re, int re_lev, int re_step, String cc_secret ) {
		this.cc_id = cc_id;
		this.mem_id = mem_id;
		this.cc_title = cc_title;
		this.cc_date = cc_date;
		this.has_re = has_re;
		this.re_lev = re_lev;
		this.re_step = re_step;
		this.cc_secret = cc_secret;
		
	}
	
	
	
	public CenterBean(int cc_id, String mem_id, String cc_title, String cc_content, String cc_image, String cc_date, int has_re,
			int re_lev, int re_step, String cc_secret) {
		// TODO Auto-generated constructor stub
		this.cc_id = cc_id;
		this.mem_id = mem_id;
		this.cc_title = cc_title;
		this.cc_content = cc_content;
		this.cc_image = cc_image;
		this.cc_date = cc_date;
		this.has_re = has_re;
		this.re_lev = re_lev;
		this.re_step = re_step;
		this.cc_secret = cc_secret;
	}



	public CenterBean() {
		// TODO 자동 생성된 생성자 스텁
	}



	public int getCc_id() {
		return cc_id;
	}
	public void setCc_id(int cc_id) {
		this.cc_id = cc_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getCc_title() {
		return cc_title;
	}
	public void setCc_title(String cc_title) {
		this.cc_title = cc_title;
	}
	public String getCc_content() {
		return cc_content;
	}
	public void setCc_content(String cc_content) {
		this.cc_content = cc_content;
	}
	public String getCc_image() {
		return cc_image;
	}
	public void setCc_image(String cc_image) {
		this.cc_image = cc_image;
	}
	public String getCc_date() {
		return cc_date;
	}
	public void setCc_date(String cc_date) {
		this.cc_date = cc_date;
	}
	public int getHas_re() {
		return has_re;
	}
	public void setHas_re(int has_re) {
		this.has_re = has_re;
	}
	public int getRe_lev() {
		return re_lev;
	}
	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public String getCc_secret() {
		return cc_secret;
	}
	public void setCc_secret(String cc_secret) {
		this.cc_secret = cc_secret;
	}


	
	
	
	
}
