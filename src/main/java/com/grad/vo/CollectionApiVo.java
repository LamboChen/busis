package com.grad.vo;

import com.grad.entity.Collection;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-22 17:44
 **/
@Scope(value = "prototype")
@Component(value = "collectionApiVo")
public class CollectionApiVo {

    private int code;
    private Collection collection;
    private String message;

    public CollectionApiVo(){

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
