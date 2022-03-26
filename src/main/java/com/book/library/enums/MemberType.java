package com.book.library.enums;

import lombok.Getter;

/**
 * @author earl.liu
 * @date 2022/3/26 上午8:44
 */
@Getter
public enum MemberType {

    GOLD_MEMBER(1,"gold"),
    SILVER_MEMBER(2,"silver"),
    COPPER_MEMBER(3,"copper");


    private Integer id;
    private String value;


    MemberType(Integer id, String value) {
        this.id = id;
        this.value = value;
    }



    public static MemberType getMemberType(Integer id){
        if (id == null || id < 0){
            return null;
        }
        for (MemberType memberType :  MemberType.values()){
           if (memberType.getId().equals(id)){
               return memberType;
           }
        }
        return null;
    }
}
