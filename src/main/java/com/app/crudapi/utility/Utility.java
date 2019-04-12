package com.app.crudapi.utility;

import com.app.crudapi.model.error.Errors;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility {

    public static Errors[] mapErrors(Object map){
        ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String error = "";
        Errors[] errors = null;
        try {
            error = mapper.writeValueAsString(map);
            errors = mapper.readValue(error, Errors[].class);
        } catch (Exception e){
            e.getMessage();
        }
        return errors;
    }
}
