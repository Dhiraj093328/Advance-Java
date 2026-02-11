package test;

public class CryptoPayment implements PaymentStrategy{

	@Override
	public void pay(int amount) {
		System.out.print("paid " + amount);
	}

}
