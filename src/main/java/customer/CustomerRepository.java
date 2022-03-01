package customer;

//burası bizim databaseimiz
/*
Müşteri kaydeden bir senaryomuz olacak.
 Fonksiyonumuz içersinde müşteriyi kaydedebilmek için database’e kayıt atmalı
  ve kayıt sonrası mail gönderme işlemlerini yapmalıdır.
   Unutmayalım ki bizim burada amacımız müşteri kaydeden fonksiyonu test etmek,
   database kaydını ve email göndermeyi mock’layarak sadece fonksiyonu test edebilmek istiyoruz.
 */
public class CustomerRepository {

    public void save(Customer customer) {
        System.out.println("Kaydedildi");

    }

    public void delete(Integer customerId) {
        System.out.println("Müşteri Silindi");

    }

    public Customer findCustomer(Integer customerId) {
        System.out.println("Oracle db bul.");
        return null;
    }
}
