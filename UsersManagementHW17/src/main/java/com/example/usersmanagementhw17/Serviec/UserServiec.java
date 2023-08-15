package com.example.usersmanagementhw17.Serviec;

import com.example.usersmanagementhw17.Model.User;
import com.example.usersmanagementhw17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiec {

    private final UserRepository userRepository;


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public void addUsers(User user){
        userRepository.save(user);
    }



    public Boolean updateUsers(Integer id,User user){
        User OldUser=userRepository.getById(id);
        if (OldUser==null){
            return false;
        }

        OldUser.setName(user.getName());
        OldUser.setUsername(user.getUsername());
        OldUser.setPassword(user.getPassword());
        OldUser.setEmail(user.getEmail());
        OldUser.setRole(user.getRole());
        OldUser.setAge(user.getAge());
        userRepository.save(OldUser);

        return true;

    }

    public Boolean deleteUsers(Integer id){
        User deleteUsers=userRepository.getById(id);
        if (deleteUsers==null){
            return false;
        }
        userRepository.delete(deleteUsers);
        return true;  }





}
