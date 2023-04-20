package au.com.sealink.printing.ticketprinter.printables;

import au.com.sealink.printing.ticketprinter.TicketElement;
import java.awt.Graphics2D;

class PrintableNullElement extends PrintableElement {

    PrintableNullElement(TicketElement element) {
        super(element);
    }

    @Override
    public void drawOn(Graphics2D g) {
        // null object
    }

}
