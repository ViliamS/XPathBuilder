package com.microsoft.mysearch.qa.util.xpathbuilder.enums;

import java.util.Collections;
import java.util.LinkedList;

public enum ACTIONS {

    CONTAINS                (PREFIX.EMPTY,      ACTION.CONTAINS),

    AND_CONTAINS            (PREFIX.AND,        ACTION.CONTAINS),
    OR_CONTAINS             (PREFIX.OR,         ACTION.CONTAINS),
    NOT_CONTAINS            (PREFIX.NOT,        ACTION.CONTAINS),

    EQUALS                  (PREFIX.EMPTY,      ACTION.EQUALS),

    AND_EQUALS              (PREFIX.AND,        ACTION.EQUALS),  /** todo XPath action equals and equals is in current implementation nonsense as it will be created for the same ATTRIBUTE .... implementation need to be extended if needed... which is exceptional and I dont think it will be ever really needed.  */
    OR_EQUALS               (PREFIX.OR,         ACTION.EQUALS),
    NOT_EQUALS              (PREFIX.NOT,        ACTION.EQUALS),

    FOLLOWING_DESCENDANT    (PREFIX.FOLLOWING,  ACTION.DESCENDANT),
    FOLLOWING_CHILD         (PREFIX.FOLLOWING,  ACTION.CHILD),
    FOLLOWING_SIBLING       (PREFIX.FOLLOWING,  ACTION.SIBLING);


    private PREFIX preAction;
    private ACTION postAction;

    ACTIONS(PREFIX preAction, ACTION postAction){
        this.preAction = preAction;
        this.postAction = postAction;
    }

    public String get(){
        return preAction.get() + postAction.get();
    }

    public PREFIX getPreAction(){
        return preAction;
    }

    public ACTION getAction(){
        return postAction;
    }

    private static String transformationOfStringToEnumName(String text) {
        return text.toUpperCase().replace(" ", "_");
    }

    public static ACTIONS getActions(String filterName) {
        return ACTIONS.valueOf(ACTIONS.transformationOfStringToEnumName(filterName));
    }

    public static LinkedList<ACTIONS> getValues(){
        LinkedList<ACTIONS> toReturn = new LinkedList<>();
        Collections.addAll(toReturn, ACTIONS.values());
        return toReturn;
    }
}