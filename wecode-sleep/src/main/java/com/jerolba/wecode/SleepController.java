package com.jerolba.wecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SleepController {

    @RequestMapping("/sleep")
    public @ResponseBody String home(
            @RequestParam(value = "time", required = false, defaultValue = "200") Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
        return "OK " + time;
    }

}
