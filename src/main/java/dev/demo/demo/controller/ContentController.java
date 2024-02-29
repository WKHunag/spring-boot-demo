package dev.demo.demo.controller;

import dev.demo.demo.model.Content;
import dev.demo.demo.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/content/api")
public class ContentController {
    private final ContentService service;

    @GetMapping("/v1/hello-world")
    public ResponseEntity<String> printHelloWorld() {
        return new ResponseEntity<>(service.printHelloWorld(), HttpStatus.OK);
    }

    @GetMapping("/v1/all-contents")
    public ResponseEntity<List<Content>> getAllContents() {
        return new ResponseEntity<>(service.getAllContents(), HttpStatus.OK);
    }

    @GetMapping("/v1/content/{id}")
    public ResponseEntity<Content> getContents(@PathVariable long id) {
        return new ResponseEntity<>(service.getSingleContent(id), HttpStatus.OK);
    }
}
