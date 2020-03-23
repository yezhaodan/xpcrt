package com.yezd.xpcrt.service.impl;

import com.yezd.xpcrt.config.JedisConfig;
import com.yezd.xpcrt.dao.entity.UserEntity;
import com.yezd.xpcrt.dao.repository.UserRepository;
import com.yezd.xpcrt.service.UserService;
import com.yezd.xpcrt.util.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    private ServerResponse serverResponse;

    @Resource
    private JedisPool jedisPool;


    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String,String> redisString;

    @Resource(name="redisTemplate")
    private HashOperations<String,String,UserEntity> redisHash;

    private Logger logger = LoggerFactory.getLogger(JedisConfig.class);

    @Override
    public ServerResponse saveUser(UserEntity user) {
        UserEntity userDTO = userRepository.save(user);
        return ServerResponse.createBySuccess(userDTO);
    }

    @Override
    public ServerResponse deleteUser(String id) {
        userRepository.deleteById(id);
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse updateUser(String userId, UserEntity user) {
        user.setId(Integer.valueOf(userId));
        UserEntity userDTO = userRepository.saveAndFlush(user);
        return ServerResponse.createBySuccess(userDTO);
    }

    @Override
    public ServerResponse getUserInfo(String userId) {
        UserEntity userDTO = userRepository.getOne(userId);
        return ServerResponse.createBySuccess(userDTO);
    }

    @Override
    public ServerResponse checkPassword(String name, String password) {
        UserEntity user = userRepository.findByName(name);
        if(user == null){
            return ServerResponse.createByErrorMessage("该用户名不存在");
        }else if (!user.getPassword().equals(password)){
            return ServerResponse.createByErrorMessage("密码输入错误，请重新输入");
        }else{
            return ServerResponse.createBySuccessMessage("密码正确，页面跳转中");
        }
    }

    @Override
    public String getString(String key) {
//        //0、定义返回结果
//        String value = null;
//        //1、得到Jedis对象
//        Jedis jedis = jedisPool.getResource();
//        //2、判断Key是否存在于Redis中
//        if(jedis.exists(key)){
//            logger.info("查询Redis中的数据");
//            return jedis.get(key);
//        }else{
//            logger.info("查询Mysql中的数据");
//            value = "1";
//            //3、将Mysql中查询出的数据赋值给Redis
//            jedis.set(key,value);
//        }
//        jedis.close();
//        return value;

        if(redisTemplate.hasKey(key)) {
            logger.info("Redis中查询");
            return redisString.get(key);
        }else{
            String value="学习Lettuce";
            logger.info("Mysql中查询");
            redisString.set(key,value);
            logger.info("存入Redis");
            return value;
        }

    }
}
