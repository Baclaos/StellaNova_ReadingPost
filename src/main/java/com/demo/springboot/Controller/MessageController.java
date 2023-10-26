package com.demo.springboot.Controller;

import com.demo.springboot.Model.*;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.util.*;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/welcome")
    public Greeting greeting(MessageModel message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting(HtmlUtils.htmlEscape(message.getName()) +" says: " +HtmlUtils.htmlEscape(message.getMessage()));
    }

}
