package grails.xml.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcController {
    @RequestMapping(value = "/mvc/test.dispatch", method = RequestMethod.GET)
    public ModelAndView getText() {
        System.out.println("IN MvcController..");
        return new ModelAndView("/mvc/test", new ModelMap("text", "from MVC controller"));
    }
}