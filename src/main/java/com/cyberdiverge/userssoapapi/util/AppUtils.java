package com.cyberdiverge.userssoapapi.util;

import com.cyberdiverge.userssoapapi.model.UserEntity;
import com.cyberdiverge.users_soap_api.User;

public class AppUtils {
    public static User getUser(UserEntity userEntity){
        if(userEntity!=null){
            User user = new User();
            user.setUsername(userEntity.getUserName());
            user.setId(userEntity.getId());
            user.setFirstname(userEntity.getFirstName());
            user.setLastname(userEntity.getLastName());
            user.setEmail(userEntity.getEmail());
            return user;
        }
        return null;
    }

    public static UserEntity getUserEntity(User user){
        if(user!=null){
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(user.getUsername());
            userEntity.setId(user.getId());
            userEntity.setFirstName(user.getFirstname());
            userEntity.setLastName(user.getLastname());
            userEntity.setEmail(user.getEmail());
            return userEntity;
        }
        return null;
    }
}
