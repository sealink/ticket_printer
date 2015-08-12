package com.quicktravel.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberConverterTest {

  @Test
  public void testMm2finch() {
    assertEquals(NumberConverter.mm2finch(10), 28.34, 0.01);
  }

  @Test
  public void testObjectToInt() {
    int val = 1;
    assertEquals(NumberConverter.objectToInt(new Long(1)), val);
    assertEquals(NumberConverter.objectToInt(new Integer(1)), val);
    assertEquals(NumberConverter.objectToInt(new Double(1)), val);
    assertEquals(NumberConverter.objectToInt(new Float(1)), val);
    assertEquals(NumberConverter.objectToInt("1"), val);
  }

  @Test
  public void testObjectToDouble() {
    double val = 1;
    double epsilom = 0.1;
    assertEquals(NumberConverter.objectToDouble(new Long(1)), val, epsilom);
    assertEquals(NumberConverter.objectToDouble(new Integer(1)), val, epsilom);
    assertEquals(NumberConverter.objectToDouble(new Double(1)), val, epsilom);
    assertEquals(NumberConverter.objectToDouble(new Float(1)), val, epsilom);
    assertEquals(NumberConverter.objectToDouble("1"), val, epsilom);
  }

}
