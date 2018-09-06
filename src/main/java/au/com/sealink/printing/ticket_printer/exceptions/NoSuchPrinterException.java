package au.com.sealink.printing.ticket_printer.exceptions;

public class NoSuchPrinterException extends Exception {

  private static final long serialVersionUID = 1L;

  public NoSuchPrinterException(String message) {
    super(message);
  }
}