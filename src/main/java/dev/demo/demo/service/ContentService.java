package dev.demo.demo.service;

import dev.demo.demo.dao.ContentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentMapper mapper;
    public String HelloWorld() {
        return mapper.getContentById(1L).getContent();
    }
}
