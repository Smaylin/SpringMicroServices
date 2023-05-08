package org.srobles.springcloud.msvc.usuarios.msvcusuarios.repositories;

import org.springframework.data.repository.CrudRepository;
import org.srobles.springcloud.msvc.usuarios.msvcusuarios.models.entity.users;

public interface UserRepository extends CrudRepository<users, Long> {
}
