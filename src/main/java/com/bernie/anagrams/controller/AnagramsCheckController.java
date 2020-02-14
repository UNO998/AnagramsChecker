package com.bernie.anagrams.controller;

import com.bernie.anagrams.service.AnagramsCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;

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

        log.info("Input String1: {}, String2: {}", string1, string2);

        Optional<Boolean> result = checkService.checkAnagrams(string1, string2);

        log.info("Anagrams check result: {}", result);

        if (result.isPresent()) {

            // return {areAnagrams:true||false} with Json format
            HashMap<String, Boolean> map = new HashMap<>();

            map.put("areAnagrams", result.get());

            return new ResponseEntity<>(map, HttpStatus.OK);

        } else {
            // return 400 bad request when inputting invalid strings
            return new ResponseEntity<>("Input string is invalid", HttpStatus.BAD_REQUEST);

        }
    }
}
