package org.huang.sleuth.track1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final static Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/trace-1", method = RequestMethod.GET)
    public String trace1() {
        log.info(" = = = <call trace-1> == = ");
        return " Return ===call trace-1 === ";
    }
}
