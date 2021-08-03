package org.huang.sleuth.track2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final static Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/trace-2", method = RequestMethod.GET)
    public String trace() {
        log.info(" = = = <call trace-2> == = ");
        return " Return ===call trace-2 === ";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String trace2(@RequestParam String name) {
        log.info(" = = = <call trace-2 hi> == = ");
        return "trace-2 hi: " + name;
    }
}
