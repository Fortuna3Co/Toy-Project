package com.toyproject.toyproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class tempController {

    @PostMapping("/signUp")
    public String userSignUp(@RequestBody Map<String, String> userInfo) {
        System.out.println("signUp");
        System.out.println(userInfo);
        return "returnValue";
        //return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
        //return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/test")
    public String userSignUp() {
        System.out.println("Test");
        return "Test";
    }
}
