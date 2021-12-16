package bank_products.cards;

public interface Cards {

    void cardReplenishment(Double value);

    void cardWriteOff(Double value);

    Double getBalance();

}
