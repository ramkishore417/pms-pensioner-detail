package com.ramkishore.pensionerdetail.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authorization-service", url="${AUTHORIZATION_SERVICE_URI : http://localhost:8001}")
public interface AuthorizationClient {

    /* Validating jwt token with Authorization Microservice */
    @GetMapping("/authorize")
    public Boolean authorization(@RequestHeader("Authorization") String token);
}
