package au.com.sealink.printing.ticket_printer.printables;

import java.awt.Graphics2D;

import au.com.sealink.printing.ticket_printer.TicketElement;

class PrintableNullElement extends PrintableElement {

    PrintableNullElement(TicketElement element) {
        super(element);
    }

    @Override
    public void drawOn(Graphics2D g) {
        // null object
    }

}
