package com.ncamc.webfluxdemo.service.Impl;

import com.ncamc.webfluxdemo.entity.User;
import com.ncamc.webfluxdemo.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserServiceImpl implements UserService {
    //创建一个Map集合,存储数据
    private final Map<Integer, User> users = new HashMap<>();

    public UserServiceImpl() {
        this.users.put(1, new User("lucy","male",10));
        this.users.put(2, new User("mary","female",20));
        this.users.put(3, new User("jack","male",30));
        this.users.put(4, new User("Don","male",40));
    }
    //查询id
    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person -> {
            //向map中放值
            int id = users.size() + 1;
            users.put(id,person);
        }).thenEmpty(Mono.empty());
    }
}
