package com.example.frirstservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class fController {
    @GetMapping("/welcom")
    public String welcom() {
        return "weclon 1";
    }

    @GetMapping("/message")// 헤더에 어떤값이 오는지 확인 maping 되어 온다
    public String message(@RequestHeader("first-request") String header) {
        log.info(header);

        return "message 1";
    }
    @GetMapping("/check")// 헤더에 어떤값이 오는지 확인 maping 되어 온다
    public String check() {

        log.info("check");
        return "check";
    }
}
