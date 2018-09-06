package au.com.sealink.printing.ticket_printer;

import java.awt.print.PageFormat;
import java.awt.print.Paper;

import au.com.sealink.printing.utils.NumberConverter;

public class TicketPageSettings {

  private double width; // = 87f;
  private double height; // = 57f;
  private double margin; // = 2f;
  // Not customisable at this stage (through refactor)
  private double xOffset = 1.3f;
  private double yOffset = 1.3f;
  private double printWidth;
  private double printHeight;

//  String baseUrl = "";
  public TicketPageSettings(double width, double height, double margin) {
    this.width = width;
    this.height = height;
    this.margin = margin;

    this.printWidth  = this.width  - (2 * Math.abs(this.xOffset));
    this.printHeight = this.height - (2 * Math.abs(this.yOffset));
  }

  // Returns a hard coded page format for the setup width, height
  // (it does not query the printer capabilities)
  public PageFormat getPageFormat() {
    PageFormat pf = new PageFormat();
    pf.setOrientation(PageFormat.PORTRAIT);
    pf.setPaper(this.getHardcodedPaper());
    return pf;
  }

  // Returns a hard coded 'paper', assuming the given width/height of ticket match the printer
  // (it does not query the printer capabilities)
  private Paper getHardcodedPaper() {
    Paper paper = new Paper();
    paper.setSize(NumberConverter.mm2finch(this.width), NumberConverter.mm2finch(this.height));
    paper.setImageableArea(
            NumberConverter.mm2finch(this.xOffset),
            NumberConverter.mm2finch(this.yOffset),
            NumberConverter.mm2finch(this.printWidth),
            NumberConverter.mm2finch(this.printHeight));
    return paper;
  }
}
