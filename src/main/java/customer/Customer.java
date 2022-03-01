package customer;

public class Customer {
    private Integer id;

    // bu id için Constructor, Getter ve Setter generate ediyoruz.
    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
