package bank_products.cards;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DebitCardTest {

    @Test
    public void TestGetBalance() {
        DebitCard debCard = new DebitCard("simple debit card", "euro", 350.0);
        assertThat(debCard.getBalance()).isEqualTo(350.0);
    }

    @Test
    public void TestCardReplenishment() {
        DebitCard debCard = new DebitCard("simple debit card", "euro", 500.0);
        debCard.cardReplenishment(78.99);
        assertThat(debCard.getBalance()).isEqualTo(578.99);
    }

    @Test
    public void TestCardWriteOff() {
        DebitCard debCard = new DebitCard("simple debit card", "rub", 1500.0);
        debCard.cardWriteOff(456.46);
        assertThat(debCard.getBalance()).isEqualTo(1043.54);
    }

    @Test
    public void TestCardWriteOffBelowZero() {
        DebitCard debCard = new DebitCard("simple debit card", "rub", 0.0);
        debCard.cardWriteOff(456.89);
        assertThat(debCard.getBalance()).isEqualTo(0.0);
    }

    @Test(expected = NullPointerException.class)
    public void TestCreateInvalidDebitCard() {
        DebitCard debCard = new DebitCard(null, null, -15.0);
        debCard.cardWriteOff(456.89);
    }
}