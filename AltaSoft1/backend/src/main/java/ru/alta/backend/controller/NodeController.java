package ru.alta.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.alta.backend.model.Node;
import ru.alta.backend.service.NodeService;

@RestController
@RequestMapping("/")
public class NodeController {
    @Autowired
    NodeService nodeService;

    @PostMapping("/")
    public void add(@RequestBody Node node){
        nodeService.add(node);
    }

    @GetMapping("/save")
    public void save(){
        nodeService.save();
    }


}
