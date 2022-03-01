package mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {

    @Mock
    private DummyCustomerServiceImpl dummyCustomerServiceImpl;

    @Before
    public void setUp() {
        dummyCustomerServiceImpl = Mockito.mock(DummyCustomerServiceImpl.class);

    }

    /*
        @Test
        public void testAnnotation() throws Exception {
            dummyCustomerService.addCustomer("cansu");

        }
    */
    @Test
    public void testAnnotation() throws Exception {
        dummyCustomerServiceImpl.addCustomer("cansu");


    }
}
