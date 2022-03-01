package mock;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;

public class BehaviorTest {

    @Test
    public void behaviorTest() throws Exception {

        //bir mock nesnesi oluşturduk
        DummyCustomerService dummyCustomerService = Mockito.mock(DummyCustomerService.class);

        dummyCustomerService.addCustomer("cansu");
        dummyCustomerService.addCustomer("cansu");
        dummyCustomerService.addCustomer("cansu");

        dummyCustomerService.addCustomer("ebru");

        //Mockito.verify() ile gerçekten bu methodları çağırıp çağıramadığımızı kontrol ettik.
        Mockito.verify(dummyCustomerService).addCustomer("cansu");
        Mockito.verify(dummyCustomerService).addCustomer("ebru");
        //Mockito.verify(dummyCustomerService).addCustomer("xx");

        //times() methodu
        // Mockito.times() methodu sayesinde method’un kaç kez çağrıldığını test eder
        Mockito.verify(dummyCustomerService, Mockito.times(3)).addCustomer("cansu");
        Mockito.verify(dummyCustomerService, Mockito.times(1)).addCustomer("ebru");

        //times(1) yazmasak da olur çünkü default olarak 1 değeri verilir.

        //Mockito.verify() içine ikinci parametre olarak Mockito.never() verdiğimizde o method’un hiç çağrılmadığını doğrulamış oluyoruz.

        //never() methodu: hiç çağrılmadı diyoruz
        Mockito.verify(dummyCustomerService, Mockito.never()).removeCustomer(anyString());
        Mockito.verify(dummyCustomerService, Mockito.atLeast(2)).addCustomer("cansu"); //“en azından 2 kere çağrıldı.” demiş olduk
    }
    @Test
    public void testOrder(){
        DummyCustomerService dummyCustomerService = Mockito.mock(DummyCustomerService.class);

        dummyCustomerService.addCustomer("İstanbul");
        dummyCustomerService.addCustomer("Ankara");
        dummyCustomerService.updateCustomer("İzmir");

        //InOrder sınıfı sayesinde method’ların çağrılış sırasını test ettik.
        // Method’ları çağırdığımız sırada inOrder.verify()’ları çağırdık
        //  Böylelikle doğru sırada çağrıldıklarını test ettik.
        InOrder order = Mockito.inOrder(dummyCustomerService);

        order.verify(dummyCustomerService).addCustomer("İstanbul");
        order.verify(dummyCustomerService).addCustomer("Ankara");
       order.verify(dummyCustomerService).updateCustomer("İzmir");

        Mockito.verifyNoMoreInteractions(dummyCustomerService); //verift edılmeyenler cagrılmasın
        //Mockito.verifyZeroInteractions(dummyCustomerService); //ise verilen mock nesnesin hiçbir şekilde çağrılmadığını test eder.
    }

}
