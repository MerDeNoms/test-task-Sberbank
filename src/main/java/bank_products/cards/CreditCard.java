package bank_products.cards;

public class CreditCard extends Card {

    private Double loanPercent;
    private Double loanSum;
    private final Double totalAvailableSumOnCard = getBalance();

    @Override
    public void cardReplenishment(Double value) {
        double balance = getBalance();
        balance += value;
        if (loanSum > 0 && loanSum > value) {
            loanSum -= value;
        }
        else if (loanSum > 0 && loanSum < value) {
            loanSum = 0.0;
        }
        setBalance(balance);
    }

    @Override
    public void cardWriteOff(Double value) {
        double balance = getBalance();
        if (balance > value) {
            balance -= value;
            if (balance < totalAvailableSumOnCard) {
                loanSum += value;
            }
        }
    }

    public double getLoanSum() {
        return loanSum;
    }

    public CreditCard(String productName, String currency, Double balance, Double loanPercent) {
        super(productName, currency, balance);
        if (loanPercent > 0) {
            this.loanPercent = loanPercent;
        }
    }

}
