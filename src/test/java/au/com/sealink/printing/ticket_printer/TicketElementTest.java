package au.com.sealink.printing.ticket_printer;

import static org.junit.Assert.*;

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

}
