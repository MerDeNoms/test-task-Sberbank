package bank_products.cards;

public class CreditCard implements Cards{

    private String productName;
    private String currency;
    private Double balance;
    private Double loanPercent;

    private Double loanSum = 0.0;
    private Double totalAvailableSumOnCard;


    public void cardReplenishment(Double value) {
        balance += value;
        if (loanSum > 0 && loanSum > value) {
            loanSum -= value;
        }
        else if (loanSum > 0 && loanSum < value) {
            loanSum = 0.0;
        }
    }

    public void cardWriteOff(Double value) {
        if (balance > value) {
            balance -= value;
            if (balance < totalAvailableSumOnCard) {
                loanSum += value;
            }
        }
    }

    public Double getBalance() {
        return balance;
    }

    public double getLoanSum() {
        return loanSum;
    }

    public CreditCard(String productName, String currency, Double balance, Double loanPercent) {
        if (productName != null && currency != null && balance >= 0.0 && loanPercent > 0) {
            this.productName = productName;
            this.currency = currency;
            this.balance = balance;
            this.loanPercent = loanPercent;
            this.totalAvailableSumOnCard = balance;
        }
    }

}
