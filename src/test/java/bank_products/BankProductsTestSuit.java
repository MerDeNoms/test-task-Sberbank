package bank_products;

import bank_products.cards.CreditCardTest;
import bank_products.cards.DebitCardTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CreditCardTest.class, DebitCardTest.class, DepositTest.class} )
public class BankProductsTestSuit {

}
