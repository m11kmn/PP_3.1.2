package ru.m11.springproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.m11.springproject.models.User;
import ru.m11.springproject.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<User> showListOfUsers() {
        return usersRepository.findAll();
    }

    public User findUserById(Long id) {
        Optional<User> foundUser = usersRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Transactional
    public void saveUser(User user) {
        usersRepository.save(user);
    }

    @Transactional
    public void updateUser(Long id, User updatedUser) {
        updatedUser.setId(id);
        usersRepository.save(updatedUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
