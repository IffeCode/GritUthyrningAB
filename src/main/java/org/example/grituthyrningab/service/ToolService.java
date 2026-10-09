package org.example.grituthyrningab.service;

import org.example.grituthyrningab.model.Tool;
import org.example.grituthyrningab.repository.ToolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ToolService {

    private ToolRepository toolRepository;

    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public List<Tool> listAll() {
        return toolRepository.findAll();
    }

    public Tool get(Long id) {
        return toolRepository.findById(id).get();
    }

    public Tool save(Tool tool) {
        return toolRepository.save(tool);
    }

    public void delete(Long id) {
        toolRepository.deleteById(id);
    }


}
