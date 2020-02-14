package com.bernie.anagrams.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test the service of AnagramsCheckService
 */
@SpringBootTest
public class AnagramsServiceTest {

    @Autowired
    private AnagramsCheckService checkService;

    /*
     * return Optional[true] when input str1="aSd f", str2="fs da"
     */
    @Test
    public void inputValid_AnagramsPair_shouldReturnTrue() {

        Optional<Boolean> opt = checkService.checkAnagrams("aSd f", "fs da");
        if (opt.isPresent()) {
            assertEquals(true, opt.get());
        } else {
            assertTrue(false);
        }
    }

    /*
     * return Optional.empty when input str1="asd-f", str2="fs da"
     */
    @Test
    public void inputInvalid_NotAnagramsPair_shouldReturnEmpty() {

        Optional<Boolean> opt = checkService.checkAnagrams("asd-f", "fs da");
        if (opt.isPresent()) {
            assertTrue(false);
        } else {
            assertTrue(true);
        }
    }

    /*
     * return Optional[false] when input str1="asd f", str2="fs daq"
     */
    @Test
    public void inputValid_NotAnagramsPair_shouldReturnFalse() {

        Optional<Boolean> opt = checkService.checkAnagrams("asd f", "fs daq");
        if (opt.isPresent()) {
            assertEquals(false, opt.get());
        } else {
            assertTrue(false);
        }
    }


}
