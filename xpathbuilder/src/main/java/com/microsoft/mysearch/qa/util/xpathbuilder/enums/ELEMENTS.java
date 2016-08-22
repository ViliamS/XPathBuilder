package com.microsoft.mysearch.qa.util.xpathbuilder.enums;

import java.util.Collections;
import java.util.LinkedList;

public enum ELEMENTS {

    INPUT("input"),
    DIV("div"),
    A("a"),
    I("i"),
    WI("wi"),
    P("p"),
    H1("h1"),
    H2("h2"),
    H3("h3"),
    SPAN("span"),
    FONT("font"),
    OPTION("option"),
    BUTTON("button"),
    DROPDOWN("dropdown"),
    SELECT("select"),
    TEXTAREA("textarea"),
    TD("td"),
    UL("ul"),
    EM("em"),
    LI("li"),
    LABEL("label"),
    IFRAME("iframe");

    private String element;

    ELEMENTS(String element) {
        this.element = element;
    }

    public String get() {
        return element;
    }

    public static ELEMENTS getElementValue(String element) {
        return ELEMENTS.valueOf(element);
    }

    private static String transformationOfStringToEnumName(String text) {
        return text.toUpperCase().replace(" ", "_");
    }

    public static ELEMENTS getElement(String element) {
        return ELEMENTS.valueOf(ELEMENTS.transformationOfStringToEnumName(element));
    }

    public static LinkedList<ELEMENTS> getValues() {
        LinkedList<ELEMENTS> toReturn = new LinkedList<>();
        Collections.addAll(toReturn, ELEMENTS.values());
        return toReturn;
    }
}