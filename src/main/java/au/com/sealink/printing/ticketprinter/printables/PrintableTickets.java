package au.com.sealink.printing.ticketprinter.printables;

import au.com.sealink.printing.ticketprinter.Ticket;
import au.com.sealink.printing.ticketprinter.TicketElement;
import au.com.sealink.printing.utils.ImageLoader;
import au.com.sealink.printing.utils.NumberConverter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;


/**
 * <p> This class represents a printable ticket.
 * 
 * Printable interface requires #print to be implemented (called when printed)
 * 
 */
public class PrintableTickets implements Printable {

    private ArrayList<Ticket> tickets = new ArrayList<>();

    public PrintableTickets(Iterable<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            this.tickets.add(ticket);
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex >= tickets.size()) {
            return (NO_SUCH_PAGE);
        }

        Graphics2D g = configureGraphics(graphics, pageFormat);

        // Pull out page of ticket
        Ticket ticket = tickets.get(pageIndex);

        // Iterate over its elements
        for (TicketElement element : ticket.getElements()) {
            printableElementFor(element).drawOn(g);
        }

        return PAGE_EXISTS;
    }

    private PrintableElement printableElementFor(TicketElement element) {
        if (element.isImage()) {
            Image img = ImageLoader.loadImage(element);
            if (img == null) {
                return new PrintableNullElement(element);
            } else {
                return new PrintableImageElement(element, img);
            }
        } else {
            return new PrintableTextElement(element);
        }
    }

    // Configure the graphics canvas
    private Graphics2D configureGraphics(Graphics graphics, PageFormat pageFormat) {
        Graphics2D g = (Graphics2D) graphics;

        // Translate to fit to printable area
        g.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        /**
         * The AffineTransform class represents a 2D affine transform that performs
         * a linear mapping from 2D coordinates to other 2D coordinates that
         * preserves the "straightness" and "parallel" of lines.
         */
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.scale(NumberConverter.mm2finch(1), NumberConverter.mm2finch(1));
        g.transform(affineTransform);

        return g;
    }

}