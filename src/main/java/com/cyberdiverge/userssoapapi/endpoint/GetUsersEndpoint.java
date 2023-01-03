package com.cyberdiverge.userssoapapi.endpoint;

import com.cyberdiverge.userssoapapi.model.UserEntity;
import com.cyberdiverge.userssoapapi.repository.UserService;
import com.cyberdiverge.userssoapapi.util.AppUtils;
import com.cyberdiverge.users_soap_api.GetUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class GetUsersEndpoint {
    @Autowired
    UserService userService;
    private static final String NAMESPACE_URI = "http://cyberdiverge.com/users-soap-api";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsersRequest")
    @ResponsePayload
    public GetUsersResponse getUsers() {
        List<UserEntity> users = userService.getUsers();
        GetUsersResponse response = null;
        if(users!=null) {
            response = new GetUsersResponse();
            for (UserEntity u : users) {
                response.getUsers().add(AppUtils.getUser(u));
            }
        }
        return response;
    }
}
