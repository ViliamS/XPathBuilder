package com.microsoft.mysearch.qa.util.xpathbuilder.enums;

import java.util.Collections;
import java.util.LinkedList;

public enum PREFIX {

    SINGLE_SLASH ("/"),
    DOUBLE_SLASH ("//"),
    AND ("and"),
    NOT ("not"),
    OR  ("or"),
    FOLLOWING("/following-"),
    SIBLING ("sibling::"),
    DESCENDANT("descendant::"),
    CHILD("child::"),
    EMPTY(""),
    UN("un");

    private String prefix;

    PREFIX(String prefix){
        this.prefix = prefix;
    }

    public String get(){
        return prefix;
    }

    private static String transformationOfStringToEnumName(String text) {
        return text.toUpperCase().replace(" ", "_");
    }

    public static PREFIX getPrefix(String prefix) {
        return PREFIX.valueOf(PREFIX.transformationOfStringToEnumName(prefix));
    }

    public static LinkedList<PREFIX> getValues(){
        LinkedList<PREFIX> toReturn = new LinkedList<>();
        Collections.addAll(toReturn, PREFIX.values());
        return toReturn;
    }
}