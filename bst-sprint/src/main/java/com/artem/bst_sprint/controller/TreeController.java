package com.artem.bst_sprint.controller;

import com.artem.bst_sprint.dsa.BinarySearchTreeService;
import com.artem.bst_sprint.dsa.TreeResponseDto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.artem.bst_sprint.model.TreeResult;
import com.artem.bst_sprint.repository.TreeResultRepository;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TreeController {

    private final BinarySearchTreeService treeService;
    private final TreeResultRepository treeResultRepository;

    public TreeController(BinarySearchTreeService treeService,
                          TreeResultRepository treeResultRepository) {
        this.treeService = treeService;
        this.treeResultRepository = treeResultRepository;
    }

    // optional: redirect "/" to "/enter-numbers"
    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/enter-numbers";
    }

    // 1) Show the form
    @GetMapping("/enter-numbers")
    public String showEnterNumbersForm() {
        return "enter-numbers";
    }

    // 2) Process numbers and show JSON result
    @PostMapping("/process-numbers")
    public String processNumbers(
            @RequestParam("numbers") String numbersInput,
            Model model
    ) throws JsonProcessingException {

        // build tree DTO using your DSA service
        TreeResponseDto responseDto = treeService.buildTreeResponseFromInput(numbersInput);

        // convert DTO to pretty JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(responseDto);

        // save to database
        TreeResult entity = new TreeResult(numbersInput, json);
        treeResultRepository.save(entity);

        // send data to template
        model.addAttribute("numbersInput", numbersInput);
        model.addAttribute("jsonResult", json);

        return "result"; // name of html file
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
    var results = treeResultRepository.findAll(
            Sort.by(Sort.Direction.DESC, "createdAt")
    );
    model.addAttribute("trees", results);
    return "previous-trees";
}
}