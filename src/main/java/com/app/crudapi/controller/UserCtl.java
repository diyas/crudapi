package com.app.crudapi.controller;

import com.app.crudapi.model.Response;
import com.app.crudapi.model.table.User;
import com.app.crudapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserCtl {

    @Autowired
    UserRepo users;

    @GetMapping("user")
    public ResponseEntity getAllUser(){

        List<User> lstUser = users.findAll();
        ResponseEntity<Response> resp = ResponseEntity.ok(new Response(200,"",lstUser));
        return resp;
    }

    @PostMapping("user")
    public ResponseEntity saveUser(@RequestBody User user){
        User u = users.save(user);
        return ResponseEntity.ok().body(new Response(200,"",u));
    }
    @PutMapping("user")
    public ResponseEntity updateUser(@RequestBody User user){
        User u = users.findById(user.getId()).orElse(null);
        u.setFullName(user.getFullName());
        u.setLastName(user.getLastName());
        u.setAddress(user.getAddress());
        u.setGender(user.getGender());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        User uUser = users.save(u);
        return ResponseEntity.ok().body(uUser);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") int id){
        User u = users.findById(id).orElse(null);
        users.delete(u);
        return ResponseEntity.ok().body(new Response(200,"User Id "+id+" Deleted.", null));
    }
}
