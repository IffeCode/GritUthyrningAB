package org.example.grituthyrningab.service;

import org.example.grituthyrningab.model.Tool;
import org.example.grituthyrningab.repository.ToolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
        return toolRepository.findById(id)
                .orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Tool not found with id: " + id
                ));
    }

    public Tool save(Tool tool) {
        return toolRepository.save(tool);
    }

    public Tool update(Long id, Tool tool) {
        Tool existingTool = get(id);

        if (tool.getToolName() != null) {
            existingTool.setToolName(tool.getToolName());
        }
        if (tool.getToolDescription() != null) {
            existingTool.setToolDescription(tool.getToolDescription());
        }

        return toolRepository.save(existingTool);
    }

    //om tool finns skickas json body annars får vi 404 "not found"
    public void delete(Long id) {
        toolRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Tool not found with id: " + id
        ));

        toolRepository.deleteById(id);
    }


}
