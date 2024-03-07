package org.example.backofficeeshop.service;

import org.example.backofficeeshop.model.UserEntity;
import org.example.backofficeeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByUsername(username).orElseThrow(()->{
                    return new UsernameNotFoundException("User with username: " + username + " not found");
                });
            }
        };
    }

    public ResponseEntity<UserEntity> addUser(UserEntity user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.status(409).build();
            //throw new IllegalStateException("User with username : " + user.getUsername() + " already exist in the database");
        } else {
            userRepository.save(user);
            return ResponseEntity.ok(user);
        }
    }
}
