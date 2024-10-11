package org.nilushancosta.stack_trace_generator_java;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(Controller.class);

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

    @GetMapping("/log-with-newline-char")
    public ResponseEntity<String> logWithNewlineChar() {
        System.out.println("This is a log message with a newline character printed using System.out.println. Before newline character\nAfter newline character");
        logger.info("This is a log message with a newline character printed using a log4j logger. Before newline character\nAfter newline character");
        return new ResponseEntity<>("Log message with newline character", HttpStatus.OK);
    }
}
