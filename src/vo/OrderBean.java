package vo;

import java.sql.Timestamp;

public class OrderBean {
	private int ord_id;
	private String mem_id;
	private String receiver;
	private String ord_tel;
	private String ord_email;
	private int zip_code;
	private String addr1;
	private String addr2;
	private int ord_total;
	private String ord_date;
	private String ord_state;
	private String payment;
	
	public OrderBean() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderBean(int ord_id, String mem_id, String ord_date, 
					String ord_state, int ord_total) {
		this.ord_id = ord_id;
		this.mem_id = mem_id;
		this.ord_date = ord_date;
		this.ord_state = ord_state;
		this.ord_total = ord_total;
	}
	
	public OrderBean(int ord_id, String mem_id, String receiver, 
					String ord_tel, String ord_email, int zip_code, 
					String addr1, String addr2, int ord_total, 
					String ord_date, String ord_state, String payment) {
		this.ord_id = ord_id;
		this.mem_id = mem_id;
		this.receiver = receiver;
		this.ord_tel = ord_tel;
		this.ord_email = ord_email;
		this.zip_code = zip_code;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.ord_total = ord_total;
		this.ord_date = ord_date;
		this.ord_state = ord_state;
		this.payment = payment;
	}
	
	
	public OrderBean(int ord_id, String mem_id, String receiver, int ord_total, 
			String ord_date, String ord_state, String payment) {
		this.ord_id = ord_id;
		this.mem_id = mem_id;
		this.receiver = receiver;
		this.ord_total = ord_total;
		this.ord_date = ord_date;
		this.ord_state = ord_state;
		this.payment = payment;
		
	}
	

	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getOrd_tel() {
		return ord_tel;
	}
	public void setOrd_tel(String ord_tel) {
		this.ord_tel = ord_tel;
	}
	public String getOrd_email() {
		return ord_email;
	}
	public void setOrd_email(String ord_email) {
		this.ord_email = ord_email;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public int getOrd_total() {
		return ord_total;
	}
	public void setOrd_total(int ord_price) {
		this.ord_total = ord_price;
	}
	public String getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(String ord_date) {
		this.ord_date = ord_date;
	}
	public String getOrd_state() {
		return ord_state;
	}
	public void setOrd_state(String ord_state) {
		this.ord_state = ord_state;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
	

	


}
