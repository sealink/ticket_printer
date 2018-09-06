package au.com.sealink.printing.ticket_printer;

import java.awt.print.PrinterJob;

import javax.print.PrintService;

import au.com.sealink.printing.ticket_printer.exceptions.NoSuchPrinterException;

public class PrintServiceLocator {

  public PrintServiceLocator() {}

  /*
   * Returns list of printers (as PrintService objects)
   */
  public PrintService[] getAll() {
    return PrinterJob.lookupPrintServices();
  }

  
  public PrintService findByName(String name)  throws NoSuchPrinterException {
    for (PrintService printService : getAll()) {
      if (printService.getName().equals(name)) {
        return printService;
      }
    }

    // couldn't find it...
    throw new NoSuchPrinterException("Unknown printer [" + name + "]");    
  }
}
