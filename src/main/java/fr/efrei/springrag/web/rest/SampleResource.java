package fr.efrei.springrag.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleResource {

    @GetMapping("/samples/{value}")
    public String sample(@PathVariable (value = "value", required = false) final String value) {
        return "Hello " + value + "!";
    }
}
