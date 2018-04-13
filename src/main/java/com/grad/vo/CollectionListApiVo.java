package com.grad.vo;

import com.grad.entity.Collection;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-22 17:49
 **/
@Scope(value = "prototype")
@Component(value = "collectionListApiVo")
public class CollectionListApiVo {

    private int code;
    private ArrayList<Collection> collectionList;
    private String message;

    public CollectionListApiVo(){

    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCollectionList(ArrayList<Collection> collectionList) {
        this.collectionList = collectionList;
    }

    public ArrayList<Collection> getCollectionList() {
        return collectionList;
    }
}
