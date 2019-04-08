package com.app.crudapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Response {
    private int code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
}
