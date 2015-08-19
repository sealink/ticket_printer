package com.quicktravel.ticket_printer.printables;

import java.awt.Graphics2D;

import com.quicktravel.ticket_printer.TicketElement;

public abstract class PrintableElement {

  TicketElement element;

  // Fonts seem to need this multiplier to accurately position... 
  protected final double fontMultiplier = 0.8;

  public PrintableElement(TicketElement element) {
    this.element = element;
  }

  // Each printable element type implements this
  public abstract void drawOn(Graphics2D g);

}
