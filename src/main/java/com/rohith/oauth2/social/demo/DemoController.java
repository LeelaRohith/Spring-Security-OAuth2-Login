package com.rohith.oauth2.social.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementPermission;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping
    public ResponseEntity<String> hello(Authentication authentication)
    {
        Object principal=authentication.getPrincipal();
        DefaultOAuth2User oauth2User = (DefaultOAuth2User) principal;
        Object nameObject = oauth2User.getAttribute("name");
        Object emailObject = oauth2User.getAttribute("email");
        return ResponseEntity.ok("Hello from secure end point Name: "+nameObject+"Email :"+emailObject);
    }
}
