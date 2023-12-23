package model.entities;

public class Invoice {

	private Double basicPayment;
	private Double tax;
	private Double totalPayment;
	
	public Invoice() {
		
	}
	
	
	public Invoice(Double basicPayment, Double tax) {
		
		this.basicPayment=basicPayment;
		this.tax=tax;
	}
	
	public void setBasicPayment(Double basicPayment) {
		this.basicPayment=basicPayment;
		
	}
	
	public Double getBasicPayment() {
		return basicPayment;
	}
	
	public void setTax(Double tax) {
		this.tax=tax;
		
	}
	
	public Double getTax() {
		return tax;
	}


	public double getTotalPayment() {
		return getBasicPayment() + getTax();

	}


	
	
	
	
}
