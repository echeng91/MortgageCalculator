import java.text.NumberFormat;

public class Mortgage {

	private double principal;
	private double rate;
	private int term;
	private double payment;
	
	//Constructors
	public Mortgage() {
		
	}
	
	public Mortgage(double _principal, double _rate, int _term) {
		principal = _principal;
		rate = _rate;
		term = _term;
		payment = (principal * rate) / (1 - Math.pow(1 + rate, -term));
	}
	
	//Getters
	public double getPrincipal() {
		return principal;
	}
	public double getRate() {
		return rate;
	}
	public int getTerm() {
		return term;
	}
	public double getPayment() {
		return payment;
	}
	
	//Setters
	public void setPrincipal(double _principal) {
		principal = _principal;
	}
	public void setRate(double _rate) {
		rate = _rate;
	}
	public void setTerm(int _term) {
		term = _term;
	}
	public void setPayment(double _payment) {
		payment = _payment;
	}
	
	//Other methods
	public String getFormattedPayment() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String paymentString = currency.format(payment);
		return paymentString;
	}
}
