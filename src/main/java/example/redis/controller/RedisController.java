package example.redis.controller;

import example.redis.model.User;
import example.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RedisController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public User save(@RequestBody User user){
        return userRepository.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userRepository.getById(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteUser(@PathVariable Integer id){
        return userRepository.deleteUser(id);
    }
}
