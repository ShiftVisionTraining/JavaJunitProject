package com.shiftvision.qa.test;

import com.shiftvision.qa.bank.Account;
import com.shiftvision.qa.exception.ShiftVisionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountJUnitTest {
    private Account account;

    @BeforeEach
    public void beforeEachTest(){
        account = new Account("123", "Iftekhar Ivaan");
    }

    @Test
    public void depositTest1(){
//        Account account;
//        account = new Account("12345678", "Iftekhar Ivaan");
        account.deposit(100);
        double balance = account.getBalance();
        assertEquals(100.0, balance);
    }

    @Test
    public void depositTest2(){
//        Account account;
//        account = new Account("12345678", "Iftekhar Ivaan");
        ShiftVisionException thrown = assertThrows(
            ShiftVisionException.class,
            () -> {
                account.deposit(-100);
            });
        assertTrue(thrown.getMessage().contains("Deposit amount can not be less then 0"));
    }

    @Test
    public void depositTest3(){
//        Account account;
//        account = new Account("12345678", "Iftekhar Ivaan");
        ShiftVisionException thrown = assertThrows(
                ShiftVisionException.class,
                () -> {
                    account.deposit(0);
                });
        assertTrue(thrown.getMessage().contains("Deposit amount can not be 0"));
    }

    @AfterEach
    public void afterEachTest(){
        account = null;
    }

}
