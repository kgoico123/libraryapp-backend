package com.lectorium.repo;

import com.lectorium.model.User;

public interface IUserRepo  extends IGenericRepo<User, Integer> {
    User findOneByUsername(String username);
}
