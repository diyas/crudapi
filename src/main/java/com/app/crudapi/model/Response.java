package com.app.crudapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Response {
    private int code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Paginate paginate;

    public Response(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(){

    }
}
