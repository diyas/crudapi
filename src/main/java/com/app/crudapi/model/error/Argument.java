
package com.app.crudapi.model.error;

import lombok.Data;

import java.util.List;

@Data
public class Argument {

    private Object arguments;
    private String code;
    private List<String> codes;
    private String defaultMessage;

}
