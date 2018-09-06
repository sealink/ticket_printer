package au.com.sealink.printing.ticket_printer;

import java.util.ArrayList;
import java.util.List;

/* A ticket is defined by a list of elements
 *
 * Each element has attributes that define it's position, font style and text.
 */
public class Ticket {

    private List<TicketElement> elements;

    public Iterable<TicketElement> getElements() {
        return this.elements;
    }

    public void addElements(Iterable<TicketElement> elements) {
        for (TicketElement el : elements) {
            addElement(el);
        }
    }

    public void addElement(TicketElement element) {
        this.elements.add(element);
    }
}
