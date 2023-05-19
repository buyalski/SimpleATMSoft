package classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountFunctionsTest {
    private Account account;

    @Before
    public void init(){
        account = new Account("Test", 0, "USD", "1234");
    }
    @Test
    public void withdraw() {
        account.setAccountBalance(51);
        account.withdraw(50);
        assertEquals(account.getAccountBalance(), 1.0);
    }

    @Test
    public void changePin() {
        account.setPinCode("1231");
        assertEquals(account.getPinCode(), "1231");
    }

    @Test
    public void topUp() {
        account.setAccountBalance(101);
        assertEquals(account.getAccountBalance(), 101);
    }
}