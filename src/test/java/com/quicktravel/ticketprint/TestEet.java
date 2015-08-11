package com.quicktravel.ticketprint;

// TODO: Write some tests so that the imports actually get used

import static org.junit.Assert.fail;

import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.quicktravel.ticket_printer.Ticket;
import com.quicktravel.ticket_printer.TicketElement;
import com.quicktravel.ticket_printer.TicketPrinter;
import com.quicktravel.ticket_printer.printables.NoSuchPrinterException;
import com.quicktravel.ticket_printer.printables.NoTicketPageSettingsAssigned;

public class TestEet {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

//	  @Test
//	  public void test_do_a_print() throws NoSuchPrinterException, NoTicketPageSettingsAssigned, PrinterException {
//	    TicketPrinter ticketPrinter = new TicketPrinter();
//	    ticketPrinter.setTicketPageSettings(87f, 57f, 2f);
//
//	    List<Ticket> tickets = new ArrayList<Ticket>();
//	
//	    TicketElement element = new TicketElement();
//	    element.setX(10);
//	    element.setY(10);
//	    element.setValue("HELLO!");
//
//	    Ticket ticket = new Ticket();
//	    ticket.addElement(element);
//
//	    tickets.add(ticket);
//
//	    ticketPrinter.setPrinter(1); // Select printer 2 (index) 
//	    ticketPrinter.printTickets(tickets);
//	  }
}
