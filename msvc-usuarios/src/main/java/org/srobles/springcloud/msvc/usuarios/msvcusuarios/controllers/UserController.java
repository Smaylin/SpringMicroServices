package org.srobles.springcloud.msvc.usuarios.msvcusuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.srobles.springcloud.msvc.usuarios.msvcusuarios.models.entity.Users;
import org.srobles.springcloud.msvc.usuarios.msvcusuarios.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<Users> getUsers() {
        return service.LIST();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<Users> userOptional = service.GETBYID(id);
        if(userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Users user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.SAVE(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Users user, @PathVariable Long id) {
        Optional<Users> userOptional = service.GETBYID(id);
        if(userOptional.isPresent()) {
            Users userDb = userOptional.get();
            userDb.setName(user.getName());
            userDb.setEmail(user.getEmail());
            userDb.setPassword(user.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.SAVE(userDb));
        }
        return  ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Users> userOptional = service.GETBYID(id);
        if(userOptional.isPresent()) {
            service.DELETE(id);
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }
}
