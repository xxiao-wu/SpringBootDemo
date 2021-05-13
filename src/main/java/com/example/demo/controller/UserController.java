package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.response.ResponseBody;
import com.example.demo.response.ResponseCode;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private final UserService service = null;
    @PostMapping("sign/in/up")
    public ResponseBody signInUp(@RequestBody User user) {
        if (service.exists(user)) {
            User u = service.findByNameAndPassword(user);
            return new ResponseBody(u != null ? ResponseCode.SIGN_IN_SUCCESS : ResponseCode.SIGN_IN_FAILED, u != null ? u.getId() : 0,u != null ? u.getName() : "");
        }
        return new ResponseBody(service.insert(user) ? ResponseCode.SIGN_UP_SUCCESS : ResponseCode.SIGN_UP_FAILED, 0,"");
    }

    @PutMapping("update")
    public ResponseBody update(@RequestBody User user) {
        return new ResponseBody(service.update(user) ? ResponseCode.UPDATE_SUCCESS : ResponseCode.UPDATE_FAILED, 0,"");
    }

    @DeleteMapping("delete")
    public ResponseBody deleteByName(@RequestParam int id) {
        return new ResponseBody(service.deleteById(id) ? ResponseCode.DELETE_SUCCESS : ResponseCode.DELETE_FAILED, 0,"");
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }
}
