package au.com.sealink.printing.ticketprinter;

import java.util.ArrayList;

/* A ticket is defined by a list of elements
 *
 * Each element has attributes that define it's position, font style and text.
 */
public class Ticket {

    private ArrayList<TicketElement> elements = new ArrayList<>();

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
