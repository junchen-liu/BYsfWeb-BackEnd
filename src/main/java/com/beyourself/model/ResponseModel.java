package com.beyourself.model;

import lombok.Data;

@Data
public class ResponseModel {
    private String status;
    private String msg;

    public ResponseModel(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
