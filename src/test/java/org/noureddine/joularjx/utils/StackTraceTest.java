package org.noureddine.joularjx.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class StackTraceTest {

    @Test
    public void getStackTraceTest() {
        StackTraceElement[] stackTraceArray = Thread.currentThread().getStackTrace();

        StackTrace stackTrace = new StackTrace(stackTraceArray);

        assertEquals(stackTrace.getStackTrace(), Arrays.asList(stackTraceArray));
    }

    @Test
    public void setStackTraceTest() {
        StackTrace stackTrace = new StackTrace();
        StackTraceElement[] stackTraceArray = Thread.currentThread().getStackTrace();

        stackTrace.setStackTrace(stackTraceArray);

        assertEquals(stackTrace.getStackTrace(), Arrays.asList(stackTraceArray));
    }

    @Test
    public void equalsTest() {
        StackTraceElement[] stackTraceArray = Thread.currentThread().getStackTrace();

        StackTrace stackTrace = new StackTrace(stackTraceArray);

        assertTrue(stackTrace.equals(new StackTrace(stackTraceArray)));
        assertFalse(stackTrace.equals(new StackTrace()));
    }

    @Test
    public void toSringTest() {
        StackTraceElement e = new StackTraceElement("ClassA", "MethodA", "FileA", 20);
        StackTraceElement e1 = new StackTraceElement("ClassB", "MethodB", "FileB", 12);
        StackTraceElement e2 = new StackTraceElement("ClassC", "MethodC", "FileC", 59);

        StackTraceElement[] arr = {e, e1, e2};
        StackTrace stackTrace = new StackTrace(arr);

        String oracle = "ClassA.MethodA;ClassB.MethodB;ClassC.MethodC;";

        assertEquals(oracle, stackTrace.toString());
    }
    
}
