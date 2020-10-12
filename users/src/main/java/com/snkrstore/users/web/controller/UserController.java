package com.snkrstore.users.web.controller;

import com.snkrstore.users.services.UserService;
import com.snkrstore.users.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping({"/{email}"})
    public ResponseEntity<UserDto> getUser(@PathVariable("email") String email){
        return  new ResponseEntity<>(userService.getUser(email), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto){
        userDto.setPassword(BCrypt.hashpw(userDto.getPassword(),BCrypt.gensalt()));
        return  new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.OK);
    }

    @PutMapping
    public  ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto){
        userDto.setPassword(BCrypt.hashpw(userDto.getPassword(),BCrypt.gensalt()));
        return  new ResponseEntity<>(userService.updateUser(userDto), HttpStatus.OK);
    }

}
