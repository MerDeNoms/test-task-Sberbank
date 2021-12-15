package bank_products.cards;

public abstract class Card{

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

    protected void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public Card(String productName, String currency, Double balance) {
        if (productName != null && currency != null && balance >= 0) {
            this.productName = productName;
            this.currency = currency;
            this.balance = balance;
        }
    }

}
