package com.cyberdiverge.userssoapapi.endpoint;


import com.cyberdiverge.users_soap_api.CreateUserRequest;
import com.cyberdiverge.users_soap_api.GetUserRequest;
import com.cyberdiverge.users_soap_api.GetUserResponse;
import com.cyberdiverge.users_soap_api.User;
import com.cyberdiverge.userssoapapi.repository.UserService;
import com.cyberdiverge.userssoapapi.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CreateUserEndpoint {
    @Autowired
    UserService userService;
    private static final String NAMESPACE_URI = "http://cyberdiverge.com/users-soap-api";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public void createUser(@RequestPayload CreateUserRequest createUserRequest) {
        if(createUserRequest.getUser()!=null){
            userService.save(AppUtils.getUserEntity(createUserRequest.getUser()));
        }
    }
}
