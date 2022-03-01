package customer;

import customer.exception.MailServerUnavaibleException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ExceptionTest {
    private InfoService infoService = new InfoService();

    //Bu test class’ı içinde 4 farklı yöntem kullanarak hataları yakalamaya çalışacağız. İlk yöntem try-catch yöntemidir.
    // Test edeceğimiz methodu çağırıp , catch içinde yakaladığımız hatayı sorgulayabiliriz.

    // 1. YÖNTEM
    @Test
    public void testTryCatch() {
        try {
            infoService.exceptionMail();
        } catch (Exception e) {
            assertTrue(e instanceof MailServerUnavaibleException);
            //Catch içinde yakalanan hatanın kendi hata sınıfımız olduğunu ve
            // içindeki mesajın “mail server hata veriyor” olduğunu kontrol ediyoruz.
            assertEquals("mail server hata verdi", e.getMessage());
        }
    }

    // 2. YÖNTEM
    //Bu method çalıştırıldığında bir hata bekliyorum ve bu hata expected ekinde verdiğim hata olmalı diyorum.
    // Bu yöntemin dezavantajı hata mesajının ne olduğunu kontrol etmemesidir.
    @Test(expected = MailServerUnavaibleException.class)
    public void testExceptedException() {
        infoService.exceptionMail();
    }
/*
    // 3. YÖNTEM
    @Rule
    public ExpectedException myException = ExpectException.none();

    @Test
    public void testRuleException() throws Exception {
        myException.expect(MailServerUnavaibleException.class);
        myException.expectMessage("mail server hata verdi");

        infoService.exceptionMail();
    }
*/ // 3. yöntemde none??


}

