package com.snkrstore.users.web.mappers;

import com.snkrstore.users.domain.User;
import com.snkrstore.users.web.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UserMapperDecorator implements UserMapper{
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public UserDto userToUserDto(User user) {
        return userMapper.userToUserDto(user);
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        return userMapper.userDtoToUser(userDto);
    }
}
