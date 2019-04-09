package com.app.crudapi.controller;

import com.app.crudapi.model.InputForm;
import com.app.crudapi.model.Response;
import com.app.crudapi.model.SignIn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MainCtl {

    @PostMapping("/signin")
    public Response signIn(@RequestBody @Valid SignIn signin){
        Response resp = new Response();
        resp.setCode(200);
        resp.setMessage("OK");
        resp.setData(signin);
        return resp;
    }

    @PostMapping("/inputForm")
    public Response inputForm(@RequestBody @Valid InputForm input){
        Response resp = new Response();
        resp.setCode(200);
        resp.setMessage("OK");
        resp.setData(input);
        return resp;
    }
}
