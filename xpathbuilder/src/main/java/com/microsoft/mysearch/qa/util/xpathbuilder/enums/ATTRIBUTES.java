package com.microsoft.mysearch.qa.util.xpathbuilder.enums;

import java.util.Collections;
import java.util.LinkedList;

public enum ATTRIBUTES {

    ID("id"),
    ARIA_DISABLED("aria-disabled"),
    HREF("href"),
    EM("em"),
    FRAG("frag"),
    CLASS("class"),
    ROLE("role"),
    DATA_REACTID("data-reactid"),
    DROPDOWN("dropdown"),
    TITLE("title"),
    TYPE("type"),
    NAME("name"),
    SELECTED("selected"),
    DISABLED("disabled"),
    STYLE("style"),
    WICKETPATH("wicketpath"),
    DATA_PATH("data-path"),
    DATA_TYPE("data-type"),
    TEXT("text()"),
    CHECKBOX("checkbox"),
    ARIA_LABEL("aria-label"),
    DATA_YTRACK("data-ytrack"),
    ANY(".");

    private String attribute;

    ATTRIBUTES(String attribute) {
        this.attribute = attribute;
    }

    public String get() {
        return attribute;
    }

    private static String transformationOfStringToEnumName(String text) {
        return text.toUpperCase().replace(" ", "_").replace("-", "_");
    }

    public static ATTRIBUTES getAttribute(String attribute) {
        return ATTRIBUTES.valueOf(ATTRIBUTES.transformationOfStringToEnumName(attribute));
    }

    public static LinkedList<ATTRIBUTES> getValues() {
        LinkedList<ATTRIBUTES> toReturn = new LinkedList<>();
        Collections.addAll(toReturn, ATTRIBUTES.values());
        return toReturn;
    }
}