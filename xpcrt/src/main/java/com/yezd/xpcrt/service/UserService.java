package com.yezd.xpcrt.service;

import com.yezd.xpcrt.dao.entity.UserEntity;
import com.yezd.xpcrt.util.ServerResponse;

public interface UserService {

    public ServerResponse saveUser(UserEntity user);
    public ServerResponse deleteUser(String id);
    public ServerResponse updateUser (String userId,UserEntity user);
    public ServerResponse getUserInfo(String userId);
    public ServerResponse checkPassword(String name, String password);

    /*
        Redis实现:[Jedis]
            用户输入一个Key，首先在Redis中判断是否存在该数据，
            如果存在，在Redis中进行查询，并返回，
            如果不存在，在Mysql中进行查询，并将结果赋值给Redis,并返回
    */
    public String getString(String key);
}

