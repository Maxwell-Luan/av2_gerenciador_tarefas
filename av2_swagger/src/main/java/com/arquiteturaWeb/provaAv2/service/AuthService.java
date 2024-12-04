package com.arquiteturaWeb.provaAv2.service;

import com.arquiteturaWeb.provaAv2.config.JwtUtil;
import com.arquiteturaWeb.provaAv2.model.User;
import com.arquiteturaWeb.provaAv2.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return jwtUtil.generateToken(username);
        }
        throw new RuntimeException("Credenciais inválidas.");
    }

    // Método Register Adicionado
    public void register(String username, String password) {
        // Verifique se o usuário já existe
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Usuário já existe.");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Encripta a senha
        userRepository.save(user); // Salva o novo usuário no banco
    }
}
