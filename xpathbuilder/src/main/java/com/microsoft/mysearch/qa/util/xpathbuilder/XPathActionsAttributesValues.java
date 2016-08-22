package com.microsoft.mysearch.qa.util.xpathbuilder;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.microsoft.mysearch.qa.util.xpathbuilder.enums.*;
import org.junit.Assert;

import java.util.LinkedList;

@Singleton
public class XPathActionsAttributesValues extends XPath {

    @Inject
    private Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> xPathTable;

    @Inject
    public XPathActionsAttributesValues(Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> xPathTable) {
        super(xPathTable);
        this.xPathTable = xPathTable;
    }

    public XPathActionsAttributesValues(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        super(action, attributes, values);
        this.xPathTable.put(action, attributes, values);
    }

    public XPathActionsAttributesValues(ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        super(action, attribute, values);
        this.xPathTable = XPathActionsAttributesValues.getXPathTable(action, new LinkedList<ATTRIBUTES>() {{
            add(attribute);
        }}, new LinkedList<XPathValues>() {{
            add(values);
        }});
    }

    public XPathActionsAttributesValues(ACTIONS action, ATTRIBUTES attribute, String value) {
        super(action, attribute, value);
        this.xPathTable = XPathActionsAttributesValues.getXPathTable(action, attribute, new XPathValues(value));
    }

    public String getXPath() {
        String xPath = "";

        for (Table.Cell<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> tableCell : this.xPathTable.cellSet()) {

            if (tableCell.getColumnKey() == null)
                Assert.assertTrue("attributesList is null", false);
            if (tableCell.getValue() == null)
                Assert.assertTrue("listOfListValues is null", false);

            for (ATTRIBUTES attribute : tableCell.getColumnKey()) {
                for (XPathValues values : tableCell.getValue()) {
                        xPath = xPath + XPathBuilder.getXPath(tableCell.getRowKey(), attribute, values);
                    }
                }
            }
        return xPath;
    }

    public Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getxPathTable(){
        return this.xPathTable;
    }

    public String getTableXPath(Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> xPathTable) {
        return new XPathActionsAttributesValues(xPathTable).getXPath();
    }

    public String getTableXPath(ACTIONS action, ATTRIBUTES attribute, String value) {
        return new XPathActionsAttributesValues(action, attribute, value).getXPath();
    }

    public String getTableXPath(ACTIONS action, ATTRIBUTES attribute, XPathValues value) {
        return new XPathActionsAttributesValues(action, attribute, value).getXPath();
    }

    public String getTableXPath(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        return new XPathActionsAttributesValues(action, attributes, values).getXPath();
    }

    public static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getXPathTable(ACTIONS action, ATTRIBUTES attribute, String value) {
        return XPathActionsAttributesValues.getXPathTable(action, attribute, new XPathValues(new LinkedList<String>() {{
            add(value);
        }}));
    }

    public static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getXPathTable(ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return XPathActionsAttributesValues.getXPathTable(action, new LinkedList<ATTRIBUTES>() {{
            add(attribute);
        }}, new LinkedList<XPathValues>() {{
            add(values);
        }});
    }

    public static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getXPathTable(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> xPathTable = HashBasedTable.create();
        xPathTable.put(action, attributes, values);
        return xPathTable;
    }

    public static String getXPathFromTable(ACTIONS action, ATTRIBUTES attribute, String value) {
        XPathActionsAttributesValues actionsAttributesValues = new XPathActionsAttributesValues(action, attribute, value);
        return actionsAttributesValues.getXPath();
    }

    public static String getXPathFromTable(ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        XPathActionsAttributesValues actionsAttributesValues = new XPathActionsAttributesValues(action, attribute, values);
        return actionsAttributesValues.getXPath();

    }

    public static String getXPathFromTable(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        XPathActionsAttributesValues actionsAttributesValues = new XPathActionsAttributesValues(action, attributes, values);
        return actionsAttributesValues.getXPath();
    }

}