package dev.demo.demo.service;

import dev.demo.demo.dao.ContentMapper;
import dev.demo.demo.model.entity.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentMapper mapper;
    public String printHelloWorld() {
        return mapper.getContentById(1L).getContent();
    }
    public List<Content> getAllContents() {
        return mapper.getAllContent();
    }

    public Content getSingleContent(Long id) {
        return mapper.getContentById(id);
    }
}
