package model;

public class BillDetails {
	private String  idProduct ; 
	private String idBill ; 
	private String date ; 
	private int count ;
	
	
	
	public BillDetails() {
		
	}
	public BillDetails(String idProduct, String idBill, String date, int count) {
		super();
		this.idProduct = idProduct;
		this.idBill = idBill;
		this.date = date;
		this.count = count;
	}
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getIdBill() {
		return idBill;
	}
	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "ViewDetails [idProduct=" + idProduct + ", idBill=" + idBill + ", date=" + date + ", count=" + count
				+ "]";
	} 
	
	
	
}
