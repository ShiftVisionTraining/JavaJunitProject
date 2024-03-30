package com.shiftvision.qa.test;

import com.shiftvision.qa.bank.Account;
import com.shiftvision.qa.exception.ShiftVisionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountConstractorTest {

    @Test
    public void accountNumberTest1(){
        ShiftVisionException thrown = assertThrows(
                ShiftVisionException.class,
                () -> {
                    Account account = new Account("123", "Iftekhar Ivaan");
                });
        assertTrue(thrown.getMessage().contains("Account number can not be less then or equal to 4 char"));
    }


    @Test
    public void accountNumberTest2(){
        ShiftVisionException thrown = assertThrows(
                ShiftVisionException.class,
                () -> {
                    Account account = new Account("1234", "Iftekhar Ivaan");
                });
        assertTrue(thrown.getMessage().contains("Account number can not be less then or equal to 4 char"));
    }

    @Test
    public void accountNumberTest3(){
        Account account = new Account("12345678", "Iftekhar Ivaan");
        assertNotNull(account);
    }
}
