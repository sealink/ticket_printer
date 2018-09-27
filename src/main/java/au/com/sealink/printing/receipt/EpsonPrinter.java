package au.com.sealink.printing.receipt;

import au.com.sealink.printing.receipt.*;
import au.com.sealink.printing.ticket_printer.Justification;
import au.com.sealink.printing.ticket_printer.Underline;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

public class EpsonPrinter implements IPrinter, AutoCloseable {
    // Printer hardware
    private static final byte[] HW_INIT = {0x1b,0x40}; // Clear data in buffer and reset modes

    // Feed
    private static final byte[] FEED_LINES = {0x1B, 0x64}; //Feed Lines

    // Feed control sequences
    private static final byte[] CTL_LF        = {0x0a};          // Print and line feed

    // Line Spacing
    private static final byte[] LINE_SPACE_24 = {0x1b,0x33,24}; // Set the line spacing at 24
    private static final byte[] LINE_SPACE_30 = {0x1b,0x33,30}; // Set the line spacing at 30

    //Image
    private static final byte[] SELECT_BIT_IMAGE_MODE = {0x1B, 0x2A, 33};

    //Colour
    private static final byte [] COLOUR_1 = {0x1d,0x72,0x00}; // Color 1
    private static final byte [] COLOUR_2 = {0x1d,0x72,0x01}; // Color 2

    // Paper
    private static final byte[] PAPER_FULL_CUT = {0x1d,0x56,0x00}; // Full cut paper
    private static final byte[] PAPER_PART_CUT = {0x1d,0x56,0x01}; // Partial cut paper

    // Text format
    private static final byte[] TXT_NORMAL      = {0x1b,0x21,0x00}; // Normal text
    private static final byte[] TXT_2HEIGHT     = {0x1b,0x21,0x10}; // Double height text
    private static final byte[] TXT_2WIDTH      = {0x1b,0x21,0x20}; // Double width text
    private static final byte[] TXT_SET_MODE    = {0x1b,0x21};      //Generic mode
    private static final byte[] TXT_UNDERLINE_OFF  = {0x1b,0x2d,0x00}; // Underline font OFF
    private static final byte[] TXT_UNDERLINE_ON   = {0x1b,0x2d,0x01}; // Underline font 1-dot ON
    private static final byte[] TXT_UNDERLINE2_ON  = {0x1b,0x2d,0x02}; // Underline font 2-dot ON
    private static final byte[] TXT_BOLD_OFF    = {0x1b,0x45,0x00}; // Bold font OFF
    private static final byte[] TXT_BOLD_ON     = {0x1b,0x45,0x01}; // Bold font ON
    private static final byte[] TXT_FONT_A      = {0x1b,0x4d,0x48}; // Font type A
    private static final byte[] TXT_FONT_B      = {0x1b,0x4d,0x01}; // Font type B
    private static final byte[] TXT_FONT_C      = {0x1b,0x4d,0x02}; // Font type C
    private static final byte[] TXT_ALIGN_LT    = {0x1b,0x61,0x00}; // Left justification
    private static final byte[] TXT_ALIGN_CT    = {0x1b,0x61,0x01}; // Centering
    private static final byte[] TXT_ALIGN_RT    = {0x1b,0x61,0x02}; // Right justification

    private OutputStream stream;

    public EpsonPrinter(OutputStream stream) {
        this.stream = stream;
    }

    @Override
    public OutputStream getConnector() {
        return this.stream;
    }

    @Override
    public IPrinter initialise() throws IOException {
        getConnector().write(HW_INIT);
        return this;
    }

    @Override
    public void close() throws IOException {
        getConnector().close();
    }

    @Override
    public IPrinter cut(CutMode mode) throws IOException {
        switch(mode) {
            case PARTIAL:
                getConnector().write(PAPER_PART_CUT);
                break;
            case FULL:
                getConnector().write(PAPER_FULL_CUT);
                break;
        }
        return this;
    }

    @Override
    public IPrinter feed(int numberOfLines) throws IOException {
        getConnector().write(FEED_LINES);
        getConnector().write(numberOfLines);
        return this;
    }

    @Override
    public IPrinter feed() throws IOException {
        return feed(1);
    }

    @Override
    public IPrinter text(String text) throws IOException {
        getConnector().write(text.getBytes());
        return this;
    }

    @Override
    public IPrinter setFont(Font font) throws IOException {
        switch (font) {
            case FONT_A:
                getConnector().write(TXT_FONT_A);
                break;
            case FONT_B:
                getConnector().write(TXT_FONT_B);
                break;
            case FONT_C:
                getConnector().write(TXT_FONT_C);
                break;
        }
        return this;
    }

    @Override
    public IPrinter setMode(PrintMode mode) throws IOException {
        getConnector().write(TXT_SET_MODE);
        getConnector().write(mode.getValue());
        return this;
    }

    @Override
    public IPrinter setUnderline(Underline mode) throws IOException {
        switch (mode) {
            case None:
                getConnector().write(TXT_UNDERLINE_OFF);
                break;
            case Single:
                getConnector().write(TXT_UNDERLINE_ON);
                break;
            case Double:
                getConnector().write(TXT_UNDERLINE2_ON);
                break;
        }
        return this;
    }

    @Override
    public IPrinter setDoubleWidth(Boolean isEnabled) throws IOException {
        if (isEnabled) {
            getConnector().write(TXT_2WIDTH);
        } else {
            getConnector().write(TXT_NORMAL);
        }
        return this;
    }

    @Override
    public IPrinter setDoubleHeight(Boolean isEnabled) throws IOException {
        if (isEnabled) {
            getConnector().write(TXT_2HEIGHT);
        } else {
            getConnector().write(TXT_NORMAL);
        }
        return this;
    }

    @Override
    public IPrinter setJustification(Justification justification) throws IOException {
        switch (justification) {
            case LEFT:
                getConnector().write(TXT_ALIGN_LT);
                break;
            case CENTRE:
                getConnector().write(TXT_ALIGN_CT);
                break;
            case RIGHT:
                getConnector().write(TXT_ALIGN_RT);
                break;
        }
        return this;
    }

    @Override
    public IPrinter setColour(Colour colour) throws IOException {
        switch (colour) {
            case COLOUR_1:
                getConnector().write(COLOUR_1);
                break;
            case COLOUR_2:
                getConnector().write(COLOUR_2);
                break;
        }
        return this;
    }

    @Override
    public IPrinter setEmphasis(Boolean isEnabled) throws IOException {
        if (isEnabled) {
            getConnector().write(TXT_BOLD_ON);
        } else {
            getConnector().write(TXT_BOLD_OFF);
        }
        return this;
    }

    @Override
    public IPrinter printImage(BufferedImage image) throws IOException {
        if (image != null) {
            Image img = new Image();
            int[][] pixels = img.getPixelsSlow(image);
            for (int y = 0; y < pixels.length; y += 24) {
                getConnector().write(LINE_SPACE_24);
                getConnector().write(SELECT_BIT_IMAGE_MODE);
                getConnector().write(new byte[]{(byte) (0x00ff & pixels[y].length), (byte) ((0xff00 & pixels[y].length) >> 8)});
                for (int x = 0; x < pixels[y].length; x++) {
                    getConnector().write(img.recollectSlice(y, x, pixels));
                }
                getConnector().write(CTL_LF);
            }
            getConnector().write(CTL_LF);
            getConnector().write(LINE_SPACE_30);
        }
        return this;
    }
}
