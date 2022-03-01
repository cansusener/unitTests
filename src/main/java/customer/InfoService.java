package customer;

import customer.exception.MailServerUnavaibleException;

//mail atmak için olan service’imizi temsil edecek
public class InfoService {

    public void sendMail(Customer customer){
        System.out.println("mail gönderildi");

    }

    public void exceptionMail(){
        throw new MailServerUnavaibleException("mail server hata verdi");
    }
}
