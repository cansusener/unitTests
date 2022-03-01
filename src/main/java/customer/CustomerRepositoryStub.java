package customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryStub extends CustomerRepository {
    //database modelimiz içindeki save ve delete method’larını override edeceğiz

    private Map<Integer, Customer> customerList = new HashMap<Integer, Customer>();

    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public void delete(Integer customerId) {
        customerList.remove(customerId);
    }

    /* public Map<Integer, Customer> getCustomerList(){
         return customerList;
     }
     */

    //getCustomerList()’i silip onun yerine findCustomer()’ı eklemiş olduk.
    @Override
    public Customer findCustomer(Integer customerId) {
        System.out.println("Oracle db bul.");
        return null;
    }
}
