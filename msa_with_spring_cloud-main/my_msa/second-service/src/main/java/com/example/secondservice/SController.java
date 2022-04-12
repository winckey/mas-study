package com.example.secondservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/second-service")
@Slf4j
public class SController {
    @GetMapping("/welcom")
    public String welcom() {
        return "weclon 2";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("second-request") String header) {
        log.info(header);

        return "message 2";
    }

}
