package com.grad.vo;

import com.grad.entity.History;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-22 18:24
 **/
@Component(value = "historyListApiVo")
public class HistoryListApiVo {

    private int code;
    private String message;
    private List<History> historyList;

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

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }
}
