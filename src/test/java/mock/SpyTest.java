package mock;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class SpyTest {

//SPY(Casus) nesneler yerine göre hem gerçek nesne hem de mock nesnesi olarak davranabiliyor
    @Test
    public void testSpy() throws Exception{

        //Mockito.spy() içinde gerçek nesnemizi oluşturduk.
        DummyCustomerService dummyCustomerService = Mockito.spy(new DummyCustomerServiceImpl());

        doNothing().when(dummyCustomerService).addCustomer(eq("cansu"));
        dummyCustomerService.addCustomer("cansu");


    }
}
