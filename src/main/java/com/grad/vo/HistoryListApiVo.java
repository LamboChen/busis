package com.grad.vo;

import com.grad.entity.History;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-22 18:24
 **/
@Scope(value = "prototype")
@Component(value = "historyListApiVo")
public class HistoryListApiVo {

    private int code;
    private String message;
    private ArrayList<History> historyList;

    public HistoryListApiVo(){

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

    public void setHistoryList(ArrayList<History> historyList) {
        this.historyList = historyList;
    }

    public ArrayList<History> getHistoryList() {
        return historyList;
    }
}
