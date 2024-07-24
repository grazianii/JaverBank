package io.github.grazianii.domain.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    @GetMapping("/public")
    public ResponseEntity <String> publicRoute(Authentication authentication){
        System.out.println(authentication.getClass());
        return ResponseEntity.ok("Public route ok!");
    }

    @GetMapping("/private")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity <String> privateRoute(Authentication authentication){
        System.out.println(authentication.getClass());
        return ResponseEntity.ok("Private route ok! Usuário conectado: " + authentication.getName());
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminRoute(Authentication authentication){
        System.out.println(authentication.getClass());
        return ResponseEntity.ok("Admin route ok!");
    }
}
