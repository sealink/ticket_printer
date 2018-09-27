package au.com.sealink.printing.receipt;

import au.com.sealink.printing.ticket_printer.Justification;
import au.com.sealink.printing.ticket_printer.Underline;

import java.io.IOException;
import java.io.OutputStream;

public interface IPrinter {
    OutputStream getConnector();
    IPrinter initialise() throws IOException;
    void close() throws IOException;
    IPrinter cut(CutMode mode) throws IOException;
    IPrinter feed(int numberOfLines) throws IOException;
    IPrinter feed() throws IOException;
    IPrinter text(String text) throws IOException;
    IPrinter setFont(Font font) throws IOException;
    IPrinter setMode(PrintMode mode) throws IOException;
    IPrinter setUnderline(Underline mode) throws IOException;
    IPrinter setDoubleWidth(Boolean isEnabled) throws IOException;
    IPrinter setDoubleHeight(Boolean isEnabled) throws IOException;
    IPrinter setJustification(Justification justification) throws IOException;
    IPrinter setColour(Colour colour) throws IOException;
    IPrinter setEmphasis(Boolean isEnabled) throws IOException;
}
