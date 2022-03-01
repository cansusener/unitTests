package customer;

//sıl işimizi yapacak olan ve bizim Unit Test’ini gerçekleştireceğimiz

//Burada bizim test etmek istediğimiz method saveCustomer()’dır.
public class CustomerService {

    private CustomerRepository customerRepository;
    private InfoService infoService;

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
        infoService.sendMail(customer);
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    public void deleteCustomer(Integer customerId) {
        customerRepository.delete(customerId);

    }

}
