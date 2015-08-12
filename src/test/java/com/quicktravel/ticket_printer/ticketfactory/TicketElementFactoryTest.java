package com.quicktravel.ticket_printer.ticketfactory;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.*;

import com.quicktravel.ticket_printer.TicketElement;

public class TicketElementFactoryTest {

  @Test
  public void testMakeTicketElement() {
    Map<String, Object> ticketData = new HashMap<String, Object>();
    ticketData.put("x", 1);
    ticketData.put("y",  2);
    ticketData.put("font_size",  3);
    ticketData.put("bold",  false);
    ticketData.put("italic",  true);
    ticketData.put("value", "the value will have &nbsp; removed");
    
    TicketElement ticketElement = (new TicketElementFactory(ticketData)).makeTicketElement();
    
    assertEquals(ticketElement.getX(), 1);
    assertEquals(ticketElement.getY(), 2);
    assertEquals(ticketElement.getFontSize(), 3);
    assertEquals(ticketElement.isBold(), false);
    assertEquals(ticketElement.isItalic(), true);
    assertEquals(ticketElement.isImage(), false); // Interpreted from value
    assertEquals(ticketElement.getValue(), "the value will have  removed");
  }

}
