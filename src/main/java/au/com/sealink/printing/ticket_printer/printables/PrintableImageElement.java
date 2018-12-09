package au.com.sealink.printing.ticket_printer.printables;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import au.com.sealink.printing.ticket_printer.TicketElement;

class PrintableImageElement extends PrintableElement {

    private final double printerResolution = 72.0 / 25.4; // 72 dots per inch
    private final Image img;

    PrintableImageElement(TicketElement element, Image img) {
        super(element);
        this.img = img;
    }

    @Override
    public void drawOn(Graphics2D g) {
        if (img == null)
            return;

        g.drawImage(
                this.img,
                element.getX(),
                element.getY(),
                getWidth(),
                getHeight(),
                null  // no observer
        );
    }

    private int getHeight() {
        if (element.getHeight() != null) {
            return element.getHeight();
        } else {
            return (int) (img.getHeight(null) / printerResolution * fontMultiplier);
        }
    }

    private int getWidth() {
        if (element.getWidth() != null) {
            return element.getWidth();
        } else {
            return (int) (img.getWidth(null) / printerResolution * fontMultiplier);
        }
    }
}
