package com.star.people.enums;

/**
 * Created by zuhai.jiang on 2015/12/23.
 */
public enum ArticleStatus {
    DELETED(0)
    ,DISABLED(1)
    ,AVAILABLE(2);

    private int value;

    ArticleStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static ArticleStatus valueOf(int type){
        return ArticleStatus.values()[type-1];
    }

    public String toString(){
        return String.valueOf(value);
    }

}
