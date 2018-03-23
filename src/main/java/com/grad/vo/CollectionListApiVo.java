package com.grad.vo;

import com.grad.entity.Collection;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-22 17:49
 **/

@Component(value = "collectionListApiVo")
public class CollectionListApiVo {

    private int code;
    private List<Collection> collectionList;
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

    public List<Collection> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<Collection> collectionList) {
        this.collectionList = collectionList;
    }
}
