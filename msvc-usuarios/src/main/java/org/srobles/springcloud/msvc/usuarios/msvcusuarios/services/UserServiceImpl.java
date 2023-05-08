package org.srobles.springcloud.msvc.usuarios.msvcusuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.srobles.springcloud.msvc.usuarios.msvcusuarios.models.entity.users;
import org.srobles.springcloud.msvc.usuarios.msvcusuarios.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository UserRepository;

    @Override
    @Transactional(readOnly = true) // https://www.baeldung.com/spring-new-transactional-features
    public List<users> LIST() {
        return (List<users>) UserRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<users> GETBYID(Long id) {

        return UserRepository.findById(id);
    }

    @Override
    @Transactional
    public users SAVE(users user) {

        return UserRepository.save(user);
    }

    @Override
    @Transactional
    public void DELETE(Long id) {
        UserRepository.deleteById(id);
    }
}
