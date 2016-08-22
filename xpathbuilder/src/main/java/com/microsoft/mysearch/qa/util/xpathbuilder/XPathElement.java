package com.microsoft.mysearch.qa.util.xpathbuilder;

import com.microsoft.mysearch.qa.util.xpathbuilder.enums.*;
import com.google.common.collect.LinkedListMultimap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class XPathElement {

    private static final Log log = LogFactory.getLog(XPathElement.class.getName());

    protected PREFIX slashes;
    protected ELEMENTS element;
    protected LinkedListMultimap<PREFIX, ELEMENTS> xPathElementsMap = LinkedListMultimap.create();

    public XPathElement() {
        this.xPathElementsMap = LinkedListMultimap.create();
    }

    public XPathElement(String prefix, String stringElement) {
        try {
            this.slashes = PREFIX.valueOf(prefix.toUpperCase().replace(" ", "_"));
            this.element = ELEMENTS.valueOf(stringElement.toUpperCase().replace(" ", "_"));
            this.xPathElementsMap.put(slashes, element);
        } catch (Exception x) {
            Assert.assertTrue("\n Exception caught : '" + x + "'\n It was caught during XPathElement initialization \n new XPathElement(String prefix = '" + prefix + "', String stringElement = '" + stringElement + "') \n ", false);
        }
    }

    public XPathElement(LinkedListMultimap<PREFIX, ELEMENTS> xPathElementsMap) {
        this.xPathElementsMap = xPathElementsMap;
    }

    public XPathElement(XPathElement element) {
        this.xPathElementsMap = element.getElementMap();
    }

    public XPathElement(ELEMENTS element) {
        this.slashes = PREFIX.DOUBLE_SLASH;
        this.element = element;
        this.xPathElementsMap.put(slashes, element);
    }

    public XPathElement(PREFIX slashes, ELEMENTS element) {
        this.slashes = slashes;
        this.element = element;
        this.xPathElementsMap.put(slashes, element);
    }

    public LinkedListMultimap<PREFIX, ELEMENTS> getElementMap() {
        return this.xPathElementsMap;
    }

    public XPathElement setElement(LinkedListMultimap<PREFIX, ELEMENTS> xPathElementsMap) {
        this.xPathElementsMap = xPathElementsMap;
        return this;
    }

    public XPathElement addElementMap(LinkedListMultimap<PREFIX, ELEMENTS> xPathElementsMap) {
        this.xPathElementsMap.putAll(xPathElementsMap);
        return this;
    }

    public XPathElement addElement(PREFIX prefix, ELEMENTS element) {
        xPathElementsMap.put(prefix, element);
        return this;
    }

    public List<Map.Entry<PREFIX, ELEMENTS>> entries() {
        return xPathElementsMap.entries();
    }

    public Map.Entry<PREFIX, ELEMENTS> getMapEntry(int i) {
        int a = 0;
        for (Map.Entry<PREFIX, ELEMENTS> oneMapEntry : xPathElementsMap.entries()) {

            this.slashes = oneMapEntry.getKey();
            this.element = oneMapEntry.getValue();

            if (a == i) {
                return oneMapEntry;
            }
            a++;
        }
        Assert.assertTrue("Your queried entry : '" + i + "' not found xPathElementsMap have : '" + xPathElementsMap.size() + "'", false);
        return null;
    }

    public String getXPath() {
        return this.slashes.get() + this.element.get();
    }

    public static String getXPath(PREFIX prefix, ELEMENTS element) {
        return new XPathElement(prefix, element).getXPath();
    }
}