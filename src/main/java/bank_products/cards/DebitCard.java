package bank_products.cards;

public class DebitCard implements Cards{

    private String productName;
    private String currency;
    private Double balance;

    public void cardReplenishment(Double value) {
        balance += value;
    }

    public void cardWriteOff(Double value) {
        if (balance > value) {
            balance -= value;
        }
    }

    public Double getBalance() {
        return balance;
    }

    public DebitCard(String productName, String currency, Double balance) {
        if (productName != null && currency != null && balance >= 0) {
            this.productName = productName;
            this.currency = currency;
            this.balance = balance;
        }
    }

}
