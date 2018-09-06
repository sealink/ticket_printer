package au.com.sealink.printing.utils;

public class NumberConverter {

  /**
   * Finch is a fractional inch, e.g. 1/72nd of an Inch This is useful when
   * dealing with 72 dots per inch resolutions.
   *
   * @param mm The amount of mm to convert to finches
   * @return The finch equivalent of mm
   */
  public static double mm2finch(double mm) {
    return mm * 72 / 25.4;
  }

}
