package lk.ijse.database.service;
import lk.ijse.database.entity.User;
import lk.ijse.database.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImple (UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("User not found exception"+id));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);

        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());

       return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
}
