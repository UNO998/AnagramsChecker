package com.bernie.anagrams.controller;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bernie.anagrams.service.AnagramsCheckService;

/**
 * Test the service of AnagramsCheckController
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AnagramsCheckController.class)
class AnagramsCheckControllerTest {

    @MockBean
    private AnagramsCheckService mockService;

    @Autowired
    private MockMvc mvc;

    @Test
    void getValidTrueAnagrams_shouldReturnTrue() throws Exception {
        when(mockService.checkAnagrams("asdf", "fdsa")).thenReturn(Optional.of(true));

        mvc.perform(
                get("/anagrams/asdf/fdsa"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.areAnagrams", is(true))
                );

    }

    @Test
    void getValidFalseAnagrams_shouldReturnFalse() throws Exception {
        when(mockService.checkAnagrams("asdf", "fff")).thenReturn(Optional.of(false));

        mvc.perform(
                get("/anagrams/asdf/fff"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.areAnagrams", is(false))
                );

    }

    @Test
    void getInvalidAnagrams_shouldReturnBadRequest() throws Exception {
        when(mockService.checkAnagrams("asdf", "ff_!@#$%f")).thenReturn(Optional.empty());

        mvc.perform(
                get("/anagrams/asdf/ff_!@#$%f"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Input string is invalid"))
                );

    }


}
