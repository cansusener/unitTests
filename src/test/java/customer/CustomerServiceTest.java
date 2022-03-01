package customer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CustomerServiceTest {

    //private CustomerRepository customerRepository;
    private CustomerService customerService;
    private InfoService infoService;
    private CustomerRepositoryStub customerRepository = new CustomerRepositoryStub();

    @Before
    public void setUp() throws Exception {
        customerService = new CustomerService();
        /*
        @Before kısmında gerçek nesne oluşturduğumuz satırları yorum haline getirdik
        ve bunun yerine sahte nesneler oluşturuyoruz.
        customerRepository = new CustomerRepository();
        infoService = new InfoService();
        */
        //customerRepository = Mockito.mock(CustomerRepository.class);
        infoService = Mockito.mock(InfoService.class);

        customerService.setCustomerRepository(customerRepository);
        customerService.setInfoService(infoService);

    }

    @Test
    public void saveCustomer() {
        Customer customer = new Customer(1234);
        customerService.saveCustomer(customer);

        //içinde customerList’i getirip içinde customer var mı yok mu? diye bakıyoruz. Eğer varsa assertTrue’yu geçer ve test başarılı olur.

        //assertTrue(customerRepository.getCustomerList().containsValue(customer));
        assertEquals(customer, customerRepository.findCustomer(customer.getId()));
        //bulunan nesne bizim nesnemiz mi? diye kontrol etmiş oluyoruz.
        //müşterinin kaydedildiğini ve mail gönderildiğini kontrol edelim
        //Mockito.verify(customerRepository).save(customer);
        Mockito.verify(infoService).sendMail(customer);
        //Burada Database’deki save methodunu çalıştırıyormuş gibi ve infoService’deki sendMail() methodunu çalıştırıyormuş gibi yaptı


    }

    @Test
    public void deleteCustomer() {
        //burada var olan bi customer ı silmeyeceğiz. Yenisini olusturup onu silmeyi kontrol edeceğiz
        customerService.saveCustomer(new Customer(1234));
        customerRepository.delete(1234);
        assertNull(customerRepository.findCustomer(1234));
    }



    /* Bu şekilde bağımlı bir yapı mevcut.
    Unit testler bağımsız olmalı */
    // sadece istediğimiz parçayı test edebilmek için mock kullanırız.
    /*Mock ile sahte nesne oluştururuz ve bu sahte nesne orijinal nesnemiz gibi davranır.
    İçi bomboş olan ve sizin istediğiniz doğrultuda hareket eden bir nesne olur. */
    //bağımlılığı ortadan kaldırabilmek ve sadece istediğimiz parçayı test edebilmek için mock kullanırız.
    // İstemediğimiz parçaları sahteleriz ve istediğimiz parçaya odaklanırız.
}