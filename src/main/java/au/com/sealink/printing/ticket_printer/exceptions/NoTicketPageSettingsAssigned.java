package au.com.sealink.printing.ticket_printer.exceptions;

public class NoTicketPageSettingsAssigned extends Exception {

  private static final long serialVersionUID = 1L;

  public NoTicketPageSettingsAssigned() {
    super();
  }

  public NoTicketPageSettingsAssigned(String message) {
    super(message);
  }

}
