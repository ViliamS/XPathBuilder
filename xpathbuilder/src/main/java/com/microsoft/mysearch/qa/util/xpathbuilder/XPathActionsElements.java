package com.microsoft.mysearch.qa.util.xpathbuilder;

import com.microsoft.mysearch.qa.util.xpathbuilder.enums.*;
import com.google.common.collect.LinkedListMultimap;

import java.util.Collections;
import java.util.LinkedList;

public class XPathActionsElements extends XPathElement {

    protected ACTIONS action;
    LinkedList<ACTIONS> actions;
    protected XPathElement xPathElement;

    protected LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> xPathElementActionsMap;
//
//    public XPathActionsElements(){
//        super();
//        this.xPathElement = new XPathElement();
//        this.xPathElementActionsMap = LinkedListMultimap.create();
//        this.actions = new LinkedList<ACTIONS>(){{add(action);}};
//    }

    public XPathActionsElements(XPathElement xPathElement){
        super(xPathElement);
        this.xPathElement = xPathElement;
        this.xPathElementActionsMap = LinkedListMultimap.create();
    }

    public XPathActionsElements(XPathActionsElements xPathActionsElements){
        this.xPathElementActionsMap = xPathActionsElements.getElementActionsMap();
    }

    public XPathActionsElements(LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> elementActionsMap) {
        this.xPathElementActionsMap = elementActionsMap;
    }

    public XPathActionsElements(XPathElement element, ACTIONS action) {
        super();
        if(element!=null) {
            this.xPathElement = element;
            this.action = action;
            this.actions = new LinkedList<ACTIONS>() {{
                add(action);
            }};
            this.xPathElementActionsMap = LinkedListMultimap.create();
            this.xPathElementActionsMap.put(element, actions);
        }
    }

//    public XPathActionsElements(LinkedListMultimap<PREFIX, ELEMENTS> slashes, PREFIX prefix, ELEMENTS element, ACTIONS action){
//        this.action = action;
////        for(Map.Entry mapEntry : slashes.entries()) {
//
//
//
//        this.xPathElement = new XPathElement(slashes);
//        xPathElementActionsMap.put(new XPathElement(element).getElementMap(), action )
//
//
//
//        new XPathElement(slashes).getElementMap();
//        }
//        xPathElementActionsMap.put(, new LinkedList<ACTIONS>(){{add(action);}});
//
//
//    }

    public XPathActionsElements(PREFIX slashes, ELEMENTS element, LinkedList<ACTIONS> actions) {
        super(slashes, element);
        LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> elementActionsMap = LinkedListMultimap.create();
        elementActionsMap.put(new XPathElement(slashes, element), actions);
        this.xPathElementActionsMap = elementActionsMap;
    }

    public static XPathActionsElements addEntry(XPathActionsElements xPathActionsElements, XPathElement xPathElement, LinkedList<ACTIONS> actions){
        return new XPathActionsElements(xPathActionsElements).addEntry(xPathElement, actions);
    }

    public static XPathActionsElements addEntry(XPathActionsElements xPathActionsElements, XPathElement xPathElement, ACTIONS action){
        return new XPathActionsElements(xPathActionsElements).addEntry(xPathElement, action);
    }

    public XPathActionsElements addEntry(XPathElement xPathElement, LinkedList<ACTIONS> actions){
        this.xPathElementActionsMap.put(xPathElement, actions);
        return this;
    }

    public XPathActionsElements addEntry(XPathElement xPathElement, ACTIONS action){
        this.xPathElementActionsMap.put(xPathElement, new LinkedList<ACTIONS>(){{add(action);}});
        return this;
    }

    public LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> getElementActionsMap() {
        return this.xPathElementActionsMap;
    }

    public LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> setElementActionsListsMap(LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> elementActionsListsMap) {
        return setElementActions(elementActionsListsMap).getElementActionsMap();
    }

    //get element by action
    public XPathElement getElement(ACTIONS action) {

//        LinkedListMultimap<ACTIONS, XPathElement> multimap = LinkedListMultimap.create();
//        multimap.asMap()


//        for (Map.Entry<XPathElement, LinkedList<ACTIONS>> mapEntry : this.getElementActionsMap().entries()){


//            new LinkedList<>();


//            ACTIONS actions
//
//            Collections.addAll(actions, mapEntry.getValue());
//
//            XPathElement element = Collections.addAll(element, mapEntry.getKey());
//
//            mapEntry.getKey();
//
//
//            for (ACTIONS actionValueKey : mapEntry.getValue()) {


//                multimap.put(actions, elements);

//
//            }
//        }
//

//        multimap.containsValue();
//        return
        return null;
    }

    public static LinkedList<ACTIONS> getValues() {
        LinkedList<ACTIONS> toReturn = new LinkedList<>();
        Collections.addAll(toReturn, ACTIONS.values());
        return toReturn;
    }

    public XPathActionsElements setElementActions(LinkedListMultimap<XPathElement, LinkedList<ACTIONS>> elementActionsMap) {
        this.xPathElementActionsMap = elementActionsMap;
        return this;
    }

    public XPathActionsElements addActionForElement(PREFIX slash, ELEMENTS element, LinkedList<ACTIONS> action) {
        this.xPathElementActionsMap.put(new XPathElement(slash, element), action);
        return this;
    }


}