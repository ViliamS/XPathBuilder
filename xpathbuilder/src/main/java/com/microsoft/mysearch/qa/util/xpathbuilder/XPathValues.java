package com.microsoft.mysearch.qa.util.xpathbuilder;

import java.util.Collections;
import java.util.LinkedList;

public class XPathValues extends XPath {

    protected LinkedList<String> xpathValuesList;

//    public XPathValues() {
//        this.xpathValuesList = new LinkedList<>();
//    }

    public XPathValues(LinkedList<String> xpathValuesList) {
        this.xpathValuesList = xpathValuesList;
    }

    public XPathValues(String value) {
        this.xpathValuesList = new LinkedList<String>() {{
            add(value);
        }};
    }

    public XPathValues(String value1, String value2) {
        this.xpathValuesList = new LinkedList<String>() {{
            add(value1);
            add(value2);
        }};
    }

    public int size(){
        return this.xpathValuesList.size();
    }

    public XPathValues(String value1, String value2, String value3) {
        this.xpathValuesList = new LinkedList<String>() {{
            add(value1);
            add(value2);
            add(value3);
        }};
    }

    public XPathValues(String value1, String value2, String value3, String value4) {
        this.xpathValuesList = new LinkedList<String>() {{
            add(value1);
            add(value2);
            add(value3);
            add(value4);
        }};
    }

    public XPathValues(String[] values) {
        this.xpathValuesList = new LinkedList<>();
        Collections.addAll(this.xpathValuesList, values);
    }

    public LinkedList<String> getXpathValuesList() {
        return this.xpathValuesList;
    }

    public XPathValues setXPathValues(LinkedList<String> xpathValuesList) {
        this.xpathValuesList.addAll(xpathValuesList);
        return this;
    }

    public XPathValues setXPathValues(String xpathValue) {
        this.xpathValuesList.add(xpathValue);
        return this;
    }

    public static XPathValues setXPathValues(String[] xpathValues) {
        return new XPathValues(xpathValues);
    }

    public static XPathValues setXPathValues(String xpathValue, String anotherXpathValue) {
        return new XPathValues(xpathValue, anotherXpathValue);
    }

    public static XPathValues setXPathValues(String xpathValue, String anotherXpathValue, String nextXPathValue) {
        return new XPathValues(xpathValue, anotherXpathValue, nextXPathValue);
    }

    public static LinkedList<String> getXPathValues(String value, String anotherValue, String andAnotherValue) {
        return new XPathValues(value, anotherValue, andAnotherValue).getXpathValuesList();
    }

    public static LinkedList<String> getXPathValues(String value, String anotherValue) {
        return new XPathValues(value, anotherValue).getXpathValuesList();
    }

    public static LinkedList<String> getXPathValues(String value) {
        return new XPathValues(value).getXpathValuesList();
    }

    public static LinkedList<String> getXPathValues(String[] values) {
        return new XPathValues(values).getXpathValuesList();
    }
}