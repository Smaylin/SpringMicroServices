package org.srobles.springcloud.msvc.usuarios.msvcusuarios.services;

import org.srobles.springcloud.msvc.usuarios.msvcusuarios.models.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {

    java.util.List<Users> LIST();
    Optional<Users> GETBYID(Long id); // Optional: https://www.baeldung.com/java-optional
    Users SAVE(Users user);
    void  DELETE(Long id);
}
