package com.cairiton.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cairiton.config.JwtUtils;
import com.cairiton.model.JwtRequest;
import com.cairiton.model.JwtResponse;
import com.cairiton.model.User;
import com.cairiton.services.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;
    
    
    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    	 try{
    		 authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
         }catch (Exception exception){
             exception.printStackTrace();
             throw new Exception("user not found");
         }
    	 UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
         String token = this.jwtUtils.generateToken(userDetails);
         return ResponseEntity.ok(new JwtResponse(token));
    }
    
    private void authenticate(String username,String password) throws Exception {
    	try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("DISABLED USER " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("invalid credentials " + e.getMessage());
        }
    }
    
    
    
    @GetMapping("/actual-user")
    public User getCurrentUser(Principal principal){
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    }

}
