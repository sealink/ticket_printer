package au.com.sealink.printing.ticketprinter;

import java.util.EnumSet;

public class TicketElement {
    private int x = 0;
    private int y = 0;
    private Integer width;
    private Integer height;
    private String value = "";
    private int fontSize = 10;
    private Justification justification = Justification.LEFT;
    private Underline underline = Underline.None;
    private EnumSet<FontStyle> fontStyles = EnumSet.noneOf(FontStyle.class);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isImage() {
        return isImageUrl() || isImageBase64();
    }

    public boolean isImageUrl() {
        return this.value.startsWith("image:");
    }

    public boolean isImageBase64() {
        return this.value.startsWith("imageBase64:");
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isBold() {
        return fontStyles.contains(FontStyle.Bold);
    }

    public void setBold(boolean bold) {
        if (bold) {
            fontStyles.add(FontStyle.Bold);
        } else {
            fontStyles.remove(FontStyle.Bold);
        }
    }

    public boolean isItalic() {
        return fontStyles.contains(FontStyle.Italic);
    }

    public void setItalic(boolean italic) {
        if (italic) {
            fontStyles.add(FontStyle.Italic);
        } else {
            fontStyles.remove(FontStyle.Italic);
        }
    }

    public boolean isInverted() {
        return fontStyles.contains(FontStyle.Inverted);
    }

    public void setInverted(boolean isInverted) {
        if (isInverted) {
            fontStyles.add(FontStyle.Inverted);
        } else {
            fontStyles.remove(FontStyle.Inverted);
        }
    }

    public String getImageValue() {
        if (isImageUrl()) {
            return this.value.substring(6);
        } else {
            return this.value.substring(12);
        }
    }

    public Justification getJustification() {
        return justification;
    }

    public void setJustification(Justification justification) {
        this.justification = justification;
    }

    public Underline getUnderline() {
        return underline;
    }

    public void setUnderline(Underline underline) {
        this.underline = underline;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}