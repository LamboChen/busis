package com.grad.vo;

import com.grad.entity.History;
import org.springframework.stereotype.Component;

/**
 * @program: busis
 * @description:
 * @author: Mr.Chen
 * @create: 2018-03-22 18:20
 **/
@Component(value = "historyApiVo")
public class HistoryApiVo {

    private int code;
    private String message;
    private History history;

    public HistoryApiVo(){

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

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
