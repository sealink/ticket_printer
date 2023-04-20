package au.com.sealink.printing.ticketprinter.exceptions;

public class NoSuchPrinterException extends Exception {

    private static final long serialVersionUID = 1L;

    public NoSuchPrinterException(String message) {
        super(message);
    }
}