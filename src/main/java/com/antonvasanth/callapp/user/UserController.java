package com.antonvasanth.callapp.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
@CrossOrigin(origins = "*")
public class UserController {


    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public User login(User user) {
      return  userService.login(user);
    }
    @PostMapping("/register")
    public void register(User user){
        userService.register(user);
    }
     @PostMapping("/logout")
    public void logout(String email){
        userService.logout(email);
    }
    @GetMapping("/get")
    public List<User> getAll()
    {
       return userService.getAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(Exception ex)
    {
        ex.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }


}
