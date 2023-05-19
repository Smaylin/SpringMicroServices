package org.srobles.springcloud.msvc.usuarios.msvcusuarios.repositories;

import org.springframework.data.repository.CrudRepository;
import org.srobles.springcloud.msvc.usuarios.msvcusuarios.models.entity.Users;

public interface UserRepository extends CrudRepository<Users, Long> {
}
