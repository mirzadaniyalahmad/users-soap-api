package com.cyberdiverge.userssoapapi.endpoint;


import com.cyberdiverge.users_soap_api.GetUserRequest;
import com.cyberdiverge.users_soap_api.User;
import com.cyberdiverge.userssoapapi.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.cyberdiverge.users_soap_api.GetUserResponse;

@Endpoint
public class GetUserEndpoint {
    @Autowired
    UserService userService;
    private static final String NAMESPACE_URI = "http://cyberdiverge.com/users-soap-api";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest getUserRequest) {
        GetUserResponse response = null;
        User user = userService.findById(getUserRequest.getId());
        if(user!=null){
            response = new GetUserResponse();
            response.setUser(user);
        }
        return response;
    }
}
