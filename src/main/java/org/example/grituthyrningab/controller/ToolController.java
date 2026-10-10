package org.example.grituthyrningab.controller;

import org.example.grituthyrningab.service.ToolService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tool/")
public class ToolController {

    private ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }





}
