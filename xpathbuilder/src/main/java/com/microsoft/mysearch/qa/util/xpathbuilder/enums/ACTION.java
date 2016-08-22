package com.microsoft.mysearch.qa.util.xpathbuilder.enums;

import java.util.Collections;
import java.util.LinkedList;

public enum ACTION {

    AND(PREFIX.AND.get()),
    OR(PREFIX.OR.get()),
    CONTAINS("contains"),
    EQUALS("equals"),
    SIBLING(PREFIX.SIBLING.get()),
    DESCENDANT(PREFIX.DESCENDANT.get()),
    CHILD(PREFIX.CHILD.get()),
    CHECK("check"),
    UNCHECK(PREFIX.UN.get() + ACTION.CHECK.get()),
    HIDE("hide"),
    SHOW("show"),
    UNHIDE(PREFIX.UN.get() + ACTION.HIDE.get()),
    NOT("not");

    private String action;

    ACTION(String action) {
        this.action = action;
    }

    public String get() {
        return action;
    }

    private static String transformationOfStringToEnumName(String text) {
        return text.toUpperCase().replace(" ", "_");
    }

    public static ACTION getAction(String filterName) {
        return ACTION.valueOf(ACTION.transformationOfStringToEnumName(filterName));
    }

    public static LinkedList<ACTION> getValues() {
        LinkedList<ACTION> toReturn = new LinkedList<>();
        Collections.addAll(toReturn, ACTION.values());
        return toReturn;
    }
}
