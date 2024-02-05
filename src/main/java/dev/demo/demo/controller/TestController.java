package dev.demo.demo.controller;

import dev.demo.demo.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final ContentService service;

    @GetMapping("/print")
    public String HelloWorld() {
        return service.HelloWorld();
    }
}
