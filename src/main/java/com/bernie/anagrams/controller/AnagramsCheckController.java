package com.bernie.anagrams.controller;

import com.bernie.anagrams.service.AnagramsCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnagramsCheckController {

    private final Logger log = LoggerFactory.getLogger(AnagramsCheckController.class);
    private AnagramsCheckService checkService;

    public AnagramsCheckController(AnagramsCheckService anagramsCheckService) {
        this.checkService = anagramsCheckService;
    }

    @GetMapping("/anagrams/{string1}/{string2}")
    ResponseEntity<?> getAnagrams(@PathVariable String string1,
                                  @PathVariable String string2) {
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }
}
