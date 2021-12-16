package bank_products.cards;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CreditCardTest {

    @Test
    public void testGetBalance() {
        CreditCard creditCard = new CreditCard("simple credit card", "rub", 5000.0, 10.0);
        assertThat(creditCard.getBalance()).isEqualTo(5000.0);
    }

    @Test
    public void testCardReplenishment() {
        CreditCard creditCard = new CreditCard("simple credit card", "rub", 5000.0, 10.0);
        creditCard.cardReplenishment(789.99);
        assertThat(creditCard.getBalance()).isEqualTo(5789.99);
    }

    @Test
    public void TestCardWriteOff() {
        CreditCard creditCard = new CreditCard("simple credit card", "rub", 5000.0, 10.0);
        creditCard.cardWriteOff(500.0);
        assertThat(creditCard.getBalance()).isEqualTo(4500.0);
    }

    @Test
    public void TestCardWriteOffBelowZero() {
        CreditCard creditCard = new CreditCard("simple credit card", "rub", 4500.0, 10.0);
        creditCard.cardWriteOff(4999.99);
        assertThat(creditCard.getBalance()).isEqualTo(4500.0);
    }

    @Test
    public void TestGetLoanSum() {
        CreditCard creditCard = new CreditCard("simple credit card", "rub", 5000.0, 10.0);
        creditCard.cardWriteOff(500.0);
        assertThat(creditCard.getLoanSum()).isEqualTo(500.0);
    }

    @Test(expected = NullPointerException.class)
    public void TestCreateInvalidCreditCard() {
        CreditCard creditCard = new CreditCard(null, null, -500.0, -10.0);
        creditCard.cardWriteOff(500.0);
    }

}