package br.com.tas.tracker.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping(value = "/")
    public ModelAndView helloWorld(){
        ModelAndView model = new ModelAndView("HelloWorld");
        return model;
    }

}
