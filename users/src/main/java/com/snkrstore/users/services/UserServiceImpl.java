package com.snkrstore.users.services;

import com.snkrstore.users.domain.User;
import com.snkrstore.users.repository.UserRepository;
import com.snkrstore.users.web.mappers.UserMapper;
import com.snkrstore.users.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDto getUser(String email) {
       Optional<User> userOptional = userRepository.findById(email);
       User user = new User();
       if(userOptional.isPresent()){
           user = userOptional.get();
       }
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user =  userMapper.userDtoToUser(userDto);
        user = userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user =  userMapper.userDtoToUser(userDto);
        user = userRepository.save(user);
        return userMapper.userToUserDto(user);
    }
}
