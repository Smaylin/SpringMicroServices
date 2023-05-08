package org.srobles.springcloud.msvc.usuarios.msvcusuarios.services;

import org.srobles.springcloud.msvc.usuarios.msvcusuarios.models.entity.users;

import java.util.List;
import java.util.Optional;

public interface UserService {

    java.util.List<users> LIST();
    Optional<users> GETBYID(Long id); // Optional: https://www.baeldung.com/java-optional
    users SAVE(users user);
    void  DELETE(Long id);
}
