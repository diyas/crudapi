
package com.app.crudapi.model.error;

import lombok.Data;

import java.util.List;

@Data
public class Errors {

    private List<Argument> arguments;
    private Boolean bindingFailure;
    private String code;
    private List<String> codes;
    private String defaultMessage;
    private String field;
    private String objectName;
    private String rejectedValue;

}
