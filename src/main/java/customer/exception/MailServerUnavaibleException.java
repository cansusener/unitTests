package customer.exception;

import customer.InfoService;

public class MailServerUnavaibleException extends RuntimeException {

    public MailServerUnavaibleException(String message) {
        super(message);
    }


}
