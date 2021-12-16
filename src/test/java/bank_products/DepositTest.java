package bank_products;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DepositTest {

    @Test
    public void testGetBalance() {
        Deposit deposit = new Deposit("simple deposit", "rub", 3000.0);
        assertThat(deposit.getBalance()).isEqualTo(3000.0);
    }

    @Test
    public void testDepositReplenishment() {
        Deposit deposit = new Deposit("simple deposit", "rub", 3000.0);
        deposit.depositReplenishment(572.46);
        assertThat(deposit.getBalance()).isEqualTo(3572.46);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateInvalidDeposit() {
        Deposit deposit = new Deposit(null, null, -1000.0);
        deposit.depositReplenishment(189.77);
    }

}
