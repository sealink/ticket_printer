package au.com.sealink.printing.ticket_printer;

public class TicketElement {

  private int x = 0;
  private int y = 0;
  private String value = "";
  private int fontSize = 10;
  private boolean bold = false;
  private boolean italic = false;

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
    return bold;
  }

  public void setBold(boolean bold) {
    this.bold = bold;
  }

  public boolean isItalic() {
    return italic;
  }

  public void setItalic(boolean italic) {
    this.italic = italic;
  }

  public String getImageValue() {
    if (isImageUrl()) {
      return this.value.substring(6);
    } else {
      return this.value.substring(12);
    }
  }

}