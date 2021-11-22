package example.redis.repository;

import example.redis.model.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    public static final String HASH_KEY = "User";

    private RedisTemplate redisTemplate;

    public UserRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public User saveUser(User user){
        redisTemplate.opsForHash().put(HASH_KEY, user.getId(), user);
        return user;
    }

    public List<User> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public User getById(Integer id){
        return (User) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public boolean deleteUser(Integer id){
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return true;
    }
}
