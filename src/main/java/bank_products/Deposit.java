package bank_products;

public class Deposit{

    private String productName;
    private String currency;
    private Double balance;

    public void depositReplenishment(Double value) {
        balance += value;
    }

    public Double getBalance() {
        return balance;
    }

    public Deposit(String productName, String currency, Double balance) {
        if (productName != null && currency != null && balance >= 0) {
            this.productName = productName;
            this.currency = currency;
            this.balance = balance;
        }
    }

}
