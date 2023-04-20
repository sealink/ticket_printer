package au.com.sealink.printing.ticketprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import au.com.sealink.printing.ticketprinter.Justification;
import au.com.sealink.printing.ticketprinter.TicketElement;

import org.junit.Before;
import org.junit.Test;

public class TicketElementTest {

    private TicketElement emptyticket;
    private TicketElement imageticket;
    private final String imageString = "image: setupusthebomb";
    private final int imageOffset = 6;

    @Before
    public void setUp() throws Exception {
        emptyticket = new TicketElement();
        imageticket = new TicketElement();
        imageticket.setValue(imageString);
    }

    @Test
    public void testImageElementIsDetectedAsImage() {
        assertTrue(imageticket.isImage());
    }

    @Test
    public void testNonImageElementIsNotDetectedAsImage() {
        assertFalse(emptyticket.isImage());
    }

    @Test
    public void testGetImageElementImageValue() {
        assertEquals(imageString.substring(imageOffset), imageticket.getImageValue());
    }

    @Test
    public void testBasicGettersAndSetters() {
        TicketElement element = new TicketElement();
        element.setBold(true);
        element.setInverted(false);
        element.setItalic(true);
        element.setJustification(Justification.CENTRE);
        element.setX(10);
        element.setY(1);
        element.setFontSize(10);
        element.setHeight(50);
        element.setWidth(30);

        assertTrue(element.isBold());
        assertFalse(element.isInverted());
        assertTrue(element.isItalic());
        assertEquals(Justification.CENTRE, element.getJustification());
        assertEquals(10, element.getX());
        assertEquals(1, element.getY());
        assertEquals(10, element.getFontSize());
        assertEquals(50, (int)element.getHeight());
        assertEquals(30, (int)element.getWidth());
    }
}
