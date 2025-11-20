package com.example.studyplatform.controller;

import com.example.studyplatform.model.User;
import com.example.studyplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Простая регистрация для теста (без шифрования пароля пока)
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Получить всех пользователей
    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
