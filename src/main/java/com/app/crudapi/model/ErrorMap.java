package com.app.crudapi.model;

import java.util.Collection;
import java.util.Map;

public class ErrorMap {

    private Integer status;
    private String error;
    private Collection errors;
    private String message;
    private String timeStamp;
    private String trace;

    public ErrorMap(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
        this.timeStamp = errorAttributes.get("timestamp").toString();
        this.trace = (String) errorAttributes.get("trace");
        this.errors = (Collection) errorAttributes.get("errors");
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getTrace() {
        return trace;
    }

    public Collection getErrors() {
        return errors;
    }

    public void setErrors(Collection errors) {
        this.errors = errors;
    }
}
