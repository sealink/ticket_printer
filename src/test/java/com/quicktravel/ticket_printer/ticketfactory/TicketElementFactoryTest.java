package com.quicktravel.ticket_printer.ticketfactory;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.quicktravel.ticket_printer.Ticket;
import com.quicktravel.ticket_printer.TicketElement;

public class TicketElementFactoryTest {

  @Test
  public void testMakeTicketList() {
    List<List<Map<String, Object>>> ticketDataList = new ArrayList<List<Map<String, Object>>>();
    ticketDataList.add(buildListOfTicketElementData());

    List<Ticket> ticketList = new TicketListFactory(ticketDataList).makeTicketList();
    assertEquals(ticketList.size(), 1);
  }

  @Test
  public void testMakeTicket() {
    List<Map<String, Object>> list = buildListOfTicketElementData();
    Ticket ticket = new TicketFactory(list).makeTicket();

    assertEquals(ticket.getElements().size(), 1);
  }

  @Test
  public void testMakeTicketElement() {
    TicketElementFactory ticketElementFactory = new TicketElementFactory(
        ticketElementData());
    TicketElement ticketElement = ticketElementFactory.makeTicketElement();

    assertEquals(ticketElement.getX(), 1);
    assertEquals(ticketElement.getY(), 2);
    assertEquals(ticketElement.getFontSize(), 3);
    assertEquals(ticketElement.isBold(), false);
    assertEquals(ticketElement.isItalic(), true);
    assertEquals(ticketElement.isImage(), false); // Interpreted from value
    assertEquals(ticketElement.getValue(), "the value will have  removed");
  }

  private List<Map<String, Object>> buildListOfTicketElementData() {
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    list.add(ticketElementData());
    return list;
  }

  private Map<String, Object> ticketElementData() {
    Map<String, Object> ticketData = new HashMap<String, Object>();
    ticketData.put("x", 1);
    ticketData.put("y", 2);
    ticketData.put("font_size", 3);
    ticketData.put("bold", false);
    ticketData.put("italic", true);
    ticketData.put("value", "the value will have &nbsp; removed");
    return ticketData;
  }

}
