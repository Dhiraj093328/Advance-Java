package test;

public class AppTest {

	public static void main(String[] args) {
		
		//constructor Injection
		ShoppingCart cart= new ShoppingCart();
		
		
		//setter method Injection
		cart.setPaymentStrategy(new CreditCardPayment());
		cart.checkout(100);

	}

}
