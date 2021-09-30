package com.application.myapp.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatternUtilsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isConsistOfNumber() {
        String inputTest = "1234556";
        assertTrue(PatternUtils.isConsistOfNumber(inputTest));
    }

    @Test
    public void isConsistOfNumberWithString() {
        String inputTest = "test";
        assertFalse(PatternUtils.isConsistOfNumber(inputTest));
    }

    @Test
    public void isConsistOfNumberWithAlphanumeric() {
        String inputTest = "test12345";
        assertTrue(PatternUtils.isConsistOfNumber(inputTest));
    }

    @Test(expected = NullPointerException.class)
    public void isConsistOfNumberWithNull() throws NullPointerException{
        String inputTest = null;
        PatternUtils.isConsistOfNumber(inputTest);
    }
}