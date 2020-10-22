package vo;

public class BoardBean {
	private int id;
	private int goo_id;
	private String goo_name;
	private String mem_id;
	private String title;
	private String content;
	private String image;
	private String date;
	private int hits;
	private int secret;
	private String reply;

	public BoardBean(int id, int goo_id, String mem_id, String title, String content, String image,
			String date, int hits, int secret, String reply) {
		super();
		this.id = id;
		this.goo_id = goo_id;
		this.mem_id = mem_id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.date = date;
		this.hits = hits;
		this.secret = secret;
		this.reply = reply;
	}

	public BoardBean(int id, int goo_id, String goo_name, String mem_id, String title, String content, String image, String date, int hits) {
		super();
		this.id = id;
		this.goo_id = goo_id;
		this.goo_name = goo_name;
		this.mem_id = mem_id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.date = date;
		this.hits = hits;
	}
	
	public BoardBean(int id, int goo_id, String goo_name, String mem_id, String title, String content, String image,
			String date, int hits, int secret) {
		super();
		this.id = id;
		this.goo_id = goo_id;
		this.goo_name = goo_name;
		this.mem_id = mem_id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.date = date;
		this.hits = hits;
		this.secret = secret;
	}

	public BoardBean(int qna_id, String mem_id, String title, String content, String image, String date, int hits,
			int secret) {
		super();
		this.id = qna_id;
		this.mem_id = mem_id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.date = date;
		this.hits = hits;
		this.secret = secret;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public BoardBean() {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getSecret() {
		return secret;
	}

	public void setSecret(int secret) {
		this.secret = secret;
	}

}
