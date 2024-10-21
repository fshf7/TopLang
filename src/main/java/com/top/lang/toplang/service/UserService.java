package com.top.lang.toplang.service;

import com.top.lang.toplang.entity.UserEntity;
import java.util.List;

public interface UserService {
    public void save(UserEntity user);
    public List<Object> isUserPresent(UserEntity user);
}
