package be.bstorm.controllers;

import be.bstorm.models.entities.User;
import be.bstorm.models.forms.UserForm;
import be.bstorm.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(
            @RequestBody UserForm form
            ){

        User user = userService.register(form.toEntity());
        return ResponseEntity.ok(user);
    }
}
