package au.com.sealink.printing.ticketprinter.exceptions;

public class NoTicketPageSettingsAssigned extends Exception {

    private static final long serialVersionUID = 1L;

    public NoTicketPageSettingsAssigned(String message) {
        super(message);
    }
}
