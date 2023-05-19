package org.srobles.springcloud.msvc.usuarios.msvcusuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.srobles.springcloud.msvc.usuarios.msvcusuarios.models.entity.Users;
import org.srobles.springcloud.msvc.usuarios.msvcusuarios.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository UserRepository;

    @Override
    @Transactional(readOnly = true) // https://www.baeldung.com/spring-new-transactional-features
    public List<Users> LIST() {
        return (List<Users>) UserRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Users> GETBYID(Long id) {

        return UserRepository.findById(id);
    }

    @Override
    @Transactional
    public Users SAVE(Users user) {

        return UserRepository.save(user);
    }

    @Override
    @Transactional
    public void DELETE(Long id) {
        UserRepository.deleteById(id);
    }
}
