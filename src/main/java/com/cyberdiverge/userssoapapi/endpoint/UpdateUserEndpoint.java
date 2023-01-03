package com.cyberdiverge.userssoapapi.endpoint;


import com.cyberdiverge.users_soap_api.CreateUserRequest;
import com.cyberdiverge.users_soap_api.UpdateUserRequest;
import com.cyberdiverge.userssoapapi.repository.UserService;
import com.cyberdiverge.userssoapapi.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UpdateUserEndpoint {
    @Autowired
    UserService userService;
    private static final String NAMESPACE_URI = "http://cyberdiverge.com/users-soap-api";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public void updateUser(@RequestPayload UpdateUserRequest updateUserRequest) {
        if(updateUserRequest.getUser()!=null){
            userService.update(AppUtils.getUserEntity(updateUserRequest.getUser()));
        }
    }
}
