package com.labhi.authservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.labhi.auth.model.AuthResponse;
import com.labhi.auth.model.LoginRequest;
import com.labhi.auth.model.User;
import com.labhi.authservice.dao.UserRepository;
import com.labhi.authservice.service.LoginServiceManager;

@RestController
@RequestMapping("login")
public class LoginController {


    @Autowired
    private LoginServiceManager loginService;
    
    @Autowired
    private UserRepository userRepo;

    @CrossOrigin("*")
    @PostMapping("/signin")
    @ResponseBody
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {
        String token = loginService.login(loginRequest.getUsername(),loginRequest.getPassword());
        HttpHeaders headers = new HttpHeaders();
        List<String> headerlist = new ArrayList<>();
        List<String> exposeList = new ArrayList<>();
        headerlist.add("Content-Type");
        headerlist.add(" Accept");
        headerlist.add("X-Requested-With");
        headerlist.add("Authorization");
        headers.setAccessControlAllowHeaders(headerlist);
        exposeList.add("Authorization");
        headers.setAccessControlExposeHeaders(exposeList);
        headers.set("Authorization", token);
        User user = userRepo.findByEmail(loginRequest.getUsername());
        return new ResponseEntity<AuthResponse>(new AuthResponse(token, user.getId().toHexString()), headers, HttpStatus.CREATED);
    }
    @CrossOrigin("*")
    @PostMapping("/signout")
    @ResponseBody
    public ResponseEntity<AuthResponse> logout (@RequestHeader(value="Authorization") String token) {
        HttpHeaders headers = new HttpHeaders();
      if (loginService.logout(token)) {
          headers.remove("Authorization");
          return new ResponseEntity<AuthResponse>(new AuthResponse("logged out", null), headers, HttpStatus.CREATED);
      }
        return new ResponseEntity<AuthResponse>(new AuthResponse("Logout Failed", null), headers, HttpStatus.NOT_MODIFIED);
    }

   
}
