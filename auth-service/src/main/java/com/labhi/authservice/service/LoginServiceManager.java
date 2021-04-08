package com.labhi.authservice.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.labhi.auth.model.JwtToken;
import com.labhi.auth.model.Role;
import com.labhi.auth.model.User;
import com.labhi.authservice.dao.JwtTokenRepository;
import com.labhi.authservice.dao.UserRepository;
import com.labhi.authservice.security.JwtTokenProvider;

@Service
public class LoginServiceManager {
	@Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    //@Autowired
   // private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    public String login(String username, String password) throws Exception {
        try {
           // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
             //       password));
            User user = userRepository.findByEmail(username);
            if (user == null || user.getRole() == null || user.getRole().isEmpty()) {
            	user = new User();
            	user.setEmail(username);
            	Role role = new Role();
            	role.setRole("ADMIN");
            	user.setRole(new HashSet<>(Arrays.asList(role)));
                user = userRepository.insert(user);
                
            }
            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
            String token =  jwtTokenProvider.createToken(username, user.getRole().stream()
                    .map((Role role)-> "ROLE_"+role.getRole()).filter(Objects::nonNull).collect(Collectors.toList()));
            return token;

        } catch (Exception e) {
            throw new Exception("Invalid username or password.");
        }
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()) );
        return userRepository.save(user);
    }

    public boolean logout(String token) {
         jwtTokenRepository.delete(new JwtToken(token));
         return true;
    }

  

}
