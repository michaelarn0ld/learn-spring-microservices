package io.michaelarnold.limitsservice.controller;

import io.michaelarnold.limitsservice.bean.Limits;
import io.michaelarnold.limitsservice.configuration.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Config configuration;

    @GetMapping("/limits")
    public Limits getLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
