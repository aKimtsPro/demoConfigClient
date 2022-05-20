package com.example.democonfig.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
public class TestController {

    private final StreamBridge streamBridge;

    public TestController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("/test")
    public void send(){
        log.info("SENDING: data");
        streamBridge.send("output-out-0", "data");
    }
}
