package com.example.usersmanagementhw17.Controller;

import com.example.usersmanagementhw17.ApiRespoens.ApiRespoens;
import com.example.usersmanagementhw17.Model.User;
import com.example.usersmanagementhw17.Serviec.UserServiec;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {


    private final UserServiec userServiec;


    @GetMapping("/get")
    public ResponseEntity getAllUsers() {

        return ResponseEntity.status(200).body(userServiec.getAllUsers());
    }


    @PostMapping("/add")
    public ResponseEntity addUsers(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userServiec.addUsers(user);
        return ResponseEntity.status(200).body(new ApiRespoens("User added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isupdated = userServiec.updateUsers(id, user);
        if (isupdated) {
            return ResponseEntity.status(200).body(new ApiRespoens("User updated"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("wrong id"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUsers(@PathVariable Integer id) {

        Boolean isDeleted = userServiec.deleteUsers(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiRespoens("User deleted"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("Wrong Id"));

    }

}
