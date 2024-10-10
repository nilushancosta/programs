package org.nilushancosta.stack_trace_generator_java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("/read-non-existent-file")
    public ResponseEntity<String> readFile() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("nonexistentfile.txt")));
        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    @GetMapping("/divide-by-zero")
    public double divide()  {
        double result = 6 / 0;
        return result;
    }
}
