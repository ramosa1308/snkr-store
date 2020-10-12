package com.snkrstore.users.services;

import com.snkrstore.users.web.model.UserDto;

public interface UserService {

    UserDto getUser(String email);
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);

}
