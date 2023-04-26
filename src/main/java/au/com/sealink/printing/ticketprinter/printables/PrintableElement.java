package au.com.sealink.printing.ticketprinter.printables;

import au.com.sealink.printing.ticketprinter.TicketElement;
import java.awt.Graphics2D;

public abstract class PrintableElement {

    TicketElement element;

    // Fonts seem to need this multiplier to accurately position...
    final double fontMultiplier = 0.8;

    PrintableElement(TicketElement element) {
        this.element = element;
    }

    // Each printable element type implements this
    public abstract void drawOn(Graphics2D g);

}
