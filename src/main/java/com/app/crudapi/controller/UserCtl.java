package com.app.crudapi.controller;

import com.app.crudapi.model.Paginate;
import com.app.crudapi.model.Response;
import com.app.crudapi.model.table.User;
import com.app.crudapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class UserCtl {

    @Autowired
    UserRepo users;

    @GetMapping("/user")
    public Response getAllUser(@RequestParam(value = "limit", defaultValue = "10") int limit, @RequestParam(value = "page", defaultValue = "1") int page){
        //System.out.println("Limit="+limit+"&Page="+page);
        if (limit != 0 && page != 0){
            Pageable pageable = new PageRequest(page - 1, limit);
            Page<User> emp = users.findAll(pageable);
            long totalData = emp.getTotalElements();
            long totalPage = totalData / 10;
            Paginate paginate = new Paginate();
            paginate.setLimit(limit);
            paginate.setPage(page);
            paginate.setTotalData(totalData);
            paginate.setTotalPage(totalPage);
            Response resp = new Response();
            resp.setCode(200);
            resp.setMessage("");
            resp.setData(emp.getContent());
            resp.setPaginate(paginate);
            return resp;
        }
        return null;
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
