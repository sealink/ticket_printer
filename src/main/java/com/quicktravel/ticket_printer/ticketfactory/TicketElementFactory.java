package com.quicktravel.ticket_printer.ticketfactory;

import java.util.Map;

import com.quicktravel.ticket_printer.TicketElement;
import com.quicktravel.utils.NumberConverter;

public class TicketElementFactory {

  Map<String, Object> attributes;

  public TicketElementFactory(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  public TicketElement makeTicketElement() {

    TicketElement ticketElement = new TicketElement();

    ticketElement.setX(this.intAttr("x"));
    ticketElement.setY(this.intAttr("y"));

    ticketElement.setFontSize(this.intAttr("font_size"));

    ticketElement.setBold(this.booleanAttr("bold"));
    ticketElement.setItalic(this.booleanAttr("italic"));

    ticketElement.setValue(this.valueAttr());

    return ticketElement;
  }

  
  // Get the value -- the field content to print
  private String valueAttr() {
    return stringAttr("value").replaceAll("&nbsp;", "");
  }

  private boolean booleanAttr(String attrName) {
    return stringAttr(attrName).equals("true");
  }

  private int intAttr(String attrName) {
    int intValue = 0;                            /// TODO: How to handle bad values???
    String rawValue = stringAttr(attrName);

    try {
      intValue = NumberConverter.objectToInt(rawValue);
    } catch (NumberFormatException e) {
      System.out.println("-----------------");
      System.out.println("NumberFormatException: " + e.getMessage());
      System.out.println("Invalid number for attrName: [" + attrName + "], value: [" + rawValue + "]");
      System.out.println("-----------------");
    }

    return intValue;
  }

  private String stringAttr(String attrName) {
    return attributes.get(attrName).toString();
  }
}