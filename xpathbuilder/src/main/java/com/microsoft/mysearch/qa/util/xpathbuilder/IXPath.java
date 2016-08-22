package com.microsoft.mysearch.qa.util.xpathbuilder;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Table;
import com.google.inject.ImplementedBy;
import com.microsoft.mysearch.qa.util.xpathbuilder.enums.*;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.Map;

@ImplementedBy(XPath.class)
public interface IXPath {

    static ELEMENTS

            wi =                ELEMENTS.WI,
            input =             ELEMENTS.INPUT,
            div =               ELEMENTS.DIV,
            a =                 ELEMENTS.A,
            p =                 ELEMENTS.P,
            span =              ELEMENTS.SPAN,
            button =            ELEMENTS.BUTTON,
            select =            ELEMENTS.SELECT,
            textarea =          ELEMENTS.TEXTAREA,
            label =             ELEMENTS.LABEL,
            ul =                ELEMENTS.UL,
            li =                ELEMENTS.LI,
            h1 =                ELEMENTS.H1,
            h2 =                ELEMENTS.H2,
            h3 =                ELEMENTS.H3;

    static ATTRIBUTES
            ariaDisabled =      ATTRIBUTES.ARIA_DISABLED,
            dataType =          ATTRIBUTES.DATA_TYPE,
            id =                ATTRIBUTES.ID,
            em =                ATTRIBUTES.EM,
            href =              ATTRIBUTES.HREF,
            frag =              ATTRIBUTES.FRAG,
            class_att =         ATTRIBUTES.CLASS,
            dropdown =          ATTRIBUTES.DROPDOWN,
            text =              ATTRIBUTES.TEXT,
            checkbox =          ATTRIBUTES.CHECKBOX,
            role =              ATTRIBUTES.ROLE,
            datareactid =       ATTRIBUTES.DATA_REACTID,
            type =              ATTRIBUTES.TYPE,
            name =              ATTRIBUTES.NAME,
            title =             ATTRIBUTES.TITLE,
            style =             ATTRIBUTES.STYLE,
            disabled =          ATTRIBUTES.DISABLED,
            wicketpath =        ATTRIBUTES.WICKETPATH,
            dataPath =          ATTRIBUTES.DATA_PATH;

    static ACTION
            and =               ACTION.AND,
            not =               ACTION.NOT,
            or =                ACTION.OR;

    static ACTIONS

            contains =          ACTIONS.CONTAINS,
            equals =            ACTIONS.EQUALS,
            andEquals =         ACTIONS.AND_EQUALS,
            orEquals =          ACTIONS.OR_EQUALS,
            notContains =       ACTIONS.NOT_CONTAINS,
            notEquals =         ACTIONS.NOT_EQUALS,
            orContains =        ACTIONS.OR_CONTAINS,
            andContains =       ACTIONS.AND_CONTAINS;

    static PREFIX
            singleSlash =       PREFIX.SINGLE_SLASH,
            doubleSlash =       PREFIX.DOUBLE_SLASH;

    LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>>  xpathListMap = LinkedListMultimap.create();
    Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>>                                                         newXPathTable = HashBasedTable.create();

    static String getXPath(ELEMENTS element) {
        return new XPathElement(doubleSlash, element).getXPath();
    }

    static String getXPath(PREFIX prefix, ELEMENTS element) {
        return new XPathElement(prefix, element).getXPath();
    }

    static String getXPath(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        return new XPath(element, action, attribute, value).getXPath();
    }

    static String getXPath(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, LinkedList<String> value) {
        return new XPath(element, action, attribute, value).getXPath();
    }

    static String getXPath(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return new XPath(element, action, attribute, values).getXPath();
    }

    static String getXPath(PREFIX prefix, ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        return getXPath(prefix, element, action, attribute, new XPathValues(value));
    }

    static String getXPath(PREFIX prefix, ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, XPathValues value) {
        return new XPath(prefix, element, action, attribute, value).getXPath();
    }

    static String getXPath_DirectSibling(ELEMENTS element) {
        return new XPathElement(singleSlash, element).getXPath();
    }

    static String getXPath_DirectSibling(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        return getXPath_DirectSibling(element, action, attribute, new XPathValues(value));
    }

    static String getXPath_DirectSibling(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return new XPath(singleSlash, element, action, attribute, values).getXPath();
    }

    static String getXPath_DivEqualsDataPath(String dataPathValue) {
        return new XPath(doubleSlash, div, equals, dataPath, new XPathValues(dataPathValue)).getXPath();
    }

    /************************************ Div And Contains DataPath ************************************/
    static String getXPath_DivAndContainsDataPath(String dataPath) {
        return getXPath_DivAndContainsDataPath(new XPathValues(dataPath));
    }

    static String getXPath_DivAndContainsDataPath(String dataPath, String dataPath2) {
        return getXPath_DivAndContainsDataPath(new XPathValues(dataPath, dataPath2));
    }

    static String getXPath_DivAndContainsDataPath(String dataPath, String dataPath2, String dataPath3) {
        return getXPath_DivAndContainsDataPath(new XPathValues(dataPath, dataPath2, dataPath3));
    }

    static String getXPath_DivAndContainsDataPath(String dataPath, String dataPath2, String dataPath3, String dataPath4) {
        return getXPath_DivAndContainsDataPath(new XPathValues(dataPath, dataPath2, dataPath3, dataPath4));
    }

    static String getXPath_DivAndContainsDataPath(XPathValues xPathValues) {
        return new XPath(doubleSlash, div, andContains, dataPath, xPathValues).getXPath();
    }

    /************************************ Input Equals Name ************************************/
    static String getXPath_InputEqualsName(String name) {
        return getXPath_InputEqualsName(doubleSlash, name);
    }

    static String getXPath_InputEqualsName(PREFIX prefix, String value) {
        return new XPath(prefix, input, equals, name, value).getXPath();
    }

    /************************************ Div And Contains Wicketpath ************************************/
    static String getXPath_AndContainsWicketpath(PREFIX prefix, ELEMENTS element, String dataPath) {
        return getXPath_AndContainsWicketpath(prefix, element, new XPathValues(dataPath));
    }

    static String getXPath_AndContainsWicketpath(PREFIX prefix, ELEMENTS element, String dataPath, String dataPath2) {
        return getXPath_AndContainsWicketpath(prefix, element, new XPathValues(dataPath, dataPath2));
    }

    static String getXPath_AndContainsWicketpath(PREFIX prefix, ELEMENTS element, String dataPath, String dataPath2, String dataPath3) {
        return getXPath_AndContainsWicketpath(prefix, element, new XPathValues(dataPath, dataPath2, dataPath3));
    }

    static String getXPath_AndContainsWicketpath(PREFIX prefix, ELEMENTS element, String dataPath, String dataPath2, String dataPath3, String dataPath4) {
        return getXPath_AndContainsWicketpath(prefix, element, new XPathValues(dataPath, dataPath2, dataPath3, dataPath4));
    }

    static String getXPath_AndContainsWicketpath(PREFIX prefix, ELEMENTS element, XPathValues xPathValues) {
        return new XPath(prefix, element, andContains, wicketpath, xPathValues).getXPath();
    }/************************************ Div And Contains Wicketpath ************************************/


    static String getXPath_DivEqualsId(String idValue) {
        return new XPath(doubleSlash, div, equals, id, new XPathValues(idValue)).getXPath();
    }

    static String getXPath_DivEqualsClass(String classValue){
        return new XPath(doubleSlash, div, equals, class_att, new XPathValues(classValue)).getXPath();
    }

    static String getXPath_DivEqualsWicket(String wicketpathValue){
        return new XPath(doubleSlash, div, equals, wicketpath, wicketpathValue).getXPath();
    }

    /********************************** Containing Wicketpath **************************************/
    static String getXPath_ContainsWicketpath(PREFIX prefix, ELEMENTS element, String value) {
        return getXPath_ContainsWicketpath(prefix, element, new XPathValues(value));
    }

    static String getXPath_ContainsWicketpath(ELEMENTS element, String value) {
        return getXPath_ContainsWicketpath(doubleSlash, element, new XPathValues(value));
    }

    static String getXPath_ContainsWicketpath(PREFIX prefix, ELEMENTS element, String value, String value2) {
        return getXPath_ContainsWicketpath(prefix, element, new XPathValues(value, value2));
    }

    static String getXPath_ContainsWicketpath(PREFIX prefix, ELEMENTS element, String value, String value2, String value3) {
        return getXPath_ContainsWicketpath(prefix, element, new XPathValues(value, value2, value3));
    }

    static String getXPath_ContainsWicketpath(ELEMENTS element, LinkedList<String> values) {
        return getXPath_ContainsWicketpath(doubleSlash, element, new XPathValues(values));
    }

    static String getXPath_ContainsWicketpath(PREFIX prefix, ELEMENTS element, XPathValues xPathValues){
        return getXPath(prefix, element, contains, wicketpath, xPathValues);
    }/********************************** Containing Wicketpath **************************************/

    static String getXPath_DirectSpanEqualsText(String value) {
        return getXPath(singleSlash, span, equals, text, value);
    }

    static String getXPath_SpanEqualsText(String value) {
        return getXPath(doubleSlash, span, equals, text, value);
    }

    static String getXPath_DirectAButtonContainsWicketpath(String value) {
        return getXPath(singleSlash, a, contains, wicketpath, value);
    }

    static String getXPath_DirectAButtonContainsOrContainsWicketpath(String value, String value2) {
        return getXPath_DirectAButtonContainsOrContainsWicketpath(new XPathValues(value, value2));
    }

    static String getXPath_DirectAButtonContainsOrContainsWicketpath(XPathValues xPathValues) {
        return getXPath(singleSlash, a, orContains, wicketpath, xPathValues);
    }

    /************************************  Direct A Button And Contains Wicketpath ************************************/
    static String getXPath_DirectAButtonAndContainsWicketpath(String value){
        return getXPath_DirectAButtonAndContainsWicketpath(new XPathValues(value));
    }

    static String getXPath_DirectAButtonAndContainsWicketpath(String value, String value2){
        return getXPath_DirectAButtonAndContainsWicketpath(new XPathValues(value, value2));
    }

    static String getXPath_DirectAButtonAndContainsWicketpath(String value, String value2, String value3){
        return getXPath_DirectAButtonAndContainsWicketpath(new XPathValues(value, value2, value3));
    }
    // Those are just different kinds of same shortcuts for getXPaht callings .... to save your time :) UI automation never ever again produces buggy xpaths.... just if you are wrongly creating newer ever again by typo.... :)W
    static String getXPath_DirectAButtonAndContainsWicketpath(XPathValues xPathValues){
        return getXPath(singleSlash, a, andContains, wicketpath, xPathValues);
    }/************************************  Direct A Button And Contains Wicketpath ************************************/

    static String getXPath_HasADescendant(String xpath){
        return "[" + xpath + "]";
    }

    static String getXPath_HasADescendant(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, String value) {
        return getXPath_HasADescendant(getXPath(element, action, attribute, value));
    }

    /****************************** Has A Descendant Span Text ******************************/
    static String getXPath_HasADescendantSpanText(ACTIONS action, String value) {
        return getXPath_HasADescendantSpanText(action, new XPathValues(value));
    }

    static String getXPath_HasADescendantSpanText(ACTIONS action, String value, String value2) {
        return getXPath_HasADescendantSpanText(action, new XPathValues(value, value2));
    }

    static String getXPath_HasADescendantSpanText(ACTIONS action, String value, String value2, String value3) {
        return getXPath_HasADescendantSpanText(action, new XPathValues(value, value2, value3));
    }

    static String getXPath_HasADescendantSpanText(ACTIONS action, XPathValues xPathValues) {
        return "[" + getXPath(span, action, text, xPathValues) + "]";
    }/****************************** Has A Descendant Span Text ******************************/

    static String getXPath_HasADescendantSpanEqualsText(String value) {
        return "[" + getXPath(span, equals, text, value) + "]";
    }

    static String getXPath_HasADescendantSpanContainsText(String value) {
        return "[" + getXPath(span, contains, text, value) + "]";
    }

    static String getXPath_HasADescendantLabelEqualsText(String value) {
        return "[" + getXPath(ELEMENTS.LABEL, equals, text, value) + "]";
    }

    static String getXPath_HasADescendantLabelContainsText(String value) {
        return "[" + getXPath(ELEMENTS.LABEL, contains, text, value) + "]";
    }

    static String getXPath_HasADescendant(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, LinkedList<String> values) {
        return "[" + getXPath(element, action, attribute, values) + "]";
    }

    static String getXPath_HasADescendant(ELEMENTS element, ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return "[" + getXPath(element, action, attribute, values) + "]";
    }

    static String getXPath_HasADescendant(LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> xpathListMap) {
        return "[" + getXPath(xpathListMap) + "]";
    }

    static XPathActionsAttributesValues getActionsAttributesValues(ACTIONS action, ATTRIBUTES attribute, String value) {
        return new XPathActionsAttributesValues(action, attribute, value);
    }

    static XPathActionsAttributesValues getActionsAttributesValues(ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return new XPathActionsAttributesValues(action, attribute, values);
    }

    static XPathActionsAttributesValues getActionsAttributesValues(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        return new XPathActionsAttributesValues(action, attributes, values);
    }

    static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getActionsAttributesValuesTable(ACTIONS action, ATTRIBUTES attribute, String value) {
        return new XPathActionsAttributesValues(action, attribute, value).getxPathTable();
    }

    static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getActionsAttributesValuesTable(ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return new XPathActionsAttributesValues(action, attribute, values).getxPathTable();
    }

    static Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> getActionsAttributesValuesTable(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        return new XPathActionsAttributesValues(action, attributes, values).getxPathTable();
    }

    static String getXPath(ACTIONS action, ATTRIBUTES attribute, String value) {
        return new XPathActionsAttributesValues(action, attribute, value).getXPath();
    }

    static String getXPath(ACTIONS action, ATTRIBUTES attribute, XPathValues values) {
        return new XPathActionsAttributesValues(action, attribute, values).getXPath();
    }

    static String getXPath(ACTIONS action, LinkedList<ATTRIBUTES> attributes, LinkedList<XPathValues> values) {
        return new XPathActionsAttributesValues(action, attributes, values).getXPath();
    }

    static String getXPath(Table<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> xPathTable) {
        String xPath = "";
        for (Table.Cell<ACTIONS, LinkedList<ATTRIBUTES>, LinkedList<XPathValues>> tableCell : xPathTable.cellSet()) {

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

    static String getXPath(LinkedListMultimap<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> xpathListMap) {
        String xpath = "";
        for (Map.Entry<LinkedListMultimap<XPathElement, LinkedList<ACTIONS>>, LinkedListMultimap<ATTRIBUTES, XPathValues>> mapEntry : xpathListMap.entries()) {
            for (Map.Entry<XPathElement, LinkedList<ACTIONS>> elementActionsMapEntry : mapEntry.getKey().entries()) {
                for (Map.Entry<PREFIX, ELEMENTS> elementEntry : elementActionsMapEntry.getKey().entries()) {
                    /** Adding into Xpath '// + element' or '/ + element' */
                    xpath = xpath + XPathBuilder.getElementXpath(elementEntry.getKey(), elementEntry.getValue());
                    /** Adding into Xpath '// + element' or '/ + element' */
                    for (ACTIONS action : elementActionsMapEntry.getValue()) {
                        for (Map.Entry<ATTRIBUTES, XPathValues> attributesValuesMapEntry : mapEntry.getValue().entries()) {
                            /** Adding into Xpath based on action [contains|equals etc...] an [@attribute='value']  */
                            xpath = xpath + XPathBuilder.getXPath(action, attributesValuesMapEntry.getKey(), attributesValuesMapEntry.getValue());
                            /** Adding into Xpath based on action [contains|equals etc...] an [@attribute='value']  */
                        }
                    }
                }
            }
        }
        return xpath;
    }
}