package au.com.sealink.printing.ticketprinter;

import au.com.sealink.printing.ticketprinter.exceptions.NoSuchPrinterException;
import java.awt.print.PrinterJob;
import javax.print.PrintService;


public class PrintServiceLocator {

    /*
     * Returns list of printers (as PrintService objects)
     */
    public PrintService[] getAll() {
        return PrinterJob.lookupPrintServices();
    }


    public PrintService findByName(String name) throws NoSuchPrinterException {
        for (PrintService printService : getAll()) {
            if (printService.getName().equals(name)) {
                return printService;
            }
        }

        // couldn't find it...
        throw new NoSuchPrinterException("Unknown printer [" + name + "]");
    }
}
