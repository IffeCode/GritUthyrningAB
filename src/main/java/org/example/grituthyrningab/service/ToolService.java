package org.example.grituthyrningab.service;

import org.example.grituthyrningab.repository.ToolRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ToolService {

    private ToolRepository toolRepository;

    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }
}
