package com.bennett.unigo.wallet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bennett.unigo.wallet.entity.User;
import com.bennett.unigo.wallet.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
        	if (updatedUser.getUserName()!= null)
        		existingUser.setUserName(updatedUser.getUserName());
        	if (updatedUser.getPassword()!= null)
            	existingUser.setPassword(updatedUser.getPassword());
        	if (updatedUser.getStudentId()!= null)
            	existingUser.setStudentId(updatedUser.getStudentId());
        	if (updatedUser.getActive()!= null)
            	existingUser.setActive(updatedUser.getActive());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    
    public boolean login(String userName, String password) {
    	Optional<User> userOptional = userRepository.findByUserName(userName);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
        	return true;
        } else {
        	return false;
        }
    }
    
    public Boolean updateUserPassword(String userName,String password ,String newPassword) {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(newPassword);
            userRepository.save(user);
            return true;
        }
        return false; // Or throw an exception indicating the user was not found
    }
    

}
