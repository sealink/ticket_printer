package au.com.sealink.printing.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberConverterTest {

  @Test
  public void testMm2finch() {
    assertEquals(NumberConverter.mm2finch(10), 28.34, 0.01);
  }
}
