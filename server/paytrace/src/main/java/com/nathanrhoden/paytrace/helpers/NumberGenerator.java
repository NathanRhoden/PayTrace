package com.nathanrhoden.paytrace.helpers;

public class NumberGenerator {

    static long current = 1;

    public static String generateNextReference() {
        return String.format("%010d", current++);
    }
}
