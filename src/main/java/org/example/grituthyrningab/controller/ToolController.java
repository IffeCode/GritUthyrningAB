package org.example.grituthyrningab.controller;

import jakarta.validation.Valid;
import org.example.grituthyrningab.model.Tool;
import org.example.grituthyrningab.service.ToolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tool/")
public class ToolController {

    private ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/")
    public List<Tool> listTool(){
        return toolService.listAll();
    }

    @GetMapping("/{id}")
    public Tool get(@PathVariable Long id){
        return toolService.get(id);
    }

    @PostMapping("/")
    public Tool save(@Valid @RequestBody Tool tool){
        return toolService.save(tool);
    }


}
