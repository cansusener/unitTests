package mock;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class OnAsamaTest {

    @Test
    public void testWhen() throws Exception {


        DummyCustomerService dummyCustomerService = Mockito.mock(DummyCustomerService.class);

        //Mock nesnemize davranış belirtmek için ilk yöntemimiz when().then() :

        //Eğer getCustomer() içine herhangi bir şey(anyString()) yollarsak bize “customerIstanbul” dön diyoruz
        Mockito.when(dummyCustomerService.getCustomer(anyString())).thenReturn("cansuEbru");

        String customer = dummyCustomerService.getCustomer("cansu");
        Assert.assertEquals(customer, "cansuEbru");


    }

    //@Test() annotation’una (expected = ) ifadesiyle beklediğimiz hatayı yazarsak böylelikle dönecek hatayı da test edebilmiş oluruz.
    @Test(expected = RuntimeException.class)
    public void testWhen2() throws Exception {
        DummyCustomerService dummyCustomerService = Mockito.mock(DummyCustomerService.class);

        Mockito.when(dummyCustomerService.getCustomer(anyString())).thenThrow(new RuntimeException());
        String customer = dummyCustomerService.getCustomer("cansu");

    }

    @Test
    //Void method’ları farklı şekilde test etmeliyiz :
    public void testVoid() {
        DummyCustomerService dummyCustomerService = Mockito.mock(DummyCustomerService.class);


        /*Void methodlar için ise when().then() kullanımı yerine do…().when() ile davranış belirtiyoruz.
         doNothing() ile hiçbir şey yapma demiş olduk. doThrow() ile hata fırlatmasını sağladık.
         Son olarak doReturn() ile bir şey geri dönmesini söyledik.
         Yani when().then() ile yapabildiğimiz her şeyi void bir method için yapabildik.*/

        doNothing().when(dummyCustomerService).getCustomer(anyString());
        doThrow(new RuntimeException()).when(dummyCustomerService).getCustomer((anyString()));
        doReturn("cevapdöndü").when(dummyCustomerService).getCustomer("cansu");
    }
}
