package au.com.sealink.printing.ticketprinter.printables;

import au.com.sealink.printing.ticketprinter.TicketElement;
import java.awt.Font;
import java.awt.Graphics2D;

class PrintableTextElement extends PrintableElement {

    private static final String FONTNAME = "Verdana";

    PrintableTextElement(TicketElement element) {
        super(element);
    }

    @Override
    public void drawOn(Graphics2D g) {
        Font currentFont = this.calculateFont();
        g.setFont(currentFont);

        // Adjust y for maximum ascent of all printable characters
        int y = element.getY() + g.getFontMetrics(currentFont).getMaxAscent();

        g.drawString(element.getValue(), element.getX(), y);
    }

    private Font calculateFont() {
        return new Font(PrintableTextElement.FONTNAME, getFontStyle(), getPrintableFontSize());
    }

    private int getFontStyle() {
        int style = Font.PLAIN;
        if (element.isBold()) {
            style |= Font.BOLD;
        }
        if (element.isItalic()) {
            style |= Font.ITALIC;
        }
        return style;
    }

    private int getPrintableFontSize() {
        return (int) (element.getFontSize() * super.fontMultiplier);
    }
}
