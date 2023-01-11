package com.cyberdiverge.userssoapapi.endpoint;


import com.cyberdiverge.users_soap_api.*;
import com.cyberdiverge.userssoapapi.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class GetCapabilitiesByUserEndpoint {
    @Autowired
    UserService userService;
    private static final String NAMESPACE_URI = "http://cyberdiverge.com/users-soap-api";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCapabilitiesByUserIdRequest")
    @ResponsePayload
    public GetCapabilitiesByUserIdResponse getCapabilitiesByUser(@RequestPayload GetCapabilitiesByUserIdRequest getCapabilitiesByUserIdRequest) {
        GetCapabilitiesByUserIdResponse response = null;
        List<String> capabilitiesList = userService.searchCapabilityById(getCapabilitiesByUserIdRequest.getId());
        if(capabilitiesList!=null){
            response = new GetCapabilitiesByUserIdResponse();
            for(String c:capabilitiesList)
            response.getCapability().add(c);
        }
        return response;
    }
}
