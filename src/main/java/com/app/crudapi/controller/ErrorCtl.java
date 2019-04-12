package com.app.crudapi.controller;

import com.app.crudapi.model.ErrorMap;
import com.app.crudapi.model.Response;
import com.app.crudapi.model.error.Errors;
import com.app.crudapi.utility.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@RestController
public class ErrorCtl implements ErrorController {

    private static final String PATH = "/error";

    @Value("true")
    private boolean debug;

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    public Response error(HttpServletRequest request, HttpServletResponse response) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring.
        // Here we just define response body.
        Map<String, Object> errAttr = getErrorAttributes(request, true);
        ErrorMap err = new ErrorMap(response.getStatus(), errAttr);
        Response resp = new Response();
        resp.setCode(err.getStatus());
        resp.setMessage(err.getError());
        Object map = err.getErrors();
//        ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
//        String error = "";
//        Errors[] errors = null;
//        try {
//            error = mapper.writeValueAsString(map);
//            errors = mapper.readValue(error, Errors[].class);
//        } catch (Exception e){
//            e.getMessage();
//        }
        Errors[] errors = Utility.mapErrors(map);
        resp.setData(errors);
        return resp;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        ServletWebRequest requestAttributes = new ServletWebRequest(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
}
