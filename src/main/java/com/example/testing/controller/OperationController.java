package com.example.testing.controller;

import com.example.testing.exception.InvalidNumberException;
import com.example.testing.service.OperationService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/operation")
public class OperationController {

    private static final Logger logger = getLogger(OperationController.class);

    @Autowired
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("x") int x, @RequestParam("y") int y) {
        int result = 0;
        String message = "";

        try {
            result = operationService.addition(x, y);
            message = "Addition of x=" + x + " and y=" + y + " is " + result;
            logger.info(message);
        } catch (InvalidNumberException e) {
            message = e.getMessage();
            logger.error(message);
        }

        return message;
    }
}
